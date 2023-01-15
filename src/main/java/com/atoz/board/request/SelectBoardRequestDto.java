package com.atoz.board.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SelectBoardRequestDto {
    private int boardId;
    private String boardName;
}
