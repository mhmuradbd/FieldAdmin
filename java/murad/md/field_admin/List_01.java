package murad.md.field_admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class List_01 extends AppCompatActivity {

    SqlLiteDbHelper dbHelper;
    Contact contacts ;
    TextView mytextview;
    ArrayList<Contact> contList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_01);
        setTitle("মাঠ-প্রাশাসন ও সহযোগী");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mytextview = (TextView) findViewById(R.id.mytextview);
        contList = new ArrayList<>();
        contList.clear();
        dbHelper = new SqlLiteDbHelper(this);
        dbHelper.openDataBase();
        contList = dbHelper.getDetails();
        String msg ="";
        for(int i=0;i<contList.size();i++){

            Contact cont = contList.get(i);
            msg = msg+cont.getName()+"\n"+cont.getHint()+"\n\n\n";
            mytextview.setText(msg);
        }


    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_withhome_icon, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //akan taka about buttom call kora and page openhoy
        if (id == R.id.navigate) {
            startActivity(new Intent(this,MainActivity.class));
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent parentActivityIntent = new Intent(this, MainActivity.class);
                parentActivityIntent.addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(parentActivityIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
