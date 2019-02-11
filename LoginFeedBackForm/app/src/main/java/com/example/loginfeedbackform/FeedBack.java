package com.example.loginfeedbackform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

public class FeedBack extends AppCompatActivity {
EditText erollno,edept,eaddress,efeedback;
Button bsubmit;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        Intent getin=getIntent();
        String rn=getin.getStringExtra("user");

        erollno=(EditText)findViewById(R.id.rollno);
        erollno.setText(rn);

        edept=(EditText)findViewById(R.id.dept);
        eaddress=(EditText)findViewById(R.id.address);
        efeedback=(EditText)findViewById(R.id.feedback);
        bsubmit=(Button)findViewById(R.id.submit);

        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept=edept.getText().toString();
                String address=eaddress.getText().toString();
                String feedback=efeedback.getText().toString();
                if(dept.equals("") || address.equals("") || feedback.equals("") ){
                    Toast.makeText(FeedBack.this,"Fields Are Empty",Toast.LENGTH_SHORT).show();
                    return ;
                }

                Intent in=new Intent(FeedBack.this,ViewFeedBack.class);

                in.putExtra("rollno",erollno.getText().toString());
                in.putExtra("dept",dept);
                in.putExtra("address",address);
                in.putExtra("feedback",feedback);

                startActivity(in);
            }
        });

    }
}
