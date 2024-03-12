package com.sherina.hajidanumroh.relationchat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.relationchat.dto.ChatsResponseModel;
import com.sherina.hajidanumroh.relationchat.dto.request.ChatsRequest;
import com.sherina.hajidanumroh.relationchat.dto.response.ChatsDataResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.ChatsListResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.relationchat.repository.impl.ChatsImplRepo;
import com.sherina.hajidanumroh.relationchat.service.ChatsService;




@Service
public class ChatsServiceImpl implements ChatsService {
    @Autowired
    ChatsImplRepo chatsRepo;

    @Override
    public WebResponseBase saveData(ChatsRequest chatsModel) {
        try {
            WebResponseBase response = new WebResponseBase();
            chatsRepo.saveData(chatsModel);
            response.setStatus("OK");
            return response;
        } catch(DuplicateKeyException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Chats is already exist");
        }
    }

    @Override
    public WebResponseBase updateData(ChatsRequest chatsModel) {
        WebResponseBase response = new WebResponseBase();
        chatsRepo.updateData(chatsModel);
        response.setStatus("OK");
        return response;
    }

    @Override
    public WebResponseBase deleteData(String chatUid) {
        WebResponseBase response = new WebResponseBase();
        chatsRepo.deleteData(chatUid);
        response.setStatus("OK");
        return response;
    }

    @Override
    public ChatsListResponse getAll() {
        ChatsListResponse response = new ChatsListResponse();
        List<ChatsResponseModel> chatsModel = chatsRepo.getAll();
        response.setStatus("OK");
        response.setData(chatsModel);
        return response;
    }

    @Override
    public ChatsDataResponse getById(String roomUid) {
        ChatsDataResponse response = new ChatsDataResponse();
        ChatsResponseModel chatsModel = chatsRepo.getById(roomUid);
        if(chatsModel == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chats Not Found!");
        }
        response.setStatus("OK");
        response.setData(chatsModel);
        return response;
    }
}
