package com.itsoft.singletoneconcept;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

/**
 * Created by Trust on 30-05-2016.
 */
public class TestTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.e("TestTwo: ", Singleton.getInstance().getString());
        Log.e("TestTwo: ", Singleton.getInstance().getmName());
    }
}
