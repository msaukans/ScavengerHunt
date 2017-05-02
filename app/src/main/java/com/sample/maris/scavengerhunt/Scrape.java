package com.sample.maris.scavengerhunt;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Scrape extends AppCompatActivity {

    public Elements content;
    public ArrayList<String> contentList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    ListView lv;
    SharedPreferences prefs;


    private ProgressDialog spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsoup_list);

        lv = (ListView) findViewById(R.id.jlist1);

        /*spin = new ProgressDialog(this);
        spin.setMessage("Getting Data...");
        spin.show();
        new NewThread().execute();*/


        SharedPreferences settings = getSharedPreferences("PREFS",0);
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2 = (HashSet<String>) settings.getStringSet("list", new HashSet<String>());

        ArrayList<String> mobileArray = new ArrayList<String>(hashSet2);


        adapter = new ArrayAdapter<>(this, R.layout.jlist_item,R.id.jtextItem ,mobileArray);
        lv.setAdapter(adapter);
    }//end onCreate method

/*    public class NewThread extends AsyncTask<String, Void, String>{
        protected String doInBackground(String... arg){

            Document doc;
            try{
                doc = Jsoup.connect("https://www.tripadvisor.ie/Attractions-g186605-Activities-c47-Dublin_County_Dublin.html#ATTRACTION_LIST").get();
                content = doc.select(".listing_title > a");

                contentList.clear();
                for (Element contents: content){
                    contentList.add(contents.text());
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            spin.dismiss();
            return null;

        }//end doInBackground method

        protected void onPostExecute(String result){
            lv.setAdapter(adapter);
        }//end onPostExecutive method

    }//end newThread class*/


}//end Scrape class
