package com.special.IsoRunner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.special.IsoRunner.adapters.LoadingAdapter;
import com.special.IsoRunner.adapters.NotesListViewAdapter;
import com.special.IsoRunner.callbackFiles.ICallService;
import com.special.IsoRunner.models.Note;
import com.special.IsoRunner.utils.UtilsApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NotesFragment extends Fragment {

    private View parentView;

    private ListView listNotes ;
    private Button buttonAddNote;
    private EditText editText;

    Boolean isLoading;

    Context mContext;
    NotesFragment notesFragment;

    List<Note> currentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        parentView = inflater.inflate(R.layout.notes, container, false);

        editText = (EditText) parentView.findViewById(R.id.notesText);

        buttonAddNote = (Button) parentView.findViewById(R.id.button_send);

        buttonAddNote.setOnClickListener(new NoteFragmentListener(this));

        listNotes = (ListView) parentView.findViewById(R.id.listNotes);

        mContext = getActivity().getBaseContext();
        notesFragment = this;

        this.loadData();
        return parentView;
    }

    private void loadData() {

        isLoading = true;
        LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"Loading ...");
        listNotes.setAdapter(eventsAdapter);

        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<List<Note>> call = gitHubService.GetNotes(UtilsApp.getToken(getActivity()));
        call.enqueue(new Callback<List<Note>>() {
            @Override
            public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                isLoading = false;
                if(response.body().size() == 0) {
                    LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"No content available");
                    listNotes.setAdapter(eventsAdapter);
                }
                else {
                    NotesListViewAdapter eventsAdapter = new NotesListViewAdapter(notesFragment, mContext, response.body());
                    listNotes.setAdapter(eventsAdapter);
                    currentList = response.body();
                }
            }
            @Override
            public void onFailure(Call<List<Note>> call, Throwable t) {
                isLoading = false;
            }
        });

    }

    public void removeNoteWithId(String id) {
        removeNoteWithIdFromCurrentList(id);

        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<String> call = gitHubService.RemoveNote(UtilsApp.getToken(getActivity()),Integer.parseInt(id));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }

    public void removeNoteWithIdFromCurrentList (String id) {

        for(int i = 0; i < currentList.size(); i++) {
            if(currentList.get(i).noteId.equals(id)) {
                currentList.remove(i);
                break;
            }
        }
        NotesListViewAdapter eventsAdapter = new NotesListViewAdapter(notesFragment, mContext, currentList);
        listNotes.setAdapter(eventsAdapter);
    }

    public void addNoteWithText(String text) {
        if(isLoading) {
            LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"Wait. Loading ...");
            listNotes.setAdapter(eventsAdapter);
            return;
        }

        isLoading = true;
        LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"Loading ...");
        listNotes.setAdapter(eventsAdapter);

        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<String> call = gitHubService.AddNote(UtilsApp.getToken(getActivity()),text);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                loadData();
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                loadData();
            }
        });


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
