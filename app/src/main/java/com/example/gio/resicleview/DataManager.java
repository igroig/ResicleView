package com.example.gio.resicleview;

import android.util.Log;

import com.example.gio.resicleview.ConnectionManager.GetJsonTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gio on 4/3/2016.
 */


public class DataManager {
        private iDataManager iDaMng;

       public void getPersons(iDataManager idm) {

           new GetJsonTask(this).execute("http://jsonplaceholder.typicode.com/users");
            iDaMng = idm;

       };


    public void onTaskCompleted(String data){

        List<Person> persons = new ArrayList<>();

        JSONArray jsonArray = null;


        try{
            jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                persons.add(new Person(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        iDaMng.didGetPersons(persons);
    }
}
