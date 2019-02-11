package com.example.loginfeedbackform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button blogin;
EditText eusername;
EditText epassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blogin=(Button)findViewById(R.id.login);
        eusername=(EditText)findViewById(R.id.username);
        epassword=(EditText) findViewById(R.id.password);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=eusername.getText().toString();
                String password=epassword.getText().toString();
                if(username.equals("") ||password.equals("") ){
                    Toast.makeText(getApplicationContext(),"Do Not Leave Any Field Empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent in=new Intent(MainActivity.this,FeedBack.class);
                in.putExtra("user",username);
                startActivity(in);
            }
        });
    }

}
