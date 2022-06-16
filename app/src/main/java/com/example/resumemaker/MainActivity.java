package com.example.resumemaker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {



    String[] CityArray = {"Surat", "Rajkot", "Vadodara", "Ahmedabad", "Bhavnagar", "Gandhinagar", "Jamnagar"};
    Spinner spinnerCity;
    AppCompatButton btnSubmit;
    RadioGroup RadioGroup;
    String gender = "";
    String CheckBox = "";
    String Hobbies = "";
    CheckBox cbCreativity, cbCommunication, cbTeamwork, cbLeadership, cbPhotography, cbReading, cbDancing, cbPlaying;
    EditText edtFirstName, edtLastName, edtEmail, edtNumber, edtAddress, edtSchName, edtClgName, edtSelf,edtLanguage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }



    private void initview() {
        btnSubmit = findViewById(R.id.btnSubmit);
        spinnerCity = findViewById(R.id.spinnerCity);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);
        edtNumber = findViewById(R.id.edtNumber);
        edtAddress = findViewById(R.id.edtAddress);
        edtSchName = findViewById(R.id.edtSchName);
        edtClgName = findViewById(R.id.edtClgName);
        edtSelf = findViewById(R.id.edtSelf);
        RadioGroup = findViewById(R.id.radioGroup);
        cbCreativity = findViewById(R.id.cbCreativity);
        cbCommunication = findViewById(R.id.cbCommunication);
        cbTeamwork = findViewById(R.id.cbTeamwork);
        cbLeadership = findViewById(R.id.cbLeadership);
        cbPhotography = findViewById(R.id.cbPhotography);
        cbReading = findViewById(R.id.cbReading);
        cbDancing = findViewById(R.id.cbDancing);
        cbPlaying = findViewById(R.id.cbPlaying);
        edtLanguage = findViewById(R.id.edtLanguage);




        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, CityArray);
        spinnerCity.setAdapter(adapter);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckBox = "";
                String Firstname = edtFirstName.getText().toString();
                String Lastname = edtLastName.getText().toString();
                String Email = edtEmail.getText().toString();
                String Number = edtNumber.getText().toString();
                String Address = edtAddress.getText().toString();
                String SchoolName = edtSchName.getText().toString();
                String CollageName = edtClgName.getText().toString();
                String Language = edtLanguage.getText().toString();
                String AboutYourSelf = edtSelf.getText().toString();
                String CityArray = spinnerCity.getSelectedItem().toString();



                if (cbCreativity.isChecked()) {
                    CheckBox += cbCreativity.getText().toString();
                }
                if (cbCommunication.isChecked()) {
                    CheckBox += cbCommunication.getText().toString();
                }
                if (cbTeamwork.isChecked()) {
                    CheckBox += cbTeamwork.getText().toString();
                }
                if (cbLeadership.isChecked()) {
                    CheckBox += cbLeadership.getText().toString();
                }




                if (cbPhotography.isChecked()) {
                    Hobbies += cbPhotography.getText().toString();
                }
                if (cbReading.isChecked()) {
                    Hobbies += cbReading.getText().toString();
                }
                if (cbDancing.isChecked()) {
                    Hobbies += cbDancing.getText().toString();
                }
                if (cbPlaying.isChecked()) {
                    Hobbies += cbPlaying.getText().toString();
                }




                if (Firstname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Firstname", Toast.LENGTH_SHORT).show();
                } else if (Lastname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Lastname", Toast.LENGTH_SHORT).show();
                } else if (Email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                } else if (Number.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                } else if (Address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Address", Toast.LENGTH_SHORT).show();
                } else if (SchoolName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter SchoolName", Toast.LENGTH_SHORT).show();
                } else if (CollageName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter CollageName", Toast.LENGTH_SHORT).show();
                } else if (Language.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Language", Toast.LENGTH_SHORT).show();
                } else if (gender.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Select Gender", Toast.LENGTH_SHORT).show();
                } else if (CityArray.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Select City", Toast.LENGTH_SHORT).show();
                } else if (AboutYourSelf.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter AboutYourSelf", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();



                    Intent i = new Intent(MainActivity.this, Dashboard_Activity.class);
                    i.putExtra("Firstname", Firstname);
                    i.putExtra("Lastname", Lastname);
                    i.putExtra("Email", Email);
                    i.putExtra("Number", Number);
                    i.putExtra("Address", Address);
                    i.putExtra("SchoolName", SchoolName);
                    i.putExtra("CollageName", CollageName);
                    i.putExtra("Language",Language);
                    i.putExtra("Gender", gender);
                    i.putExtra("AboutYourSelf", AboutYourSelf);
                    i.putExtra("Skill", CheckBox);
                    i.putExtra("Hobbies", Hobbies);
                    i.putExtra("City", CityArray);
                    startActivity(i);
                }
            }
        });



        RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = RadioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = RadioGroup.findViewById(checkedId);

                if (radioButton.getText().equals("Male")) {
                    gender = "Male";
                } else if (radioButton.getText().equals("Female")) {
                    gender = "Female";
                } else {
                    gender = "Other";
                }
            }
        });
    }
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit App");
        builder.setMessage("Do you want to exit an App?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                MainActivity.this.finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });

        AlertDialog d = builder.create();
        d.setCancelable(false);
        d.show();
    }

}