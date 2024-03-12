package com.sherina.hajidanumroh.relationchat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatsModel {
    private String chatUid;
    private String roomUid;
    private String sender;
    private String message;
    private String createdAt; 
}
