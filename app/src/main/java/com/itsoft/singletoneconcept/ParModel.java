package com.itsoft.singletoneconcept;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Trust on 31-05-2016.
 */

public class ParModel implements Parcelable{

    public String mName;
    public String mDte;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDte() {
        return mDte;
    }

    public void setmDte(String mDte) {
        this.mDte = mDte;
    }

    public ParModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDte);
    }

    public static final Parcelable.Creator<ParModel> CREATOR
            = new Parcelable.Creator<ParModel>() {
        public ParModel createFromParcel(Parcel in) {
            return new ParModel(in);
        }

        public ParModel[] newArray(int size) {
            return new ParModel[size];
        }
    };

    protected ParModel(Parcel in) {
        setmName(in.readString());
        setmDte(in.readString());
    }

}
