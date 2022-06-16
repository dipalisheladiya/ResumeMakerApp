package com.example.resumemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dashboard_Activity extends AppCompatActivity {

    String Firstname, Lastname, Email, Number, Address, SchoolName, CollageName,Language, AboutYourSelf, gender, CheckBox, Hobbies, Spinner;
    TextView txtFirstname, txtLastname, txtNumber, txtEmail, txtAddress, txtSchoolName, txtClgName, txtAboutYourSelf, txtGender, txtSkill, txtHobbies, txtCity, txtLanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtFirstname = findViewById(R.id.txtFirstname);
        txtLastname = findViewById(R.id.txtLastname);
        txtNumber = findViewById(R.id.txtNumber);
        txtEmail = findViewById(R.id.txtEmail);
        txtAddress = findViewById(R.id.txtAddress);
        txtSchoolName = findViewById(R.id.txtSchoolName);
        txtClgName = findViewById(R.id.txtClgName);
        txtAboutYourSelf = findViewById(R.id.txtAboutYourSelf);
        txtGender = findViewById(R.id.txtGender);
        txtSkill = findViewById(R.id.txtSkill);
        txtHobbies = findViewById(R.id.txtHobbies);
        txtCity = findViewById(R.id.txtCity);
        txtLanguage = findViewById(R.id.txtLanguage);

        if (getIntent() != null) {
            Firstname = getIntent().getStringExtra("Firstname");
            Lastname = getIntent().getStringExtra("Lastname");
            Email = getIntent().getStringExtra("Email");
            Number = getIntent().getStringExtra("Number");
            Address = getIntent().getStringExtra("Address");
            SchoolName = getIntent().getStringExtra("SchoolName");
            CollageName = getIntent().getStringExtra("CollageName");
            Language = getIntent().getStringExtra("Language");
            gender = getIntent().getStringExtra("Gender");
            AboutYourSelf = getIntent().getStringExtra("AboutYourSelf");
            CheckBox = getIntent().getStringExtra("Skill");
            Hobbies = getIntent().getStringExtra("Hobbies");
            Spinner = getIntent().getStringExtra("City");

            txtFirstname.setText(Firstname);
            txtLastname.setText(Lastname);
            txtNumber.setText(Number);
            txtEmail.setText(Email);
            txtAddress.setText(Address);
            txtSchoolName.setText(SchoolName);
            txtClgName.setText(CollageName);
            txtLanguage.setText(Language);
            txtAboutYourSelf.setText(AboutYourSelf);
            txtGender.setText(gender);
            txtSkill.setText(CheckBox);
            txtHobbies.setText(Hobbies);
            txtCity.setText(Spinner);

        }

    }
}