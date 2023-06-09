package com.kaly7dev.socialntapp.controllers;

import com.kaly7dev.socialntapp.coreapi.dtos.CommentsDto;
import com.kaly7dev.socialntapp.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/create")
    public ResponseEntity<Void> createComment(@RequestBody CommentsDto commentsDto){
        commentService.createComment(commentsDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(params = "postId")
    public ResponseEntity<List<CommentsDto>> getCommentListForPost(@RequestParam Long postId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentService.getCommentListForPost(postId));
    }
    @GetMapping(params = "username")
    public ResponseEntity<List<CommentsDto>> getCommentListForUser(@RequestParam String username){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentService.getCommentListForUser(username));
    }
}
