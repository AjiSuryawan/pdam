package com.tangria.spa.bookingku.Util;

import android.util.Log;

import com.tangria.spa.bookingku.Activity.FormRecord;
import com.tangria.spa.bookingku.Model.FormRecordModel;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class DatabaseProvider {
    private static DatabaseProvider instance;
    private static Realm realm;

    private DatabaseProvider() {
    }

    public static DatabaseProvider getInstance() {
        if (instance == null)
            instance = new DatabaseProvider();
        realm = Realm.getDefaultInstance();
        return instance;
    }

    public void insertRecord(String name, String meteran, String imagePath) {
        realm.executeTransactionAsync(realm -> {
            FormRecordModel form = realm.createObject(FormRecordModel.class, name);
            form.setMeteran(meteran);
            form.setImagePath(imagePath);

        }, () -> {
            Log.e("", "onSuccess: ");
            realm.close();
        }, error -> {
            Log.e("", "onError: " + error.getLocalizedMessage());
            realm.close();
        } );
    }

    public FormRecordModel getRecordByName(String name){
        return realm.where(FormRecordModel.class)
                .equalTo("id", name)
                .findFirst();
    }

    public boolean isSubmitted(String name){
        FormRecordModel result = realm.where(FormRecordModel.class)
                .equalTo("id", name)
                .findFirst();
        if(result != null){
            realm.close();
            return true;
        } else {
            realm.close();
            return false;
        }
    }
    public void close() {
        realm.close();
    }
}
