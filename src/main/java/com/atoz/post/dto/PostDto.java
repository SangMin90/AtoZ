package com.atoz.post.dto;

import com.atoz.post.dto.response.PostResponseDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private int postId;
    private String userId;

    private String title;
    private String content;

    private int likeCount;
    private int viewCount;

    private String comments;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostResponseDto toPostResponseDto() {
        return PostResponseDto.builder()
                .postId(getPostId())
                .userId(getUserId())
                .title(getTitle())
                .content(getContent())
                .likeCount(getLikeCount())
                .viewCount(getViewCount())
                .comments(getComments())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .build();
    }
}
