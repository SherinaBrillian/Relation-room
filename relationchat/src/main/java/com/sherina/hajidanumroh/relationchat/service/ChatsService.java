package com.sherina.hajidanumroh.relationchat.service;

import com.sherina.hajidanumroh.relationchat.dto.request.ChatsRequest;
import com.sherina.hajidanumroh.relationchat.dto.response.ChatsDataResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.ChatsListResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.WebResponseBase;

public interface ChatsService {
    WebResponseBase saveData(ChatsRequest chatsModel);
    WebResponseBase updateData(ChatsRequest chatsModel);
    WebResponseBase deleteData(String chatUid);
    ChatsListResponse getAll();
    ChatsDataResponse getById(String roomUid);   
}
