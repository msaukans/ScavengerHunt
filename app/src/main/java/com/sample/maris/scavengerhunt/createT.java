package com.sample.maris.scavengerhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


public class createT extends AppCompatActivity implements View.OnClickListener{

    ListView list1;
    private Button btn1;
    private Firebase mRoofRef;
    ArrayList <String>arr = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_t);
        list1 = (ListView) findViewById(R.id.list1);
        Firebase.setAndroidContext(this);

        mRoofRef = new Firebase("https://fir-authentication-5c0ce.firebaseio.com/tasks");
        final ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        //R.layout.list_item
        //android.R.layout.simple_list_item_1
        list1.setAdapter(adapter);


        mRoofRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);

                arr.add(value);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        registerForContextMenu(list1);
    }//end onCreate

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup, menu);
    }//end createContextMenu

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.picture_menu_id:
                arr.get(info.position);
                String j = arr.get(info.position).toString().trim();
                arr.remove(info.position);
                Toast.makeText(getApplicationContext(), j + " complete", Toast.LENGTH_SHORT).show();
                //adapter.notifyDataSetChanged();
                return true;
            case R.id.video_menu_id:
                arr.get(info.position);
                j = arr.get(info.position).toString().trim();
                arr.remove(info.position);
                Toast.makeText(getApplicationContext(), j + " complete", Toast.LENGTH_SHORT).show();
                //adapter.notifyDataSetChanged();
                return true;

        }
        return super.onContextItemSelected(item);
    }//popup menu finalised

    protected void onResume() {

        super.onResume();

    }

    @Override
    public void onClick(View view) {
        /*if(view == btn1){

                    t = ed1.getText().toString();
                    list.add(t);
                    adapter1.notifyDataSetChanged();
                    ed1.setText("");
        }*/
    }//end onClick

}
