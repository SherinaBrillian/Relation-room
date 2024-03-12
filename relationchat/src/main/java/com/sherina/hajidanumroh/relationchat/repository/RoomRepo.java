package com.sherina.hajidanumroh.relationchat.repository;

import java.util.List;

import com.sherina.hajidanumroh.relationchat.dto.RoomResponseModel;
import com.sherina.hajidanumroh.relationchat.dto.request.RoomRequest;


public interface RoomRepo {
    void saveData(RoomRequest roomModel);
    void updateData(RoomRequest chatModel);
    void deleteData(String roomUid);
    List<RoomResponseModel> getAll();
    RoomResponseModel getById(String roomUid);
}
