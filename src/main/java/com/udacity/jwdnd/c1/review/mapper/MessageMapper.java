package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES WHERE messageId = #{messageId}")
    ChatMessage findChatMessage(int messageId);

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getAllChatMessages();

    @Select("DELETE FROM MESSAGES WHERE messageId = #{messageId}")
    ChatMessage deleteChatMessage(int messageId);

    @Insert("INSERT INTO MESSAGES (messageText,username)" +
            " VALUES(#{messageText},#{username})")
    @Options(useGeneratedKeys = true,keyProperty = "messageid")
    int insertChatMessage(ChatMessage chatMessage);
}
