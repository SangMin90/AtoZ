package com.atoz.board;

import com.atoz.post.dto.response.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{id}")
    public List<PostResponseDto> list(@PathVariable("id") int boardId) {
        List<PostResponseDto> posts = boardService.findPosts(boardId);
        return posts;
    }
}
