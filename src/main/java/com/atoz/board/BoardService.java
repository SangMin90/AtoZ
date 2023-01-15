package com.atoz.board;

import com.atoz.post.dto.request.AddPostRequestDto;
import com.atoz.post.dto.response.PostResponseDto;

import java.util.List;

public interface BoardService {
    void addPost(AddPostRequestDto addPostRequestDto);
    List<PostResponseDto> findPosts(int boardId);
}
