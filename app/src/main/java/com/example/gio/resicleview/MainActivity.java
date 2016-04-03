package com.example.gio.resicleview;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gio.resicleview.ConnectionManager.GetJsonTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements iDataManager {

    private List<Person> persons;
    private RecyclerView rv;

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);  // context
        rv.setLayoutManager(llm);
//        rv.setHasFixedSize(true); //If you are sure that the size of the RecyclerView won't be changing, you can add the following to improve performance:


        dataManager = new DataManager();
        dataManager.getPersons(this);
    }


    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);

    }


    @Override
    public void didGetPersons(List<Person> persons) {

        this.persons = persons;
        initializeAdapter();
    }
}