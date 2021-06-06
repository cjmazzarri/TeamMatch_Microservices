package com.teammatch.communication.controller;

import com.teammatch.communication.entities.Chat;
import com.teammatch.communication.resource.ChatResource;
import com.teammatch.communication.resource.SaveChatResource;
import com.teammatch.communication.service.ChatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class ChatController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ChatService chatService;

    @GetMapping("/chats")
    public Page<ChatResource> getAllChats(Pageable pageable) {
        List<ChatResource> chats = chatService.getAllChats(pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int chatsCount = chats.size();
        return new PageImpl<>(chats, pageable, chatsCount);
    }

    @GetMapping("/chats/{id}")
    public ChatResource getChatById(@PathVariable(name = "id") Long chatId) {
        return convertToResource(chatService.getChatById(chatId));
    }

    /*@GetMapping("/players/{playerId}/chats")
    public Page<ChatResource> getAllChatsByPlayerId(@PathVariable(name = "playerId") Long playerId, Pageable pageable) {
        List<ChatResource> chats = chatService.getAllChatsByPlayerId(playerId, pageable).getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int chatCount = chats.size();
        return new PageImpl<>(chats, pageable, chatCount);
    }*/

    @PostMapping("/chats")
    //TODO: Chat not related to a player.
    public ChatResource createChat(@Valid @RequestBody SaveChatResource resource) {
        return convertToResource(chatService.createChat(convertToEntity(resource)));
    }

    private Chat convertToEntity(SaveChatResource resource)
    {
        return  mapper.map(resource, Chat.class);
    }

    private ChatResource convertToResource(Chat entity)
    {
        return mapper.map(entity, ChatResource.class);
    }

}
