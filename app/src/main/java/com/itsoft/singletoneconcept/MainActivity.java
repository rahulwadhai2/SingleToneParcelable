package com.itsoft.singletoneconcept;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TestInterface{
    String[] stockArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Singleton.getInstance().setString("Action");
                Singleton.getInstance().setmName("Data sent");

                List<ParModel> parModels = new ArrayList<>();

                for (int i = 0; i < 2; i++) {
                    ParModel parModel = new ParModel();
                    parModel.setmName("Raj");
                    parModel.setmDte("22/05/201" + i);
                    parModels.add(parModel);
                }
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                intent.putParcelableArrayListExtra("UniqueKey", (ArrayList<? extends Parcelable>) parModels);
                startActivity(intent);


            }
        });


       // ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<String> customerList = new ArrayList<>();

//        for (int i = 0; i < 10; i++) {
//           Customer customer = new Customer();
//
//            customer.setId(i);
//
//            if (i==1) {
//                customer.setName("R");
//            }
//
//
//
//            if (i==2) {
//                customer.setName("R");
//            }
//
//            if (i==6) {
//                customer.setName("R");
//            }else {
//                customer.setName("Tekasa"+i);
//            }
//
//            customerList.add(customer);
//        }

        for (int i = 0; i < 10; i++) {


            if (i==1) {
                customerList.add("R");
            }



            if (i==2) {
                customerList.add("R");
            }

            if (i==6) {
                customerList.add("R");
            }else {
                customerList.add("Tekasa" + i);
            }

        }

        for (int i = 0; i < customerList.size(); i++) {

            Log.e("customerList: ","Name: "+customerList.get(i));

        }
        AutoCompleteTextView customerAutoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTrainingNo_Id);
        stockArr = new String[customerList.size()];
        stockArr = customerList.toArray(stockArr);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stockArr);
        customerAutoComplete.setAdapter(adapter);
        customerAutoComplete.setThreshold(0);
        customerAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                int pos = Arrays.asList(stockArr).indexOf(selected);
                Log.e("pos: ",String.valueOf(pos));
            }
        });


//        AutoCompleteTextView customerAutoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTrainingNo_Id);
//        CustomerAdapter customerAdapter = new CustomerAdapter(this, R.layout.custom_auto, customerList);
//        customerAutoComplete.setAdapter(customerAdapter);
//        customerAutoComplete.setThreshold(0);
//
//        customerAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Log.e("MainActivity: ",String.valueOf(position));
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setIdText(String idText) {

        Log.e("IdText: " ,idText);
    }
}
