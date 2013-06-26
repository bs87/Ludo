package com.example.ludoWebservice;

//import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.example.ludoWebservice.User;

//import android.util.Log;
import android.util.Log;



public class LudoWebserviceStub implements ILudoWebservice {



	private static final String NAMESPACE = "http://LudoOnline.example.com/";

	/**
	 * The WSDL URL. Its value is the location attribute of the soap:address element for a port
	 * element in a WSDL. Unless the web service is also hosted on the Android device, the hostname 
	 * should not be specified as localhost, because the application runs on the Android device while 
	 * the web service is hosted on the localhost server. Specify hostname as the IP address of the 
	 * server hosting the web service (or "10.0.2.2 instead of 'localhost' when running in the emulator). 
	 */
    private static final String URL = "http://10.0.2.2:8080/LudoSystem/LudoOnlineIntegrationImpl";

    /**
	 * TAG contains the class name and is used for logging.
	 */
    private static final String TAG = LudoWebserviceStub.class.getName();
    private int sessionId;
    private User currentUser=null; 				//Provides a local copy of the current User
    private Game currentGame=null;				//Provides a local copy of the current Game
    private GameMove currentGameMove = null;	//Provides a local copy of the current GameMove
    
    /*@Override
	public GameMove getGameMove (Integer gameID){
    	Log.d(TAG,"getGameMove called.");	
    	Set<GameMove> result = new HashSet<GameMove>();
    	String METHOD_NAME = "spielzug";
    	SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME, gameID);
    	Log.d(TAG, response.toString());
		for (int i=1; i<response.getPropertyCount(); i++) {
			SoapObject soapGameEntry = (SoapObject) response.getProperty(i);
			SoapPrimitive soapField = (SoapPrimitive) soapGameEntry.getProperty("field");
			SoapPrimitive soapSpieler = (SoapPrimitive) soapGameEntry.getProperty("spieler");
			GameMove spielzug = new GameMove();
			spielzug.setGameID(Integer.valueOf(soapField.toString()));
			spielzug.setNumberOfPlayer(Integer.valueOf(soapSpieler.toString()));
			result.add(spielzug);
		}
		return result;	
    }*/
    /**
   	 * Diese Methode akzeptiert einen Anfrage 
   	 * @params gameID
   	 */  
       @Override
       public void acceptInvite (int gameID){
    	   String METHOD_NAME = "acceptInvite";
    	   Object response = executeSoapAction(METHOD_NAME, gameID, currentUser.getUserName());
    	   Log.d(TAG, response.toString());   	   
       }
    
    
    /**
	 * Diese Methode erhält eine Liste mit den eingeloggten 
	 * @return Hashset of UserNames
	 */  
    @Override
    public Set<User> getUser(){
    	String METHOD_NAME = "getUsers";
    	Set<User> result = new HashSet<User>();
    	SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME);
    	Log.d(TAG, response.toString());
    	for (int i=1; i<response.getPropertyCount(); i++) {
			SoapObject soapUserEntry = (SoapObject) response.getProperty(i);
			SoapPrimitive soapUserName = (SoapPrimitive) soapUserEntry.getProperty("userName");
			User nutzer = new User(soapUserName.toString());
			result.add(nutzer);
		}
		return result;
    }
    
    
    /**
 	 * Diese Methode erhält eine Liste mit den eingeloggten 
 	 * @return Hashset of UserNames
 	 */
    @Override
    public Set<User> getHighScore(){
    	String METHOD_NAME = "getHighScore";
    	Set<User> result = new HashSet<User>();
    	SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME);
    	Log.d(TAG, response.toString());
    	for (int i=1; i<response.getPropertyCount(); i++) {
			SoapObject soapUserEntry = (SoapObject) response.getProperty(i);
			SoapPrimitive soapUserName = (SoapPrimitive) soapUserEntry.getProperty("userName");
			int rank = Integer.parseInt(((SoapObject) response).getPrimitivePropertySafelyAsString("userRank"));
			int punkte = Integer.parseInt(((SoapObject) response).getPrimitivePropertySafelyAsString("punkte"));
			User nutzer = new User(soapUserName.toString(),rank, punkte);
			result.add(nutzer);
		}
		return result;
    }
    
    
    
	/**
	 * Diese Methode führt die registrierung sowie anschließendem Login durch. 
	 * @param username, password
	 * @return User
	 */ 
	@Override
	public User registerWeb(String username, String password) {
		String METHOD_NAME = "register";
		this.sessionId = (Integer) null;
		//System.out.println(username+"webservicestubusername-------------------------------"+password);

		Object response = executeSoapAction(METHOD_NAME, username, password);
		
		Log.d(TAG, response.toString());
		this.sessionId = Integer.parseInt(((SoapObject) response).getPrimitivePropertySafelyAsString("sessionId"));
		
		User result = new User(username, password, this.sessionId);
		currentUser = result;
		return result;
	}
    
    
    
    /**
	 * Diese Methode führt das Würfeln auf dem Server aus
	 * @return int
	 */  
    @Override
    public int wuerfeln(int gameID){
    	int result = (Integer) null;
    	String METHOD_NAME = "doWuerfeln";
    	SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME, sessionId, gameID);
    	Log.d(TAG, response.toString());
    	result = Integer.parseInt(((SoapObject) response).getPrimitivePropertySafelyAsString("zahl"));
    	return result;	
    }
    
    
    /**
	 * Diese Methode lädt einen Spieler in ein Spiel ein
	 * @params String username, int gameID
	 */  
    @Override
    public void invite(String userName, int gameID){
    	String METHOD_NAME = "doInvite";
    	Object response = executeSoapAction(METHOD_NAME, userName, gameID);
    	Log.d(TAG, response.toString());
    }
    
    
	/**
	 * Diese Methode führt einen Spielzug auf dem Server aus
	 * @param figur, feld
	 */  
    @Override
    public void doSpielzug(int figur,int feld, int gameID){
    	String METHOD_NAME = "doSpielzug";
    	Object response = executeSoapAction(METHOD_NAME,figur ,feld, gameID, sessionId);
    	Log.d(TAG, response.toString());
    }
    
    
    /**
	 * Diese Methode empfängt den aktuellen Spielstand
	 * @param gameID
	 * @return currentGameMove
	 */  
    @Override
    public GameMove getSpiel(int gameID){
    	String METHOD_NAME = "getSpiel";
    	SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME, gameID);
    	Log.d(TAG, response.toString());
    	SoapObject feld = (SoapObject) response.getProperty("felder");
    	SoapObject spieler = (SoapObject) response.getProperty("spieler");	
    	
    	GameMove spielzug;
    	int[] hilfsfeld = new int[40];
    	int[][] hilfsspieler = new int[4][9];
    	//Nimmt das Spielfeld-Array entgegen
    	for (int i=1; i<feld.getPropertyCount(); i++) {
			SoapObject soapFeldEntry = (SoapObject) response.getProperty(i);
			hilfsfeld[i] = Integer.parseInt(((SoapObject) soapFeldEntry).getPrimitivePropertySafelyAsString("felder"));	
    	}
    	//Nimmt das Spieler- Array entgegen
    	for (int i=1; i<spieler.getPropertyCount(); i++) {
			SoapObject soapSpielerEntry = (SoapObject) response.getProperty(i);
			for (int j=1; j<soapSpielerEntry.getPropertyCount(); j++) {
				hilfsspieler[i][j] = Integer.parseInt(((SoapObject) soapSpielerEntry).getPrimitivePropertySafelyAsString("spieler"));
			}
    	}
    	spielzug = new GameMove(gameID,hilfsfeld,hilfsspieler);  	
    	//Fügt die Spieler hinzu
		for (int i=1; i<response.getPropertyCount(); i++) {
			SoapObject soapPlayerNameEntry = (SoapObject) ((SoapObject) response).getProperty(i);
			SoapPrimitive soapPlayerName = (SoapPrimitive) soapPlayerNameEntry.getProperty("spielerNamen");
			spielzug.addPlayer(soapPlayerName.toString());
		}
		//Fügt das kicked-Flag hinzu
		SoapPrimitive soapKicked = (SoapPrimitive) response.getProperty("kicked");
		int kicked = Integer.valueOf(soapKicked.toString());
		//spielzug.addKickedFlag(kicked);
		
		//Fügt das started-Flag hinzu
		SoapPrimitive soapStarted = (SoapPrimitive) response.getProperty("started");
		int started = Integer.valueOf(soapStarted.toString());
		//spielzug.addStartedFlag(started);
		
		//Fügt das Spielleiter-Ingame-Flag hinzu
		SoapPrimitive soapLeiterInGame = (SoapPrimitive) response.getProperty("leiterInGame");
		int inGame = Integer.valueOf(soapLeiterInGame.toString());
		//spielzug.addLeiterInGameFlag(inGame);
		
		//Fügt das die SpielerAnzahl hinzu
		SoapPrimitive soapNumberOfPlayer = (SoapPrimitive) response.getProperty("anzahl");
		int numberOfPlayer = Integer.valueOf(soapNumberOfPlayer.toString());
		spielzug.setNumberOfPlayer(numberOfPlayer);
		
		//Fügt das Warnung-Flag hinzu
		SoapPrimitive soapWarnung = (SoapPrimitive) response.getProperty("warnung");
		int warnung = Integer.valueOf(soapWarnung.toString());
		spielzug.setWarning(warnung);
		
		
    	currentGameMove = spielzug;
    	return spielzug;
    }
    
    
	/**
	 * Diese Methode führt einen Login auf dem Server durch
	 * @param username, password
	 * @return Game
	 */ 
	@Override
	public User loginweb(String username, String password) {
		User result = null;
		String METHOD_NAME = "login";
		//System.out.println(username+"webservicestubusername-------------------------------"+password);

		Object response = executeSoapAction(METHOD_NAME, username, password);
		
		Log.d(TAG, response.toString());
		this.sessionId = Integer.parseInt(((SoapObject) response).getPrimitivePropertySafelyAsString("sessionId"));
		
		result = new User(username, password, sessionId);
		currentUser = result;
		return result;
	}
	
	
	/**
	 * Diese Methode erstellt ein neues Spiel auf dem Server
	 * @param sessionID
	 * @return Game
	 */
	@Override
	public int createGame(int sessionId, String spielname) {
		
		String METHOD_NAME = "createGame";
		Log.d(TAG, sessionId+"test123");
		int result = Integer.valueOf(executeSoapAction(METHOD_NAME, sessionId,spielname).toString());
		/*SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME, sessionId,spielname);
		Log.d(TAG, response.toString());
		//SoapObject soapGameEntry = (SoapObject) response.getProperty(i);
		SoapObject soapGameEntry = (SoapObject) response;
		SoapPrimitive soapGame = (SoapPrimitive) soapGameEntry.getProperty("id");
		//SoapPrimitive soapPlayer = (SoapPrimitive) soapGameEntry.getProperty("numberOfPlayer");
		int gameID = Integer.valueOf(soapGame.toString());
		String spielLeiter = currentUser.getUserName();
		result = new Game(gameID, spielLeiter);
		
		currentGame = new Game(gameID,spielLeiter);*/
		return result;
	}


	/**
	 * Diese Methode tritt einem bestehendem Spiel bei
	 * @param gameID
	 * @return Game
	 */
	@Override
	public GameMove joinGame (int gameID) {
		String METHOD_NAME = "joinLobby";
		SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME, gameID, sessionId);
		Log.d(TAG, response.toString());
		GameMove game = new GameMove(gameID);
		game = getSpiel(gameID);
		return game;
	}
	
	
	/**
	 * Diese Methode verlässt ein bereits beigetretenes Spiel
	 * @param gameID
	 */
	@Override
	public void leaveGame (int gameID) {
		String METHOD_NAME = "leaveGame";
		Object response = executeSoapAction(METHOD_NAME, gameID, currentUser.getUserName());
		Log.d(TAG, response.toString());
		currentGame = null;
	}
	
	
	/**
	 * Diese Methode führt einen logout auf dem Server durch
	 */
	@Override
	public boolean logout(int sessionId){
		Log.d(TAG,"logout called.");
		String METHOD_NAME = "logout";
		if ( executeSoapAction(METHOD_NAME, sessionId).toString().equals("true")){
		return true;
	}else{
		return false;	
	}
	}
	
	
	/**
	 * Diese Methode nimmt vom Server die Gameliste entgegen
	 * @return GameList
	 */
	@Override
	public Set<Game> getGameList(int sessionId) {
		
		Log.d(TAG, "CreateGame1");
		createGame(sessionId,"testspiel");
		Log.d(TAG, "CreateGame1");
		//createGame();
		Log.d(TAG, "CreateGame2");

		Log.d(TAG,"getGameList called.");		
		Set<Game> result = new HashSet<Game>();
		String METHOD_NAME = "getGameList";
		SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME, sessionId);
		Log.d(TAG, response.toString());
		for (int i=1; i<response.getPropertyCount(); i++) {
			SoapObject soapGameEntry = (SoapObject) response.getProperty(i);
			SoapPrimitive soapGame = (SoapPrimitive) soapGameEntry.getProperty("id");
			SoapPrimitive soapPlayer = (SoapPrimitive) soapGameEntry.getProperty("numberOfPlayer");
			Game spiel = new Game();
			spiel.setGameID(Integer.valueOf(soapGame.toString()));
			spiel.setNumberOfPlayer(Integer.valueOf(soapPlayer.toString()));
			result.add(spiel);
		}
		return result;
	}
	
	/*@Override
	public Integer getNumberOfPlayer(Integer gameID){
		Log.d(TAG,"getNumberOfPlayer called.");
		String METHOD_NAME = "getNumberOfPlayer";
		SoapObject response = (SoapObject) executeSoapAction(METHOD_NAME, sessionId, gameID);
		Log.d(TAG, response.toString());
		return new Integer(response.getPrimitivePropertySafelyAsString("numberOfPlayer"));
	}*/
    
	
	@Override
	public String getHelloString() {
		String Methodname = "sayhello";
		Object result = executeSoapAction(Methodname);
		return result.toString();
	}
	/**
	 * Diese Methode delegiert einen Methodenaufruf an den hinterlegten WebService.
	 * @param methodName
	 * @return
	 */
    
private Object executeSoapAction(String methodName, Object... args) {
		
		Object result = null;
		
	    /* Create a org.ksoap2.serialization.SoapObject object to build a SOAP request. Specify the namespace of the SOAP object and method
	     * name to be invoked in the SoapObject constructor.
	     */
	    SoapObject request = null;
		try{
	     request = new SoapObject(NAMESPACE, methodName);
		}catch(Exception ex)
		{String test = ex.toString(); return null;}
	    
	    /* The array of arguments is copied into properties of the SOAP request using the addProperty method. */
	    for (int i=0; i<args.length; i++) {
		    request.addProperty("arg" + i, args[i]);
	    }
	    
	    /* Next create a SOAP envelop. Use the SoapSerializationEnvelope class, which extends the SoapEnvelop class, with support for SOAP 
	     * Serialization format, which represents the structure of a SOAP serialized message. The main advantage of SOAP serialization is portability.
	     * The constant SoapEnvelope.VER11 indicates SOAP Version 1.1, which is default for a JAX-WS webservice endpoint under JBoss.
	     */
	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11); 
	    
	    /* Assign the SoapObject request object to the envelop as the outbound message for the SOAP method call. */
	    envelope.setOutputSoapObject(request);
	    
	    /* Create a org.ksoap2.transport.HttpTransportSE object that represents a J2SE based HttpTransport layer. HttpTransportSE extends
	     * the org.ksoap2.transport.Transport class, which encapsulates the serialization and deserialization of SOAP messages.
	     */
	    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	    
	    try {
	        /* Make the soap call using the SOAP_ACTION and the soap envelop. */
		    List<HeaderProperty> reqHeaders = null;
	    	@SuppressWarnings({"unused", "unchecked"})
			List<HeaderProperty> respHeaders = androidHttpTransport.call(NAMESPACE + methodName, envelope, reqHeaders);
	
	        /* Get the web service response using the getResponse method of the SoapSerializationEnvelope object.
	         * The result has to be cast to SoapPrimitive, the class used to encapsulate primitive types, or to SoapObject.
	         */
	        result = envelope.getResponse();	        
	        
	        if (result instanceof SoapFault) {
	        	throw (SoapFault) result;
	        }
	    }
	    catch (SoapFault e) {
	    	e.printStackTrace();
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }	    
	    
	  //  return (SoapObject) result;
	    return result;
	}
}
