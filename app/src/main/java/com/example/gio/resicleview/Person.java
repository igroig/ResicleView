package com.example.gio.resicleview;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gio on 4/1/2016.
 */
 class Person {
    String name;
    String age;
    int photoId;

    Person(JSONObject jObj) throws JSONException {
        this.name = jObj.getString("name").toString();
        this.age = jObj.getString("username").toString();
        this.photoId = R.drawable.icon;
    }


}