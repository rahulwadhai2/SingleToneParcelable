package com.itsoft.singletoneconcept;

public class Singleton {
    private static Singleton mInstance = null;
    private String mString;
    private String mName;


    private Singleton(){
        mString = "Hello";
    }

    public static Singleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getString(){
        return this.mString;
    }
    public void setString(String value){
        mString = value;
    }
}