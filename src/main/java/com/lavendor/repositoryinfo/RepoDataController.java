package com.lavendor.repositoryinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/repository")
public class RepoDataController {

    private final GitHubService gitHubService;

    @GetMapping("{author}/{repository-name}")
    public ResponseEntity<?> getRepositoryData(@PathVariable("author") String author,
                                                      @PathVariable("repository-name") String repositoryName) {

        RepoData repoData = gitHubService.getRepoData(author, repositoryName);

        if(repoData != null){
            return ResponseEntity.ok(repoData);
        }else{
            String errorMessage = "Repository not found: " + author + "/" + repositoryName;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

        }
    }
}
