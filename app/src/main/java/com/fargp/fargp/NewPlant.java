package com.fargp.fargp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewPlant extends AppCompatActivity {
    private EditText plantName;
    private EditText scientificName;
    private EditText type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plant);
        plantName = findViewById(R.id.PlantN1);
        scientificName = findViewById(R.id.ScientificN1);
        type = findViewById(R.id.TypeN1);

    }

    //ToDo: let the user type in the information

    //ToDo: save the information to JSON.
    public void onClickSave(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("FarGp", MODE_PRIVATE);
        String json = sharedPreferences.getString("PLANTS", "{\"plants\":[]}");
        try {
            JSONObject object = new JSONObject(json);
            JSONArray plants = object.getJSONArray("plants");

            JSONObject plant = new JSONObject();
            plant.put("pname", plantName.getText().toString());
            plant.put("sname", scientificName.getText().toString());
            plant.put("tname", type.getText().toString());

            plants.put(plant);
            SharedPreferences.Editor saver = sharedPreferences.edit();
            saver.putString("PLANTS", object.toString());
            // TODO show plant information

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    //ToDo: load the information edited.
}
//ToDo: the intent, make sure the ui can switch by the button