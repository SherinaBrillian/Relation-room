package com.sherina.hajidanumroh.relationchat.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatsRequest {
    private String chatUid;
    private String roomUid;
    private String sender;
    private String message;
    private String createdAt;  
}
