package com.special.IsoRunner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.special.IsoRunner.adapters.EventsListViewAdapter;
import com.special.IsoRunner.adapters.NotesListViewAdapter;

import java.util.ArrayList;


public class NotesFragment extends Fragment {

    private View parentView;

    private ListView listNotes ;
    private Button buttonAddNote;
    private EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        parentView = inflater.inflate(R.layout.notes, container, false);

        editText = (EditText) parentView.findViewById(R.id.notesText);

        buttonAddNote = (Button) parentView.findViewById(R.id.button_send);

        buttonAddNote.setOnClickListener(new NoteFragmentListener(this));

        listNotes = (ListView) parentView.findViewById(R.id.listNotes);

        this.loadData();
        return parentView;
    }

    private void loadData() {
        NotesListViewAdapter eventsAdapter = new NotesListViewAdapter(this, getActivity().getBaseContext(), GlobalDataProvider.getNotes());
        listNotes.setAdapter(eventsAdapter);
        //TODO call get notes
    }

    public void removeNoteWithId(String id) {
        int i = 0;
        //TODO call to remove
    }

    public void addNoteWithText(String text) {
        int i = 0;
        //TODO call to add
    }

    public class NoteFragmentListener implements View.OnClickListener
    {
        NotesFragment mNoteFragment;
        public NoteFragmentListener(NotesFragment noteFragment) {
            this.mNoteFragment = noteFragment;
        }

        @Override
        public void onClick(View v)
        {
            String textNoteToAdd = String.valueOf(editText.getText());
            mNoteFragment.addNoteWithText(textNoteToAdd);
        }
    };

}
