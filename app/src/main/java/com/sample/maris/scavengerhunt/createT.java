package com.sample.maris.scavengerhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


public class createT extends AppCompatActivity {

    String t;
    public static ArrayList<String> list;
    EditText ed1;
    Button btn1;
    ListView list1;
    ArrayAdapter<String> adapter1;
    boolean working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_t);

        t = String.valueOf(new Task(""));

        ed1 = (EditText) findViewById(R.id.ed1);
        btn1 = (Button) findViewById(R.id.btn1);
        list1 = (ListView) findViewById(R.id.list1);

        String[] items1 = {"Sing with street musician", "Get a stranger's autograph ", "Do a dramatic earthquake scene in a public place"};
        list = new ArrayList<>(Arrays.asList(items1));
        adapter1 = new ArrayAdapter<String>(this, R.layout.jlist_item, R.id.jtextItem, list);
        list1.setAdapter(adapter1);

        ed1 = (EditText) findViewById(R.id.ed1);
        Button addButton = (Button) findViewById(R.id.btn1);
        //TODO move to a seprate method onClicks
        addButton.setOnClickListener(new View.OnClickListener() {//adds items to first adapter
            public void onClick(View v) {
                t = ed1.getText().toString();
                list.add(t);
                adapter1.notifyDataSetChanged();
                ed1.setText("");
            }

        });

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.get(position);
                //TODO to complete task create method which will open camera to take picture/video
                //TODO of task being completed
                String j = list.get(position).toString().trim();
                list.remove(position);
                Toast.makeText(getApplicationContext(), j + " complete", Toast.LENGTH_SHORT).show();
                adapter1.notifyDataSetChanged();
            }
        });
    }//end on create

    protected void onResume() {

        super.onResume();

    }
}
