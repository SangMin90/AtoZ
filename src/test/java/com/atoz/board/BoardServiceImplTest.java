package com.atoz.board;

import com.atoz.post.PostMapper;
import com.atoz.post.dto.PostDto;
import com.atoz.post.dto.request.AddPostRequestDto;
import com.atoz.post.dto.response.PostResponseDto;
import com.atoz.post.helper.SpyPostMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BoardServiceImplTest {
    private BoardServiceImpl sut;
    private BoardMapper boardMapper;

    @BeforeEach
    public void setUp() {
        boardMapper = new StubBoardMapper();
        sut = new BoardServiceImpl();
    }

    @Test
    void findPosts_해당메서드가_존재한다() {
        AddPostRequestDto requestDto1 = AddPostRequestDto.builder()
                .title("testTitle1")
                .content("testContent1")
                .build();
        AddPostRequestDto requestDto2 = AddPostRequestDto.builder()
                .title("testTitle2")
                .content("testContent2")
                .build();
        boardMapper.addPost(requestDto1);
        boardMapper.addPost(requestDto2);


        List<PostResponseDto> posts = sut.findPosts(1);


//        assertThat(posts.size()).isEqualTo(2);
//        assertThat(posts.get(0)).isEqualTo(requestDto1);
//        assertThat(posts.get(1)).isEqualTo(requestDto2);
    }
}