package com.special.IsoRunner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.special.IsoRunner.NotesFragment;
import com.special.IsoRunner.R;
import com.special.IsoRunner.models.Note;

import java.util.List;

/**
 * Created by pawel on 15/12/16.
 */

public class NotesListViewAdapter extends BaseAdapter {

    NotesFragment mNotesFragment;
    List<Note> notes;
    Context context;

    public NotesListViewAdapter(NotesFragment notesFragment, Context context, List<Note> notes) {
        this.notes = notes;
        this.context = context;
        this.mNotesFragment = notesFragment;
    }



    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.note_item, parent, false);

        TextView text = (TextView) convertView.findViewById(R.id.noteText);
        text.setText(notes.get(position).text);

        Button button = (Button) convertView.findViewById(R.id.deleteItem);
        button.setTag(notes.get(position).noteId);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String idNoteToRemove = (String) v.getTag();
                mNotesFragment.removeNoteWithId(idNoteToRemove);
            }
        });

        return convertView;
    }

}
