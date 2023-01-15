package com.atoz.board;

import com.atoz.post.dto.PostDto;

import java.util.List;

public class StubBoardMapper implements BoardMapper {
    @Override
    public List<PostDto> findPosts(int boardId) {
        return null;
    }
}
