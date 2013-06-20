package com.example.ludoWebservice;

import java.math.BigDecimal;
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

    
	
	@Override
	public String getLoginDaten(String Username, String Passwort) {
		String Methodname = "checklogin";
		Object result = executeSoapAction(Methodname, Username, Passwort);
		return result.toString();
	}
	
	@Override
	public void logout(){
		Log.d(TAG,"logout called.");
		String METHOD_NAME = "logout";
		SoapObject response = executeSoapAction(METHOD_NAME, sessionId);
		Log.d(TAG, response.toString());
	}
	
	
	@Override
	public Set<Game> getGameList() {
		Log.d(TAG,"getGameList called.");		
		Set<GAme> result = new HashSet<Game>();
		String METHOD_NAME = "getGameList";
		SoapObject response = executeSoapAction(METHOD_NAME, sessionId);
		Log.d(TAG, response.toString());
		//Eigene Konten einlesen:
		for (int i=1; i<response.getPropertyCount(); i++) {
			SoapObject soapGameEntry = (SoapObject) response.getProperty(i);
			SoapPrimitive soapGame = (SoapPrimitive) soapGameEntry.getProperty("id");
			SoapPrimitive soapPlayer = (SoapPrimitive) soapGameEntry.getProperty("numberOfPlayer");
			Game spiel = new Game();
			spiel.setGameID(Integer.valueOf(soapKontoNr.toString()));
			spiel.setNumberOfPlayer(new BigDecimal(soapBetrag.toString()));
			result.add(spiel);
		}
		return result;
	}
	
	@Override
	public Integer getNumberOfPlayer(Integer gameID){
		Log.d(TAG,"getNumberOfPlayer called.");
		String METHOD_NAME = "getNumberOfPlayer";
		SoapObject response = executeSoapAction(METHOD_NAME, sessionId, kontoNr);
		Log.d(TAG, response.toString());
		return new BigDecimal(response.getPrimitivePropertySafelyAsString("numberOfPlayer"));
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
