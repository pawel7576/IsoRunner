package com.special.IsoRunner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.special.IsoRunner.adapters.ChatMessagesAdapter;

public class ChatFragment extends Fragment {

    private View parentView;
    private ListView chatMessagesList ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.chat, container, false);

        chatMessagesList = (ListView) parentView.findViewById(R.id.chatMessageList);
        int selectedIndex = ((MenuActivity)getActivity()).settingsChoosenImage;
        ChatMessagesAdapter backgroundImagesAdapter = new ChatMessagesAdapter(this, getActivity().getBaseContext(), GlobalDataProvider.getChatMessageListList(), selectedIndex);
        chatMessagesList.setAdapter(backgroundImagesAdapter);

        return parentView;
    }

}
