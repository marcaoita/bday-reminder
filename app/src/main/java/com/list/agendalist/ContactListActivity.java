package com.list.agendalist;
//import com.list.agendalist.dao.ContactDAO;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.list.agendalist.dao.ContactDAO;

import java.util.ArrayList;


public class ContactListActivity extends AppCompatActivity {

    ContactDAO dao = new ContactDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar();

//        ListView contactList = findViewById(R.id.activity_main_contactlist);
//        String[] contactName = getResources().getStringArray(R.array.contact_name);
//        String[] contactPhone = getResources().getStringArray(R.array.contact_phone);
        //contacts is the object (list) that holds the data (strings with names)
//        List<contactBuilder> contacts = new ArrayList<>();
//        ArrayList<contactBuilder> contacts = new ArrayList<>();
//        for(int i = 0; i < contactName.length; i++) { //not the best implementation, but contactName elements should have the same length as the other inputs on arrays.xml
//            contacts.add(new contactBuilder(contactName[i], contactPhone[i]));
//            System.out.println("contact["+i+"]: " + contactName[i] + " " + contactPhone[i]);
//        }
//        contactList.setAdapter(new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                contactName));

        fabNewContact();

    }

    private void fabNewContact() {
        FloatingActionButton newContactButton = findViewById(R.id.floatingActionButton);
        newContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContactListActivity.this, ContactFormActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        configureList();

    }

    private void configureList() {
        ListView contactList = findViewById(R.id.activity_main_contactlist);
        contactList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.returnStaticContactList()
        ));
    }

    public void toolBar() {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E65232")));
        actionBar.setTitle(Html.fromHtml("<font color='#FFFFFF'>Bdays</font>"));
    }

}

