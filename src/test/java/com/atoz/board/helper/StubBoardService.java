package com.atoz.board.helper;

import com.atoz.board.BoardService;
import com.atoz.post.dto.PostDto;
import com.atoz.post.dto.request.AddPostRequestDto;
import com.atoz.post.dto.response.PostResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StubBoardService implements BoardService {
    private List<PostResponseDto> posts = new ArrayList<>();
    private int postId = 0;

    @Override
    public void addPost(AddPostRequestDto addPostRequestDto) {
        posts.add(
                PostDto.builder()
                        .postId(++postId)
                        .title(addPostRequestDto.getTitle())
                        .content(addPostRequestDto.getContent())
                        .createdAt(LocalDateTime.now())
                        .build()
                        .toPostResponseDto()
        );
    }

    @Override
    public List<PostResponseDto> findPosts(int boardId) {
        return posts;
    }


}
