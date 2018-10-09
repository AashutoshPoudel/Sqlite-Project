package com.planetearthsolution.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserToDatabase extends AppCompatActivity {

    private EditText fnEdt;
    private EditText mnEdt;
    private EditText lnEdt;
    private EditText genderEdt;
    private EditText dobEdt;
    private EditText citzNoEdt;
    private EditText licenseEdt;
    private EditText phEdt;
    private EditText perAddEdt;
    private EditText occEdt;
    private EditText spouseEdt;
    private EditText fatherNameEdt;
    private EditText fatherContactEdt;
    private EditText motherNameEdt;
    private EditText motherContatEdt;
    private EditText grandfatherNameEdt;

    private Button mAddBtn,convertToExcel;

    private PersonDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_to_database);
        fnEdt=findViewById(R.id.etFirstName);
        mnEdt=findViewById(R.id.etMiddleName);
        lnEdt=findViewById(R.id.etLastName);
        genderEdt=findViewById(R.id.etGender);
        dobEdt=findViewById(R.id.etDob);
        citzNoEdt=findViewById(R.id.etCitizenship);
        licenseEdt=findViewById(R.id.etDrivingCardNo);
        phEdt=findViewById(R.id.etPhoneNumber);
        perAddEdt=findViewById(R.id.etPermanentAddress);
        occEdt=findViewById(R.id.etOccupation);
        spouseEdt=findViewById(R.id.etSpouseName);
        fatherNameEdt=findViewById(R.id.etFatherName);
        fatherContactEdt=findViewById(R.id.etFatherContactNumber);
        motherNameEdt=findViewById(R.id.etMotherName);
        motherContatEdt=findViewById(R.id.etMotherContactNumber);
        grandfatherNameEdt=findViewById(R.id.etGrandFatherName);
        mAddBtn=findViewById(R.id.saveInDbBtn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePerson();
            }
        });
    }

    private void savePerson() {
        String fName = fnEdt.getText().toString().trim();
        String mName = mnEdt.getText().toString().trim();
        String LName = lnEdt.getText().toString().trim();
        String gender = genderEdt.getText().toString().trim();
        String dob = dobEdt.getText().toString().trim();
        String citzNo = citzNoEdt.getText().toString().trim();
        String licenseNo = licenseEdt.getText().toString().trim();
        String phNo = phEdt.getText().toString().trim();
        String permanentAddress = perAddEdt.getText().toString().trim();
        String occupation = occEdt.getText().toString().trim();
        String spouseName = spouseEdt.getText().toString().trim();
        String fatherName = fatherNameEdt.getText().toString().trim();
        String fatherContact = fatherContactEdt.getText().toString().trim();
        String motherName = motherNameEdt.getText().toString().trim();
        String motherContact = motherContatEdt.getText().toString().trim();
        String grandfatherName = grandfatherNameEdt.getText().toString().trim();

        dbHelper = new PersonDBHelper(this);
        Person person = new Person(fName, mName, LName,gender,dob,citzNo,licenseNo,phNo,permanentAddress,occupation,spouseName,fatherName,fatherContact,motherName,motherContact,grandfatherName);
        dbHelper.saveNewPerson(person);
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        goBackHome();

    }

    private void goBackHome(){
        startActivity(new Intent(AddUserToDatabase.this, MainActivity.class));
    }
}
