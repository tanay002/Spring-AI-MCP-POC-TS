package com.ai.poc.ts.client.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(
            ChatClient.Builder builder,
            ToolCallbackProvider mcpTools) {

        return builder.defaultSystem("""
                        You are a product assistant.
                        You can retrieve product information
                        using the available MCP tools.
                        Never invent product information.
                        Whenever the user asks about products,
                        use the MCP tools to get information
                        from the database.
                        """)
                .defaultTools(mcpTools)
                .build();
    }
}
