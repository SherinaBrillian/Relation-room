package com.sherina.hajidanumroh.relationchat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomModel {
    private String roomUid;
    private String orderUid;
    private String statusUid;
    private String createdAt;
    private String updatedAt;
}
