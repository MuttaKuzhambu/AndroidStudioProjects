package com.example.loginfeedbackform;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewFeedBack extends AppCompatActivity {
TextView trollnumber,tdepartment,tad,tfb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feed_back);
    trollnumber=(TextView)findViewById(R.id.trollno);
        tdepartment=(TextView)findViewById(R.id.tdept);
        tad=(TextView)findViewById(R.id.taddress);
        tfb=(TextView)findViewById(R.id.tfeedback);

        Intent getin=getIntent();
        String rollnumber="ROLL NUMBER: "+getin.getStringExtra("rollno");
                String department="DEPARTMENT: "+getin.getStringExtra("dept");
                String address="ADDRESS: "+getin.getStringExtra("address");
                String feedback="FEEDBACK : "+getin.getStringExtra("feedback");

                trollnumber.setText(rollnumber);
        tdepartment.setText(department);
        tad.setText(address);
        tfb.setText(feedback);
    }

}
