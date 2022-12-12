package com.atoz.post.helper;

import com.atoz.post.PostService;
import com.atoz.post.dto.request.AddPostRequestDto;
import com.atoz.post.dto.request.DeletePostRequestDto;
import com.atoz.post.dto.request.OpenPostRequestDto;
import com.atoz.post.dto.request.UpdatePostRequestDto;
import com.atoz.post.dto.PostDto;
import com.atoz.post.dto.response.PostResponseDto;

public class StubPostService implements PostService {
    @Override
    public void addPost(AddPostRequestDto addPostRequestDto) {

    }

    @Override
    public void updatePost(UpdatePostRequestDto updatePostRequestDto) {

    }

    @Override
    public void deletePost(DeletePostRequestDto deletePostRequestDto) {

    }

    @Override
    public PostResponseDto findById(OpenPostRequestDto openPostRequestDto) {
        return null;
    }
}