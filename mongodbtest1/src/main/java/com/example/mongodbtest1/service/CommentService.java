package com.example.mongodbtest1.service;

import com.example.mongodbtest1.dao.CommentRepository;
import com.example.mongodbtest1.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }

    public Comment findCommentById(String id) {
        return commentRepository.findById(id).get();
    }

    public List<Comment> findCommentList() {
        return commentRepository.findAll();
    }

    public Page<Comment> findCommentListByParentid(String parentid, int page, int size) {
        return commentRepository.findByParentid(parentid, PageRequest.of(page-1, size));
    }

    public void updateCommentLinknum(String id) {
        // 查询条件
        Query query = Query.query(Criteria.where("_id").is(id));
        // 更新条件
        Update update = new Update();
        update.inc("linknum");
        mongoTemplate.updateFirst(query, update, Comment.class);

    }
}
