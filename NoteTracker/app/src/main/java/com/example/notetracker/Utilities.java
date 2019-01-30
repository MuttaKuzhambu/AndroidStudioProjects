package com.example.notetracker;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Utilities {
    private static final String FILE_EXTENSION =".bin" ;
    public static boolean saveNote(Context context, Note note){
        String filename=String.valueOf(note.getmDateTime())+FILE_EXTENSION;

        FileOutputStream fos;
        ObjectOutputStream oos;
        try{
            fos=context.openFileOutput(filename,context.MODE_PRIVATE);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(note);
            oos.close();
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
            return false;//tells the user that something went wrong;
        }

        return true;
    }
}
