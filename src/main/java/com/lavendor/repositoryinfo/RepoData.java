package com.lavendor.repositoryinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RepoData {

    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stars;
    private LocalDate createdAt;
}
