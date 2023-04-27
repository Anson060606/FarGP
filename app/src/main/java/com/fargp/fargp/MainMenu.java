package com.fargp.fargp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.fargp.fargp.model.Plant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {
    ArrayList<Plant> plantList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // TODO Find out if a plant was passed in using EXTRA
        String extraPlan = "P1";

        // TODO Find last plant opened
        SharedPreferences sharedPreferences = getSharedPreferences("FarGp", MODE_PRIVATE);
        String Lp = sharedPreferences.getString("LastP", "");

        // TODO Load plant information
        plantList = new ArrayList<>();
        String json = sharedPreferences.getString("PLANTS", "{\"plants\":[]}");
        try {
            JSONObject object = new JSONObject(json);
            JSONArray plants = object.getJSONArray("plants");
            for (int i = 0; i < plants.length(); i++) {

                JSONObject explrObject = plants.getJSONObject(i);
                Plant plant = new Plant();
                plant.setName(explrObject.getString("pname"));
                plant.setName(explrObject.getString("sname"));
                plant.setName(explrObject.getString("tname"));
                plantList.add(plant);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // TODO show plant information


    }
}

//ToDo: the intent, make sure the ui can switch by the button
//ToDo: create buttons:  "Add" for add new plant; "Edit" for Edit Plant information; "Record" for switch to the ui of hieght
//ToDo: make sure the recycle view can work on this.
