package com.sherina.hajidanumroh.relationchat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.relationchat.dto.RoomResponseModel;
import com.sherina.hajidanumroh.relationchat.dto.request.RoomRequest;
import com.sherina.hajidanumroh.relationchat.dto.response.RoomDataResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.RoomListResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.relationchat.repository.RoomRepo;
import com.sherina.hajidanumroh.relationchat.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService {
    
    @Autowired
    private RoomRepo roomRepo;
    
    @Override
    public WebResponseBase saveData(RoomRequest roomModel) {
        try {
            WebResponseBase response = new WebResponseBase();
            roomRepo.saveData(roomModel);
            response.setStatus("OK");
            return response;
        } catch(DuplicateKeyException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Room is already exist");
        }
    }

     @Override
    public WebResponseBase updateData(RoomRequest roomModel) {
        WebResponseBase response = new WebResponseBase();
        roomRepo.updateData(roomModel);
        response.setStatus("OK");
        return response;
    }

    @Override
    public WebResponseBase deleteData(String roomUid) {
        WebResponseBase response = new WebResponseBase();
        roomRepo.deleteData(roomUid);
        response.setStatus("OK");
        return response;
    }

    @Override
    public RoomListResponse getAll() {
        RoomListResponse response = new RoomListResponse();
        List<RoomResponseModel> roomModel = roomRepo.getAll();
        response.setStatus("OK");
        response.setData(roomModel);
        return response;
    }

    @Override
    public RoomDataResponse getById(String roomUid) {
        RoomDataResponse response = new RoomDataResponse();
        RoomResponseModel roomModel = roomRepo.getById(roomUid);
        if(roomModel == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room Not Found!");
        }
        response.setStatus("OK");
        response.setData(roomModel);
        return response;
    }
    
}
