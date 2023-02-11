package com.testbook.domain.comments;

import com.testbook.domain.posts.Posts;
import com.testbook.domain.posts.PostsRepository;
import com.testbook.service.posts.PostsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentsRepositoryTest {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleaUp() {
        commentsRepository.deleteAll();
    }

    @Test
    public void 댓글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "ummchicken";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());

        String comment = "테스트 댓글";

    }

}