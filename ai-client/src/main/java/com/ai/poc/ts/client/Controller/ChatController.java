package com.ai.poc.ts.client.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder, ToolCallbackProvider mcpToolCallbackProvider) {
        this.chatClient = chatClientBuilder
                .defaultTools(mcpToolCallbackProvider)
                .build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(defaultValue = "Show all products") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}