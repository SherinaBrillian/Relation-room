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

import com.sherina.hajidanumroh.relationchat.dto.request.ChatsRequest;
import com.sherina.hajidanumroh.relationchat.dto.response.ChatsDataResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.ChatsListResponse;
import com.sherina.hajidanumroh.relationchat.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.relationchat.service.impl.ChatsServiceImpl;


@RestController
@RequestMapping("api/v1/Chats")
public class ChatsController {
    
    @Autowired
    ChatsServiceImpl chatsRepo;

    @PostMapping
    public WebResponseBase saveData(@RequestBody ChatsRequest chatsModel) {
        return chatsRepo.saveData(chatsModel);
    }

    @PutMapping
    @RequestMapping("/update/{chatUid}")
    public WebResponseBase updateData(@PathVariable String chatUid, @RequestBody ChatsRequest request) {
        request.setChatUid(chatUid);
        return chatsRepo.updateData(request);  
    }

    @DeleteMapping
    @RequestMapping("/delete/{chatUid}")
    public WebResponseBase deleteData(@PathVariable String chatUid) {
        return chatsRepo.deleteData(chatUid);
    }

    @GetMapping
    public ChatsListResponse getAll() {
        return chatsRepo.getAll();
    }

    @GetMapping
    @RequestMapping("/{roomUid}")
    public ChatsDataResponse getById(@PathVariable String roomUid) {
        return chatsRepo.getById(roomUid);
    }
}
