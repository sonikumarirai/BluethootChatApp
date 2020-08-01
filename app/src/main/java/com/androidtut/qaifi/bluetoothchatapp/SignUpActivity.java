package com.androidtut.qaifi.bluetoothchatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class SignUpActivity extends AppCompatActivity {


    EditText et_name, et_address, et_email, et_phone_no, et_password;
    Button btn_signUp;

    /*--for validation--*/
    private EditText flagEditfield;
    private boolean isGPS;
    private String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        register();

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkValidation()) {
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    private boolean checkValidation() {
        if (et_name.getText().toString().trim().equalsIgnoreCase("")||et_name.getText().toString().length()<4) {
            flagEditfield = et_name;
            msg = "Enter valid name, must contain atleast 4 characters!";
            flagEditfield.setError(msg);
            et_name.requestFocus();
            return false;
        } else if (et_address.getText().toString().trim().equalsIgnoreCase("")||et_address.getText().toString().length()<10) {
            flagEditfield = et_address;
            msg = "Enter valid address, must contain atleast 10 characters!";
            flagEditfield.setError(msg);
            et_address.requestFocus();
            return false;
        }else if (et_email.getText().toString().trim().equalsIgnoreCase("")) {
            flagEditfield = et_email;
            msg = "Please enter email!";
            flagEditfield.setError(msg);
            et_email.requestFocus();
            return false;
        }else if (et_phone_no.getText().toString().trim().equalsIgnoreCase("")||et_phone_no.getText().toString().length()<10) {
            flagEditfield = et_phone_no;
            msg = "Please enter phone no.!";
            flagEditfield.setError(msg);
            et_phone_no.requestFocus();
            return false;
        }else if (et_password.getText().toString().trim().equalsIgnoreCase("")||et_password.getText().toString().length()<8||et_password.getText().toString().length()>15) {
            flagEditfield = et_password;
            msg = "Please enter password!";
            flagEditfield.setError(msg);
            et_password.requestFocus();
            return false;
        }
        return true;

    }




    private void register() {

        et_name=findViewById(R.id.et_name);
        et_address=findViewById(R.id.et_address);
        et_email=findViewById(R.id.et_email);
        et_phone_no=findViewById(R.id.et_phone_no);
        et_password=findViewById(R.id.et_password);
        btn_signUp=findViewById(R.id.btn_signUp);
    }



}
