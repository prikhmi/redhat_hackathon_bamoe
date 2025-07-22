package com.ibm.boycott.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.enterprise.context.ApplicationScoped;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.boycott.dto.PromptRequest;
import com.ibm.boycott.dto.PromptResponse;

@ApplicationScoped
public class GenAIHttpClient {

    private static final Logger log = LoggerFactory.getLogger(GenAIHttpClient.class);

    private static final String GENAI_URL = "http://9e6f129b-us-east.lb.appdomain.cloud/call_llm";
    private static final String USERNAME = "genai_user002";
    private static final String PASSWORD = "45$124K#aH";

    private final ObjectMapper mapper = new ObjectMapper();

    public PromptResponse callLLM(PromptRequest request) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(GENAI_URL);

            // Add headers
            String auth = USERNAME + ":" + PASSWORD;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
            post.setHeader("Authorization", "Basic " + encodedAuth);
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Accept", "application/json");

            // Convert and log the request
            String jsonBody = mapper.writeValueAsString(request);
            log.info("Sending PromptRequest to GenAI:\n{}", 
                     mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request));

            post.setEntity(new StringEntity(jsonBody, StandardCharsets.UTF_8));

            // Execute the HTTP POST
            try (CloseableHttpResponse response = client.execute(post)) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
                int status = response.getStatusLine().getStatusCode();

                log.info("GenAI response status: {}", status);

                if (status != 200) {
                    log.warn("GenAI API error response: {}", jsonResponse);
                    throw new RuntimeException("GenAI API error: " + status + " - " + jsonResponse);
                }

                return mapper.readValue(jsonResponse, PromptResponse.class);
            }
        }
    }
}
