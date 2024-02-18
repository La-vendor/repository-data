package com.lavendor.repositoryinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GitHubService {

    private final RestClient restClient;

    public GitHubService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://api.github.com/")
                .build();
    }

    public RepoData getRepoData(String author, String repositoryName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String gitHubResponse = restClient.get()
                    .uri("/repos/{owner}/{repo}", author, repositoryName)
                    .retrieve()
                    .body(String.class);
            RepoData repoData = new RepoData();
            JsonNode gitHubResponseNode;
            try {
                gitHubResponseNode = objectMapper.readTree(gitHubResponse);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            repoData.setFullName(gitHubResponseNode.path("full_name").asText());
            repoData.setDescription(gitHubResponseNode.path("description").asText());
            repoData.setCloneUrl(gitHubResponseNode.path("git_url").asText());
            repoData.setStars(gitHubResponseNode.path("stargazers_count").asInt());

            String createdAt = gitHubResponseNode.path("created_at").asText();
            repoData.setCreatedAt(LocalDateTime.parse(createdAt, DateTimeFormatter.ISO_DATE_TIME));

            return repoData;
        }catch(HttpClientErrorException e){
            return null;
        }
    }
}
