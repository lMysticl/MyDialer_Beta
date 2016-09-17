package com.example.test;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import static android.R.attr.id;

public class SubActivity extends AppCompatActivity {
    EditText fir_name, sec_name, phone, email, organization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextInputLayout til_1 = (TextInputLayout) findViewById(R.id.textInputLayout1);
        TextInputLayout til_2 = (TextInputLayout) findViewById(R.id.textInputLayout2);
        TextInputLayout til_3 = (TextInputLayout) findViewById(R.id.textInputLayout3);
        TextInputLayout til_4 = (TextInputLayout) findViewById(R.id.textInputLayout4);
        TextInputLayout til_5 = (TextInputLayout) findViewById(R.id.textInputLayout5);
        fir_name = (EditText) findViewById(R.id.editText1);
        sec_name = (EditText) findViewById(R.id.editText2);
        phone = (EditText) findViewById(R.id.editText3);
        email = (EditText) findViewById(R.id.editText4);
        organization = (EditText) findViewById(R.id.editText5);
        til_1.setHint(getString(R.string.First_name));
        til_2.setHint(getString(R.string.Second_name));
        til_3.setHint(getString(R.string.Phone));
        til_4.setHint(getString(R.string.Email));
        til_5.setHint(getString(R.string.Organization));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }


}
