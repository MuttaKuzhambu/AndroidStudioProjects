package com.example.notetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, int resource, ArrayList<Note> notes) {
        super(context, resource, notes);
    }
    @Override
    public View  getView(int position, View convertView, ViewGroup parent) {
     //   return super.getView(position, convertView, parent);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_note,null);
        }
        Note note=getItem(position);
        if(note!=null){
            TextView title=(TextView)convertView.findViewById(R.id.list_note_title);
            TextView content=(TextView)convertView.findViewById(R.id.list_note_content);
            TextView date=(TextView)convertView.findViewById(R.id.list_note_date);

            title.setText(note.getmTitle());
            date.setText(note.getDateTimeFormatted(getContext()));
            if(note.getmContent().length()>50){
                content.setText(note.getmContent().substring(0,50));
            }
            else{
                content.setText(note.getmContent());
            }
        }
        return convertView;
    }

}
