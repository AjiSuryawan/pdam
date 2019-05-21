package com.tangria.spa.bookingku.Util;

import android.util.Log;

import com.tangria.spa.bookingku.Model.FormRecordModel;

import java.util.UUID;

import io.realm.Realm;

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

    public void insertRecord(String meteran, String imagePath) {
        realm.executeTransactionAsync(realm -> {
            FormRecordModel form = realm.createObject(FormRecordModel.class, UUID.randomUUID().toString());
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

    public void close() {
        realm.close();
    }
}
