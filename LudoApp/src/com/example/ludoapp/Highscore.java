package com.example.ludoapp;

import java.util.ArrayList;



import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.ListActivity;

public class Highscore extends ListActivity {
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MUCH TIMES BUTTON WAS CLICKED
    int clickCounter=0;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.highscore);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        setListAdapter(adapter);
      
          
   
     
     }
   
      @Override
      protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get the item that was clicked
        Object o = this.getListAdapter().getItem(position);
        String keyword = o.toString();
        //Toast.makeText(this, "Es wurde eine Anfrage an Spielleiter Dummy gesendet " + keyword, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Es wurde eine Anfrage an Spielleiter Dummy gesendet " , Toast.LENGTH_SHORT).show();
      }
    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        listItems.add("Spielleiter22222222222222: Dummy"+clickCounter++ + "Anzahl der Spieler: "+clickCounter++);
        adapter.notifyDataSetChanged();
    }
    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    
}
      
	
   