package com.example.mongodbtest1;

import com.example.mongodbtest1.entity.Comment;
import com.example.mongodbtest1.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class Mongodbtest1ApplicationTests {

    @Autowired
    private CommentService commentService;

    @Test
    public void testFindCommentList() {
        List<Comment> list = commentService.findCommentList();
        System.out.println(list);
    }
    @Test
    public void testFindCommentById() {
        Comment comment = commentService.findCommentById("633da08296527e251aff0afa");
        System.out.println(comment);
    }
    @Test
    public void testSaveComment() {
        Comment comment = new Comment();
        comment.setId("1");
        comment.setActicleid("200000");
        comment.setContent("测试下");
        comment.setLinknum(2000);
        comment.setNickname("mike");
        comment.setState(0);
        comment.setCreateDataTime(LocalDateTime.now());
        commentService.saveComment(comment);
    }
    @Test
    public void testFindCommentListByParentid() {
        Page<Comment> page = commentService.findCommentListByParentid("3", 1, 2);
        System.out.println(page.getTotalPages());
        System.out.println(page.getContent());
    }

    @Test
    public void testUpdateCommentLinknum() {
        commentService.updateCommentLinknum("1");
    }
}
