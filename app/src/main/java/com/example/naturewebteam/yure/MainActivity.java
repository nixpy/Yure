package com.example.naturewebteam.yure;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edtText;
    ListView lstView;
    List<String> strList;
    String[] nameArr;
    ArrayAdapter<String> arrAdapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        edtText = (EditText) findViewById(R.id.editText);
        lstView = (ListView) findViewById(R.id.listView);
        populateList();
        registerClickCallback();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchVal = edtText.getText().toString();
                Toast.makeText(getApplicationContext(), searchVal, Toast.LENGTH_SHORT).show();
                if(searchVal.toString().equals("")) {
                    populateList();
                }
                else {
                    searchItem(searchVal);
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Rietykity Labs", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void searchItem(String searchVal) {
        for(String item:nameArr){
            if(!item.contains(searchVal)){
                strList.remove(item);
            }
        }
        arrAdapt.notifyDataSetChanged();
    }

    private void populateList() {
        nameArr = new String[] {"Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity",
                "Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity",
                "Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity","Golu", "Krishna", "Rietykity"};
        strList = new ArrayList<>(Arrays.asList(nameArr));
        arrAdapt = new ArrayAdapter<String>(this,
                R.layout.list_item, strList);
        lstView.setAdapter(arrAdapt);
    }

    private void registerClickCallback(){
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView txt = (TextView) viewClicked;
                String message = "Yuo clicked # " + position +
                        ", Which is string: " + txt.getText().toString();
                edtText = (EditText) findViewById(R.id.editText);
                edtText.setText(txt.getText().toString());
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG ).show();
            }
        });
    }
}
