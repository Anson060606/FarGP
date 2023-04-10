package com.fargp.fargp.model;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.Image;
import android.util.Log;
import android.view.ViewAnimationUtils;

import org.json.JSONObject;

public class LogSignSystem {
    private String email;
    private String phoneNumber;
    private String password;
    private Image photo;
    private String photoAdress;

    public String getPhotoAdress() {
        return photoAdress;
    }

    public void setPhotoAdress(String photoAdress) {
        this.photoAdress = photoAdress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public static void saveItem(Activity a, int id, LogSignSystem logIn) {
        try {
            SharedPreferences sharedPreferences = a.getSharedPreferences("FarGp", a.MODE_PRIVATE);
            String json = sharedPreferences.getString("JSON", "{}");
            JSONObject object = new JSONObject(json);

            JSONObject logInObject = new JSONObject();
            logInObject.put("email", logIn.getEmail());
            logInObject.put("phoneNumber", logIn.getPhoneNumber());
            logInObject.put("password", logIn.getPassword());
            logInObject.put("photoAdress", logIn.getPhotoAdress());


        } catch (Exception e) {
            Log.e("JSON Error", "Fail to create JSONObject", e);
        }

    }



}