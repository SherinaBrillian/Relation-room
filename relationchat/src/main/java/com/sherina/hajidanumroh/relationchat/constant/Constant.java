package com.sherina.hajidanumroh.relationchat.constant;

public class Constant {
    public static final class Chats {
        public static final String INSERT_DATA = "INSERT INTO tbChats (chatUid, roomUid, sender, message) VALUES (?, ?, ?, ?)";
        public static final String UPDATE_BY_ID = "UPDATE tbChats set message = ?, sender = ?, roomUid = ? where chatUid = ?";
        public static final String DELETE_BY_ID = "DELETE from tbChats where chatUid = ?";
        public static final String GET_ALL = "SELECT * from tbChats";
        public static final String GET_BY_ID = "SELECT * from tbChats where roomUid = ?";
        }

        public static final class Room {
            public static final String INSERT_DATA = "INSERT INTO tbRoom (roomUid, orderUid, statusUid) values (?, ?, ?)";
            public static final String UPDATE_BY_ID = "UPDATE tbRoom set orderUid = ?, statusUid = ? where roomUid = ?";
            public static final String DELETE_BY_ID = "DELETE FROM tbRoom where roomUid = ?";
            public static final String GET_ALL = "SELECT r.roomUid, r.orderUid, r.statusUid, r.createdAt AS createdAt, r.updatedAt AS updatedAt, c.chatUid, c.sender, c.message, c.createdAt AS createdAt FROM tbroom r LEFT JOIN tbchats c ON r.roomUid = c.roomUid";
            public static final String GET_BY_ID = "SELECT r.roomUid, r.orderUid, r.statusUid, r.createdAt AS createdAt, r.updatedAt AS updatedAt, c.chatUid, c.sender, c.message, c.createdAt AS createdAt FROM tbroom r LEFT JOIN tbchats c ON r.roomUid = c.roomUid where roomUid = ?";
        }
}
