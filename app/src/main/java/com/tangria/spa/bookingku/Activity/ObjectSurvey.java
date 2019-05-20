package com.tangria.spa.bookingku.Activity;

import android.os.Parcel;
import android.os.Parcelable;
import io.realm.RealmObject;

public class ObjectSurvey extends RealmObject implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    protected ObjectSurvey(Parcel in) {

    }

    public static final Creator<ObjectSurvey> CREATOR = new Creator<ObjectSurvey>() {
        @Override
        public ObjectSurvey createFromParcel(Parcel in) {
            return new ObjectSurvey(in);
        }

        @Override
        public ObjectSurvey[] newArray(int size) {
            return new ObjectSurvey[size];
        }
    };
}
