package com.lavendor.repositoryinfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RepositoryInfoApplication.class)
class GitHubServiceTest {

    @Autowired
    private GitHubService gitHubService;

    @Test
    public void testGetDataFromGitHubAPI(){

        RepoData repoData = gitHubService.getRepoData("La-vendor", "mealmate");
        System.out.println(repoData);
    }

}