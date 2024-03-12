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
import com.sherina.hajidanumroh.relationchat.dto.RoomResponseModel;
import com.sherina.hajidanumroh.relationchat.dto.request.RoomRequest;
import com.sherina.hajidanumroh.relationchat.model.ChatsModel;
import com.sherina.hajidanumroh.relationchat.repository.RoomRepo;



@Service
public class RoomImplRepo implements RoomRepo{
     @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(RoomRequest roomModel) {
        UUID roomUid = UUID.randomUUID();
        roomModel.setRoomUid(roomUid.toString().replace("-", ""));  
        Object[] queryParam = new Object[] {roomModel.getRoomUid(), roomModel.getOrderUid(), roomModel.getStatusUid()};
        jdbcTemplate.update(Constant.Room.INSERT_DATA, queryParam);
    }

    @Override
    public void updateData(RoomRequest roomModel) {
        Object[] queryParam = new Object[] {roomModel.getOrderUid(), roomModel.getStatusUid(), roomModel.getRoomUid()};
        jdbcTemplate.update(Constant.Room.UPDATE_BY_ID, queryParam);
    }

    @Override
    public void deleteData(String chatUid) {
        Object[] queryParam = new Object[] {chatUid};
        jdbcTemplate.update(Constant.Room.DELETE_BY_ID, queryParam);
    }

    @Override
    public List<RoomResponseModel> getAll() {
        List<RoomResponseModel> data = jdbcTemplate.query(Constant.Room.GET_ALL, new RoomListExtractor());
        return data;
    }

    @Override
    public RoomResponseModel getById(String roomUid) {
        Object[] queryParam = new Object[] {roomUid};
        RoomResponseModel data = jdbcTemplate.query(Constant.Room.GET_BY_ID, new RoomExtractor(), queryParam);
        return data;
    }

    //Extractor
    public static final class RoomListExtractor implements ResultSetExtractor<List<RoomResponseModel>> {
        @Override
        public List<RoomResponseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<RoomResponseModel> data = new ArrayList<>();
            while (rs.next()) {
                RoomResponseModel roomModel = new RoomResponseModel();
                roomModel.setRoomUid(rs.getString("roomUid"));
                roomModel.setOrderUid(rs.getString("orderUid"));
                roomModel.setStatusUid(rs.getString("statusUid"));
                roomModel.setCreatedAt(rs.getString("createdAt"));
                roomModel.setUpdatedAt(rs.getString("updatedAt"));
                roomModel.setChatsModel(ChatsModel.builder().chatUid(rs.getString("chatUid")).roomUid(rs.getString("roomUid")).sender(rs.getString("sender")).message(rs.getString("message")).createdAt(rs.getString("createdAt")).build());
                data.add(roomModel);
            }
            return data;
            
        }
    }

    public static final class RoomExtractor implements ResultSetExtractor<RoomResponseModel> {
        @Override
        public RoomResponseModel extractData(ResultSet rs) throws SQLException, DataAccessException {
            RoomResponseModel roomModel = new RoomResponseModel();
            if(rs.next()){
                roomModel.setRoomUid(rs.getString("roomUid"));
                roomModel.setOrderUid(rs.getString("orderUid"));
                roomModel.setStatusUid(rs.getString("statusUid"));
                roomModel.setCreatedAt(rs.getString("createdAt"));
                roomModel.setUpdatedAt(rs.getString("updatedAt"));
                roomModel.setChatsModel(ChatsModel.builder().chatUid(rs.getString("chatUid")).roomUid(rs.getString("roomUid")).sender(rs.getString("sender")).message(rs.getString("message")).createdAt(rs.getString("createdAt")).build());
                return roomModel;
            }
            else{
                roomModel = null;
                return roomModel;
            }
            
        }
    }
    
}
