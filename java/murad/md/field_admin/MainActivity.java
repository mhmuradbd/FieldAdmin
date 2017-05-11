package murad.md.field_admin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView list;
    String[] titles;
    String [] description;
    int[] imgs = {R.drawable.utility,R.drawable.utility,R.drawable.utility,R.drawable.utility,
            R.drawable.utility,R.drawable.utility


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("মাঠ-প্রাশাসন ও সহযোগী");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//get resource
        Resources res = getResources();
        titles = res.getStringArray(R.array.titles);
        description = res.getStringArray(R.array.description);
        list = (ListView) findViewById(R.id.list1);
        MyAdapter adapter = new MyAdapter(this,titles,imgs,description);
        list.setAdapter(adapter);

//listview get resource

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch(position){
                    case 0:
                        intent = new Intent(getApplicationContext(), List_01.class);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), List_01.class);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), MainActivityExpandable.class);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), List_01.class);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), List_01.class);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), List_01.class);
                        break;
                    default:
                        intent = new Intent(getApplicationContext(), List_01.class);
                        break;
                }

                if(intent != null){
                    startActivity(intent);
                }

            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //listview
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        int [] images;
        String [] mytitles;
        String [] myDescriptions;
        MyAdapter(Context c,String[] titles,int imgs[],String[]desc)
        {
            super(c,R.layout.row,R.id.text1,titles);
            this.context=c;
            this.images=imgs;
            this.mytitles=titles;
            this.myDescriptions=desc;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.row,parent,false);
            ImageView myImage = (ImageView) row.findViewById(R.id.icon);
            TextView myTitle = (TextView) row.findViewById(R.id.text1);
            TextView myDesc = (TextView) row.findViewById(R.id.text2);
            myImage.setImageResource(images[position]);
            myTitle.setText(mytitles[position]);
            myDesc.setText(myDescriptions[position]);
            return row;
        }
    }
        // end of listview

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_menu_aboutUs) {
            startActivity(new Intent(this,About_Us.class));//when click main page about bottom as u see
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_tag) {

        } else if (id == R.id.nav_favbuttom) {

        } else if (id == R.id.nav_art1) {

        } else if (id == R.id.nav_art2) {

        } else if (id == R.id.nav_art3) {
            startActivity(new Intent(this,About_Us.class));
            return true;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
