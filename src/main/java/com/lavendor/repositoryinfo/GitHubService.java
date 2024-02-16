package com.lavendor.repositoryinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GitHubService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public GitHubService(RestClient.Builder builder, ObjectMapper objectMapper) {
        this.restClient = builder
                .baseUrl("https://api.github.com/")
                .build();
        this.objectMapper = objectMapper;
    }

    public RepoData getRepoData(String author, String repositoryName) {
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

        return repoData;
    }

}
