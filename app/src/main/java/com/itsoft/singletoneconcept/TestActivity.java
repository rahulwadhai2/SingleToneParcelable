package com.itsoft.singletoneconcept;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Trust on 30-05-2016.
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.e("TestActivity: ", Singleton.getInstance().getString());

        if (getIntent().getExtras()!=null) {

            ArrayList<ParModel> workorder = getIntent().getParcelableArrayListExtra("UniqueKey");


            for (int i = 0; i <workorder.size() ; i++) {

                Log.e("TestActivity:-->", workorder.get(i).getmDte() + " / " + workorder.get(i).getmName());
            }

            Intent intent = new Intent(TestActivity.this, TestTwo.class);
            startActivity(intent);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



                    Intent intent = new Intent(TestActivity.this, TestTwo.class);
                    startActivity(intent);

            }
        });

    }
}
