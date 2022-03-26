package com.list.agendalist;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.list.agendalist.dao.ContactDAO;

public class ContactFormActivity extends AppCompatActivity {

    private EditText fieldName;
    private EditText fieldPhone;
    private EditText fieldBday;
    private EditText fieldEmail;
    ContactDAO dao = new ContactDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        initializeFields();

        //Calls the Action Bar
        toolBar();

        //Create the Listener on the reference to the Button
        saveButton();

    }

    private void saveButton() {
        Button saveButton = findViewById(R.id.activity_contact_form_button);
        //Class to set behavior of the button onClick with Lambda
        saveButton.setOnClickListener(view -> {
//                Toast.makeText(ContactFormActivity.this, "A B C D E F",Toast.LENGTH_LONG).show();
            Contact contact = createContact();
//                Toast.makeText(ContactFormActivity.this, contact.getName() + " - " + contact.getPhone() + " - " + contact.getBday() + " - " + contact.getEmail(), Toast.LENGTH_SHORT).show();
            saveContact(contact, dao);
        });
    }

    private void initializeFields() {
        //Get the fields by ID
        fieldName = findViewById(R.id.activity_contact_form_name);
        fieldPhone = findViewById(R.id.activity_contact_form_phone);
        fieldBday = findViewById(R.id.activity_contact_form_bday);
        fieldEmail = findViewById(R.id.activity_contact_form_email);
    }

    private void saveContact(Contact contact, ContactDAO dao) {
        dao.saveContact(contact);

        finish();
    }

    @NonNull
    private Contact createContact() {
        String name = fieldName.getText().toString();
        String phone = fieldPhone.getText().toString();
        String email = fieldEmail.getText().toString();
        String bday = fieldBday.getText().toString();

        Contact contact = new Contact(name, phone, bday, email);
        return contact;
    }

    public void toolBar() {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E65232")));
        actionBar.setTitle(Html.fromHtml("<font color='#FFFFFF'>Add Contact</font>"));
    }

}