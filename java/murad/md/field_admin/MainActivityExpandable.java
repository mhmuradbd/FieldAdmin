package murad.md.field_admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivityExpandable extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("জেলা প্রশাসকদের ইমেইল তালিকা");
        setContentView(R.layout.expandable_list_activity);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView = (ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("ঢাকা");
        listDataHeader.add("সিলেট");
        listDataHeader.add("সুনামগঞ");
        listDataHeader.add("বরিশাল");

        List<String> edmtDev = new ArrayList<>();
        edmtDev.add("ইমেইল-ওয়েবসাইট:dcdhaka@mopa.gov.bd\n" +"www.dhaka.gov.bd");
        edmtDev.add("মোবাইল:01713048580");

        List<String> androidStudio = new ArrayList<>();
        androidStudio.add("ইমেইল-ওয়েবসাইট:dcsylhet@mopa.gov.bd\n"+"www.sylhet.gov.bd");
        androidStudio.add("মোবাইল:01715297405");
        androidStudio.add("অফিস ফোন:0821-716100,0821-810308, 0821-716301, 0821-812082, 0821-811707");


        List<String> xamarin = new ArrayList<>();
        xamarin.add("ইমেইল-ওয়েবসাইট:dcsunamganj@mopa.gov.bd\n"+"www.sunamganj.gov.bd");
        xamarin.add("অফিস ফোন:0871-55301, 0871-61601, 0871-55303, 0871-55302");
        xamarin.add("মোবাইল:01713301178");

        List<String> uwp = new ArrayList<>();
        uwp.add("ইমেইল-ওয়েবসাইট:dcbarisal@ mopa.gov.bd\n" +"www.barisal.gov.bd");
        uwp.add("অফিস ফোন:0431-63866");
        uwp.add("মোবাইল:01819230550");

        listHash.put(listDataHeader.get(0),edmtDev);
        listHash.put(listDataHeader.get(1),androidStudio);
        listHash.put(listDataHeader.get(2),xamarin);
        listHash.put(listDataHeader.get(3),uwp);
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
