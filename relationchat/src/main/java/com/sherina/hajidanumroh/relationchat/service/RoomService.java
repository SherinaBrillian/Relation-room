package com.sherina.hajidanumroh.relationchat.service;

import com.sherina.hajidanumroh.relationchat.dto.request.RoomRequest;
import com.sherina.hajidanumroh.relationchat.dto.response.RoomDataResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.RoomListResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.WebResponseBase;

public interface RoomService {
    WebResponseBase saveData(RoomRequest roomModel);
    WebResponseBase updateData(RoomRequest roomModel);
    WebResponseBase deleteData(String roomUid);
    RoomListResponse getAll();
    RoomDataResponse getById(String roomUid);
}
