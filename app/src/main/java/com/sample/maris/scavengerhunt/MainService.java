package com.sample.maris.scavengerhunt;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class MainService extends Service {
    public static final String BROADCAST_ACTION = "com.websmithing.broadcasttest.displayevent";
    private final Handler handler = new Handler();
    Intent intent;
    int counter = 0;
    ArrayList al;
    int score ;
    public Elements content;
    public ArrayList<String> contentList = new ArrayList<>();

    public MainService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();


        intent = new Intent(BROADCAST_ACTION);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        handler.removeCallbacks(sendUpdatesToUI);
        handler.postDelayed(sendUpdatesToUI, 1000); // 1 second

    }

    private Runnable sendUpdatesToUI = new Runnable() {
        public void run() {
            check();
            updateScore();
            DisplayLoggingInfo();//last, since data is sent

            handler.postDelayed(this, 1000); // 1 seconds

        }
    };

    private void DisplayLoggingInfo() {
        intent.putExtra("counter", String.valueOf(++counter));
        intent.putExtra("score_data", score);
        sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void check(){
        //this method is used for checking whether there is a saved preference for
        //landmark arraylist so the data wouldn't need to be scraped again
        if(score != 0) {
            new NewThread().execute();
        }
        else{
           // Toast.makeText(this, "Check method failed in service class", Toast.LENGTH_SHORT).show();
        }
    }

    public class NewThread extends AsyncTask<String, Void, String> {
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
            return null;

        }//end doInBackground method

    }//end newThread class

    public int updateScore(){
        //counter /60 = minutes
        int minutes  = counter /60;
        score = score + minutes;
        return score;
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(sendUpdatesToUI);
        super.onDestroy();
    }
}
