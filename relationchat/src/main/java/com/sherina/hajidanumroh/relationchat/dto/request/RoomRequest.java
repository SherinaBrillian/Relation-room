package com.sherina.hajidanumroh.relationchat.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    private String roomUid;
    private String orderUid;
    private String statusUid;
    private String createdAt;
    private String updatedAt;
}
