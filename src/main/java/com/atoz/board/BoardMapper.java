package com.atoz.board;

import com.atoz.post.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  BoardMapper {
    void addPost(PostDto postDto);
    List<PostDto> findPosts(int boardId);
}
