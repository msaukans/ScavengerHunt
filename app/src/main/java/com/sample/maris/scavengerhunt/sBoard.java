package com.sample.maris.scavengerhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

import android.widget.ArrayAdapter;

public class sBoard extends AppCompatActivity {
    TextView tv1SBoard;
    ListView lv1SBoard;
    ArrayAdapter adapter;

    ListView list1;
    private Button btn1;
    private Firebase mRoofRef;
    ArrayList <String>arr = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_board);

        list1 = (ListView) findViewById(R.id.lv1SBoard);
        Firebase.setAndroidContext(this);
        tv1SBoard = (TextView) findViewById(R.id.tv1SBoard);


        mRoofRef = new Firebase("https://fir-authentication-5c0ce.firebaseio.com/users");
        final ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);

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
    }
}
