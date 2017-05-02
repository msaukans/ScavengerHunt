package com.sample.maris.scavengerhunt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    ListView list;
    String[] text = {
            "Temple Bar",
            "Google Plus",
            "Twitter",
            "Windows"
    };
    Integer[] imageId = {
            R.mipmap.ic_bar,
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_camera
    };
    Button btn1,btn2,btn3;

    private FirebaseAuth fire;
    private Button logoutBtn;
    private TextView userEmailTv,tv1;
    Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(this);
        //Firebase auth variables initation
        fire = FirebaseAuth.getInstance();
        if(fire.getCurrentUser() !=null){
            //finish();//t
            //startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
        }

        FirebaseUser user = fire.getCurrentUser();
        String user1;
        user1 = user.getEmail();
        //userEmailTv = (TextView) findViewById(R.id.userEmailTv);
        //userEmailTv.setText(getString(R.string.welcome) + " " + user1);

        Firebase.setAndroidContext(this);
        mref = new Firebase("https://fir-authentication-5c0ce.firebaseio.com");

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });//end setOnClickListener*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        tv1 = (TextView) headerView.findViewById(R.id.playerNameNavBar);
        tv1.setText(user1);
        /////////////////////////// ListView code starts ////////////////////////////////
        /*CustomList adapter = new CustomList(MainActivity.this, text, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, text[+position] + "\n 5 points", Toast.LENGTH_SHORT).show();

            }
        });*/




    }//end onCreate method

    public void onClick(View v) {
        if(v == btn1){
            startActivity(new Intent(MainActivity.this,MapsActivity.class));
            //Boolean started = true;
            //SharedPreferences sp = getSharedPreferences("start", Context.MODE_PRIVATE);
            //SharedPreferences.Editor editor = sp.edit();

        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //new
   /* public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        RelativeLayout content_view = (RelativeLayout)findViewById(R.id.content_main);
        switch (item.getItemId()){
            case R.id.action_settings:
                return true;
            case R.id.menu_Red:
                if (item.isChecked()){
                    item.setChecked(false);
                }
                else
                    item.setChecked(true);
                content_view.setBackgroundColor(Color.RED);
                return true;

            case R.id.menu_Green:
                if (item.isChecked()){
                    item.setChecked(false);
                }
                else
                    item.setChecked(true);
                content_view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_White:
                if (item.isChecked()){
                    item.setChecked(false);
                }
                else
                    item.setChecked(true);
                content_view.setBackgroundColor(Color.WHITE);
                return true;

            case R.id.menu_Yellow:
                if (item.isChecked()){
                    item.setChecked(false);
                }
                else
                    item.setChecked(true);
                content_view.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }//end method onOptionsItemSelected*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_createT){
            startActivity(new Intent(MainActivity.this,createT.class));//create new task
        } else if (id == R.id.nav_settio) {
            startActivity(new Intent(MainActivity.this,MapsActivity.class));//open map
        }  else if (id == R.id.nav_newTask) {
            this.startActivity(new Intent(MainActivity.this, Scrape.class));//scrape data
        }
        else if (id == R.id.nav_walked) {
            startActivity(new Intent(MainActivity.this,StepCounter.class));//steps taken
        }
        else if(id == R.id.nav_score){//scoreboard
            startActivity(new Intent(MainActivity.this, sBoard.class));
        }
        else if(id == R.id.nav_info){
            startActivity(new Intent(MainActivity.this, Info.class));//information page
        }
        else if(id == R.id.nav_out){//logout
            fire.signOut();
            finish();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }//end onNavigationItemSelected


}//end class MainActivity
