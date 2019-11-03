package com.example.girls;


import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashMap;

import static com.example.girls.Connect.ParseintoAPICall;

public class RegistrationActivity extends AppCompatActivity {
    private EditText username,password,fullname,major;
    private Spinner gender_spinner, classification_spinner;
    private Button resetbtn,confirmbtn;
    Profile p = new Profile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        fullname = (EditText) findViewById(R.id.fullname);
        major = (EditText) findViewById(R.id.major);
        gender_spinner = (Spinner) findViewById(R.id.gender_spinner);
        classification_spinner = (Spinner) findViewById(R.id.classification_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender_spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter_class = ArrayAdapter.createFromResource(this,
                R.array.classification_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classification_spinner.setAdapter(adapter_class);

        resetbtn = (Button) findViewById(R.id.Reset);
        confirmbtn = (Button) findViewById(R.id.Confirm);
        resetbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
                fullname.setText("");
                major.setText("");
            }
        });


        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = (EditText) findViewById(R.id.email);
                password = (EditText) findViewById(R.id.password);
                fullname = (EditText) findViewById(R.id.fullname);
                major = (EditText) findViewById(R.id.major);
                gender_spinner = (Spinner) findViewById(R.id.gender_spinner);
                classification_spinner = (Spinner) findViewById(R.id.classification_spinner);

                p.setEmail(username.getText().toString());
                p.setPassword(password.getText().toString());
                p.setClassification(classification_spinner.getSelectedItemPosition() +1);
                p.setGender(gender_spinner.getSelectedItemPosition() +1);
                p.setMajor(major.getText().toString());
                p.setMemberType(1);
                HashMap<String, String> meMap=new HashMap<String, String>();
                meMap.put("email",p.getEmail());
                meMap.put("password",p.getPassword());
                meMap.put("firstname",p.getFirstName());
                meMap.put("lastname",p.getLastName());
                meMap.put("major",p.getMajor());
                meMap.put("gender",Integer.toString(p.getGender()));
                meMap.put("membertype",Integer.toString(p.getMemberType()));
                meMap.put("classification",Integer.toString(p.getClassification()));
                //username.setText((ParseintoAPICall("addProfile", meMap, "Profile")).toString());
                HashMap<String, String> MMap=new HashMap<String, String>();
                MMap.put("profile","4");
                MMap.put("meeting","1");
                MMap.put("feedback","Iloveyou");
                username.setText((ParseintoAPICall("update_feedback", MMap, "feedback")).toString());

                //http://attend-in.com/GirlsPlusPlus/gppapi.php?function=add_profile&email=mbokhari1&password=123&firstname=Hi&lastname=bye&major=CS&gender=1&classification=1&membertype=1&source=Friend


            }
        });
    }
}
