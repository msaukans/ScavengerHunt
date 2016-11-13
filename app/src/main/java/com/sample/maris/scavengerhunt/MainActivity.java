package com.sample.maris.scavengerhunt;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        /////////////////////////// ListView code starts ////////////////////////////////
        CustomList adapter = new CustomList(MainActivity.this, text, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, text[+position] + "\n 5 points", Toast.LENGTH_SHORT).show();

            }
        });
    }//end onCreate method

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //new
    public boolean onOptionsItemSelected(MenuItem item) {
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
    }//end method onOptionsItemSelected

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_account) { //1

        } else if (id == R.id.nav_gallery) { //2

        } else if (id == R.id.nav_rank) { //3

        } else if (id == R.id.nav_settio) { //4

        } else if (id == R.id.nav_share) { //5
            startActivity(new Intent(MainActivity.this,MapsActivity.class));
        }
        else if (id == R.id.nav_newTask) { //6
            this.startActivity(new Intent(MainActivity.this, Scrape.class));
        }
        else if (id == R.id.nav_walked) {

        }
        else if (id == R.id.nav_out) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }//end onNavigationItemSelected
}//end class MainActivity
