package com.sherina.hajidanumroh.relationchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherina.hajidanumroh.relationchat.dto.request.RoomRequest;
import com.sherina.hajidanumroh.relationchat.dto.response.RoomDataResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.RoomListResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.relationchat.service.impl.RoomServiceImpl;


@RestController
@RequestMapping("/api/v1/Room")
public class RoomController {
   
    @Autowired
    RoomServiceImpl roomRepo;

    @PostMapping
    public WebResponseBase saveData(@RequestBody RoomRequest roomRequest) {
        return roomRepo.saveData(roomRequest);
    }

    @PutMapping
    @RequestMapping("/update/{roomUid}")
    public WebResponseBase updateData(@PathVariable String roomUid, @RequestBody RoomRequest roomRequest) {
        roomRequest.setRoomUid(roomUid);
        return roomRepo.updateData(roomRequest);
    }
    
    @DeleteMapping
    @RequestMapping("/delete/{roomUid}")
    public WebResponseBase deleteData(@PathVariable String roomUid) {
        return roomRepo.deleteData(roomUid);
    }
    
    @GetMapping
    public RoomListResponse getAll() {
        return roomRepo.getAll();
    }

    @GetMapping
    @RequestMapping("/{roomUid}")
    public RoomDataResponse getById(@PathVariable String roomUid) {
        return roomRepo.getById(roomUid);
    }
}

