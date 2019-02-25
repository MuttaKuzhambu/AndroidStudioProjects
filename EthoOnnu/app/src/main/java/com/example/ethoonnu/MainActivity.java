package com.example.ethoonnu;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
EditText mEditText,FILENAME;
Button save,load,append;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText=findViewById(R.id.eText);
        FILENAME=findViewById(R.id.filename);
        save=(Button)findViewById(R.id.save);
    load=(Button)findViewById(R.id.load);
    append=(Button)findViewById(R.id.append);
    //save the file
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=mEditText.getText().toString();
                String fname=FILENAME.getText().toString();
                FileOutputStream fos;
                fos=null;
                try{
                    fos=openFileOutput(fname+".txt",MODE_PRIVATE);
                    fos.write(text.getBytes());
                    mEditText.getText().clear();
                    Toast.makeText(MainActivity.this,"Saved to "+getFilesDir()+"/"+fname+".txt",Toast.LENGTH_SHORT).show();

                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                finally{
                    if(fos!=null){
                        try{
                            fos.close();
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        //load the file
        load.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FileInputStream fis=null;
                String fname=FILENAME.getText().toString();
                try{
                    fis=openFileInput(fname+".txt");
                    InputStreamReader isr=new InputStreamReader(fis);
                    BufferedReader br=new BufferedReader(isr);
                    StringBuilder sb=new StringBuilder();
                    String text;
                    while((text=br.readLine())!=null){
                        sb.append(text).append("\n");
                    }
                    mEditText.setText(sb.toString());

                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                finally{
                    if(fis!=null){
                            try{
                                fis.close();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                    }
                }
            }
        });
    //append the file
    append.setOnClickListener(new View.OnClickListener() {
        String newstring;
            @Override
            public void onClick(View v) {
                String t=mEditText.getText().toString();
                FileInputStream fis=null;
                String fname=FILENAME.getText().toString();
                try{
                    fis=openFileInput(fname+".txt");
                    InputStreamReader isr=new InputStreamReader(fis);
                    BufferedReader br=new BufferedReader(isr);
                    StringBuilder sb=new StringBuilder();
                    String text;
                    while((text=br.readLine())!=null){
                        sb.append(text).append("\n");
                    }
                     newstring=sb.toString()+t;

                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                finally{
                    if(fis!=null){
                        try{
                            fis.close();
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                FileOutputStream fos;
                fos=null;
                try{
                    fos=openFileOutput(fname+".txt",MODE_PRIVATE);
                    fos.write(newstring.getBytes());
                    mEditText.getText().clear();
                    Toast.makeText(MainActivity.this,"Saved to "+getFilesDir()+"/"+fname+".txt",Toast.LENGTH_SHORT).show();

                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                finally{
                    if(fos!=null){
                        try{
                            fos.close();
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
    }

}
