package com.special.IsoRunner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.special.IsoRunner.adapters.ChatMessagesAdapter;
import com.special.IsoRunner.callbackFiles.AppCallbackProvider;
import com.special.IsoRunner.models.TrainingItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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



//        AppCallbackProvider appCallbackProvider = new AppCallbackProvider();
//        appCallbackProvider.GetNews(new Callback<List<TrainingItem>>() {
//                                        @Override
//                                        public void onResponse(Call<List<TrainingItem>> call, Response<List<TrainingItem>> response) {
//                                            int i = 0;
//                                        }
//
//                                        @Override
//                                        public void onFailure(Call<List<TrainingItem>> call, Throwable t) {
//                                            int j = 0;
//                                        }
//                                    }
//        );

        return parentView;
    }

}
