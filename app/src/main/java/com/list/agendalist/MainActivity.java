package com.list.agendalist;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setTitle("Contact List");

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E65232")));
        actionBar.setTitle(Html.fromHtml("<font color='#FFFFFF'>Bdays</font>"));

        //contacts is the object (list) that holds the data (strings with names)
//        List<contactBuilder> contacts = new ArrayList<>();
        ArrayList<contactBuilder> contacts = new ArrayList<>();

        ListView contactList = findViewById(R.id.activity_main_contactlist);

        String[] contactName = getResources().getStringArray(R.array.contact_name);
        String[] contactPhone = getResources().getStringArray(R.array.contact_phone);

        for(int i = 0; i < contactName.length; i++) { //not the best implementation, but contactName should have the same length as the other inputs on arrays.xml
            contacts.add(new contactBuilder(contactName[i], contactPhone[i]));
            System.out.println("contact["+i+"]: " + contactName[i] + " " + contactPhone[i]);
        }

        contactList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contactName));

    }

}
