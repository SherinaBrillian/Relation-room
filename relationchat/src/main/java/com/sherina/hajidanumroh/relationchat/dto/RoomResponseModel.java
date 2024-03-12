package com.sherina.hajidanumroh.relationchat.dto;

import com.sherina.hajidanumroh.relationchat.model.ChatsModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponseModel {
    private String roomUid;
    private String orderUid;
    private String statusUid;
    private String createdAt;
    private String updatedAt;
    private ChatsModel chatsModel;
}
