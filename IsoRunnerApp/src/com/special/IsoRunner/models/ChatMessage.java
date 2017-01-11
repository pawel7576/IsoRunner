package com.special.IsoRunner.models;

/**
 * Created by pawel on 29/12/16.
 */

public class ChatMessage {
    public String publisherName;
    public String text;
    public String messageId;

    public ChatMessage(String autor, String text) {
        this.publisherName = autor;
        this.text = text;
    }
}
