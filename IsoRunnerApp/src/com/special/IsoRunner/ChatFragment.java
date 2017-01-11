package com.special.IsoRunner;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.special.IsoRunner.adapters.ChatMessagesAdapter;
import com.special.IsoRunner.adapters.LoadingAdapter;
import com.special.IsoRunner.adapters.NotesListViewAdapter;
import com.special.IsoRunner.callbackFiles.AppCallbackProvider;
import com.special.IsoRunner.callbackFiles.ICallService;
import com.special.IsoRunner.models.ChatMessage;
import com.special.IsoRunner.models.Note;
import com.special.IsoRunner.models.TrainingItem;
import com.special.IsoRunner.utils.UtilsApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatFragment extends Fragment {

    private View parentView;
    private ListView chatMessagesList ;
    private Button sendMessageButton;
    private EditText messageEditText;

    Context mContext;
    ChatFragment chatFragment;
    List<ChatMessage> currentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.chat, container, false);

        chatMessagesList = (ListView) parentView.findViewById(R.id.chatMessageList);
        sendMessageButton = (Button) parentView.findViewById(R.id.buttonSentMessage);
        messageEditText = (EditText) parentView.findViewById(R.id.messageEditText);
        mContext = getActivity().getBaseContext();
        chatFragment = this;

        loadData();

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String meesageToSend = messageEditText.getText().toString();
                ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
                Call<String> call = gitHubService.AddMessage(UtilsApp.getToken(getActivity()),meesageToSend);
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
            }
        });

        return parentView;
    }

    private void loadData() {

        if(currentList == null) {
            LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"Loading ...");
            chatMessagesList.setAdapter(eventsAdapter);
        }
        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<List<ChatMessage>> call = gitHubService.GetMessages(UtilsApp.getToken(getActivity()));
        call.enqueue(new Callback<List<ChatMessage>>() {
            @Override
            public void onResponse(Call<List<ChatMessage>> call, Response<List<ChatMessage>> response) {
                if(response.body().size() == 0) {
                    if(currentList == null) {
                        LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"No content available");
                        chatMessagesList.setAdapter(eventsAdapter);
                    }
                }
                else {
                    ArrayList<ChatMessage> listMessages = new ArrayList<ChatMessage>(response.body());
                    Collections.reverse(listMessages);
                    if(currentList == null || !currentList.get(0).messageId.equals(listMessages.get(0).messageId)) {
                        ChatMessagesAdapter eventsAdapter = new ChatMessagesAdapter(chatFragment, mContext, listMessages);
                        chatMessagesList.setAdapter(eventsAdapter);
                        currentList = listMessages;
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, 4000);
            }
            @Override
            public void onFailure(Call<List<ChatMessage>> call, Throwable t) {
                if(currentList == null) {
                    LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"Connection problem");
                    chatMessagesList.setAdapter(eventsAdapter);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, 4000);
            }
        });

    }

}
