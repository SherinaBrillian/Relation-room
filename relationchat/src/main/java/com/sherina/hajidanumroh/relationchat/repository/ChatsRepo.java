package com.sherina.hajidanumroh.relationchat.repository;

import java.util.List;

import com.sherina.hajidanumroh.relationchat.dto.ChatsResponseModel;
import com.sherina.hajidanumroh.relationchat.dto.request.ChatsRequest;


public interface ChatsRepo {
    void saveData(ChatsRequest chatModel);
    void updateData(ChatsRequest chatModel);
    void deleteData(String chatUid);
    List<ChatsResponseModel> getAll();
    ChatsResponseModel getById(String roomUid);
    
}
