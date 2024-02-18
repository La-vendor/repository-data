package com.lavendor.repositoryinfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RepositoryInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoryInfoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(GitHubService gitHubService) {
//        return args -> {
//            RepoData repoData = gitHubService.getRepoData("La-vendor", "mealmate");
//            System.out.println(repoData);
//        };
//    }
}

