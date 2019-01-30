package com.example.notetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class NoteActivity extends AppCompatActivity {
    private EditText mEtTitle,mEtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mEtTitle=findViewById(R.id.note_et_title);
        mEtContent=findViewById(R.id.note_et_content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_new,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_note_save:
                saveNote();
                break;


        }
        return true;
    }
    private void saveNote(){
        Note note=new Note(System.currentTimeMillis(),mEtTitle.getText().toString(),mEtContent.getText().toString());
        if(Utilities.saveNote(this,note)){
            Toast.makeText(this, "Your note is saved!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"cannot save,Please make sure that you have enough space on your" +
                    "device",Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
