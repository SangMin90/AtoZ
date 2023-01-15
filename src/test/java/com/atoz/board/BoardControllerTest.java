package com.atoz.board;

import com.atoz.board.helper.StubBoardService;
import com.atoz.error.GlobalExceptionAdvice;
import com.atoz.post.dto.request.AddPostRequestDto;
import com.atoz.post.dto.response.PostResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
class BoardControllerTest {

    private MockMvc sut;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private StubBoardService boardService = new StubBoardService();

    @BeforeEach
    void setUp() {
        boardService.addPost(
                AddPostRequestDto.builder()
                        .title("testTitle1")
                        .content("testContent1")
                        .build());
        boardService.addPost(
                AddPostRequestDto.builder()
                        .title("testTitle2")
                        .content("testContent2")
                        .build());

        sut = MockMvcBuilders
                .standaloneSetup(new BoardController(boardService))
                .defaultResponseCharacterEncoding(StandardCharsets.UTF_8)
                .setControllerAdvice(GlobalExceptionAdvice.class)
                .build();


    }

    @Test
    void list_게시판에_속한_모든_게시글을_응답해야한다() throws Exception {
        ResultActions resultActions = sut.perform(get("/board/1")
                .contentType(MediaType.APPLICATION_JSON));

        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();
        List<PostResponseDto> actualPosts = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                new TypeReference<List<PostResponseDto>>() {});

        assertThat(actualPosts.size()).isEqualTo(2);
    }
}