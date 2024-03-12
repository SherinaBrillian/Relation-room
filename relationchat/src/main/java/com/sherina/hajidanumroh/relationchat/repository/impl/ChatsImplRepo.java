package com.sherina.hajidanumroh.relationchat.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.sherina.hajidanumroh.relationchat.constant.Constant;
import com.sherina.hajidanumroh.relationchat.dto.ChatsResponseModel;
import com.sherina.hajidanumroh.relationchat.dto.request.ChatsRequest;
import com.sherina.hajidanumroh.relationchat.repository.ChatsRepo;


@Service
public class ChatsImplRepo implements ChatsRepo{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(ChatsRequest chatModel) {
        UUID chatUid = UUID.randomUUID();
        chatModel.setChatUid(chatUid.toString().replace("-", ""));
        Object[] queryParam = new Object[] {chatModel.getChatUid(), chatModel.getRoomUid(), chatModel.getSender(), chatModel.getMessage()};
        jdbcTemplate.update(Constant.Chats.INSERT_DATA, queryParam);
    }

    @Override
    public void updateData(ChatsRequest chatModel) {
        Object[] queryParam = new Object[] {chatModel.getMessage(), chatModel.getSender(), chatModel.getRoomUid(), chatModel.getChatUid()};
        jdbcTemplate.update(Constant.Chats.UPDATE_BY_ID, queryParam);
    }

    @Override
    public void deleteData(String chatUid) {
        Object[] queryParam = new Object[] {chatUid};
        jdbcTemplate.update(Constant.Chats.DELETE_BY_ID, queryParam);
    }

    @Override
    public List<ChatsResponseModel> getAll() {
        List<ChatsResponseModel> data = jdbcTemplate.query(Constant.Chats.GET_ALL, new ChatsListExtractor());
        return data;
    }

    @Override
    public ChatsResponseModel getById(String roomUid) {
        Object[] queryParam = new Object[] {roomUid};
        ChatsResponseModel data = jdbcTemplate.query(Constant.Chats.GET_BY_ID, new ChatsExtractor(), queryParam);
        return data;
    }

    //Extractor
    public static final class ChatsListExtractor implements ResultSetExtractor<List<ChatsResponseModel>> {
        @Override
        public List<ChatsResponseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<ChatsResponseModel> data = new ArrayList<>();
            while (rs.next()) {
                ChatsResponseModel chatsModel = new ChatsResponseModel();
                chatsModel.setChatUid(rs.getString("chatUid"));
                chatsModel.setRoomUid(rs.getString("roomUid"));
                chatsModel.setSender(rs.getString("sender"));
                chatsModel.setMessage(rs.getString("message"));
                chatsModel.setCreatedAt(rs.getString("createdAt"));
                data.add(chatsModel);
            }
            return data;
            
        }
    }

    public static final class ChatsExtractor implements ResultSetExtractor<ChatsResponseModel> {
        @Override
        public ChatsResponseModel extractData(ResultSet rs) throws SQLException, DataAccessException {
            ChatsResponseModel chatsModel = new ChatsResponseModel();
            if(rs.next()){
                chatsModel.setChatUid(rs.getString("chatUid"));
                chatsModel.setRoomUid(rs.getString("roomUid"));
                chatsModel.setSender(rs.getString("sender"));
                chatsModel.setMessage(rs.getString("message"));
                chatsModel.setCreatedAt(rs.getString("createdAt"));

                return chatsModel;
            }
            else{
                chatsModel = null;
                return chatsModel;
            }
            
        }
    }
    
}
