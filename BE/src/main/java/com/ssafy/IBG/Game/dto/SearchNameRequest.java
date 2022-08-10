package com.ssafy.IBG.Game.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchNameRequest{
    private String searchName;
    private Integer userNo;

    public SearchNameRequest(String searchName, Integer userNo){
        this.searchName = searchName;
        this.userNo = userNo;
    }
}