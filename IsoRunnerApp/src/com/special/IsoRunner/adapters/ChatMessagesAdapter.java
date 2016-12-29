package com.special.IsoRunner.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.special.IsoRunner.ChatFragment;
import com.special.IsoRunner.R;
import com.special.IsoRunner.models.ChatMessage;

import java.util.List;

/**
 * Created by pawel on 29/12/16.
 */

public class ChatMessagesAdapter extends BaseAdapter {


    List<ChatMessage> chatMessages;
    Context context;
    ChatFragment mChatFragment;
    int mSelectedIndex;

    public ChatMessagesAdapter(ChatFragment chatFragment, Context context, List<ChatMessage> chatMessages, int selectedIndex) {
        this.chatMessages = chatMessages;
        this.context = context;
        this.mChatFragment = chatFragment;
        this.mSelectedIndex = selectedIndex;
    }



    @Override
    public int getCount() {
        return chatMessages.size();
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
        convertView = inflater.inflate(R.layout.chat_message_item, parent, false);

        TextView autorTextView = (TextView) convertView.findViewById(R.id.messageAutor);
        autorTextView.setText(chatMessages.get(position).mAutor + ":");

        TextView textMessageTextView = (TextView) convertView.findViewById(R.id.messageText);
        textMessageTextView.setText(chatMessages.get(position).mText);

        if(position % 2 == 0) convertView.setBackgroundColor(Color.rgb(74,74,72));
        else convertView.setBackgroundColor(Color.rgb(110,110,105));

//        LayoutInflater inflater = LayoutInflater.from(context);
//        convertView = inflater.inflate(R.layout.background_image_item, parent, false);
//        if(position == mSelectedIndex) convertView.setBackgroundColor(Color.rgb(191,253,253));
//        else convertView.setBackgroundColor(Color.WHITE);
//
//        TextView text = (TextView) convertView.findViewById(R.id.backgroundImageName);
//        text.setText(chatMessages.get(position).mName);
//
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageBackgroundItem);
//        imageView.setBackgroundResource(chatMessages.get(position).mResource);
//
//        convertView.setTag(Integer.toString(position));
//        convertView.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String clickedBackgroundImagePosition = (String) v.getTag();
////                mChatFragment.clickedBackgroudImage(clickedBackgroundImagePosition);
//            }
//        });

        return convertView;
    }
}
