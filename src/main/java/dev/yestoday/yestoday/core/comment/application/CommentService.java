package dev.yestoday.yestoday.core.comment.application;

import dev.yestoday.yestoday.core.comment.domain.Comment;
import dev.yestoday.yestoday.core.comment.dto.CommentDTO;
import dev.yestoday.yestoday.core.comment.infrastructure.CommentRepository;
import dev.yestoday.yestoday.core.post.infrastructure.PostRepository;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentService {
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public List<Comment> save(CommentDTO newComment){
        User user = userRepository.findById(newComment.getUserId()).get();
        newComment.setUser(user);
//
//        Feed feed = feedRepository.findById(newComment.getFeedId()).get();
//        newComment.setFeed(feed);

        commentRepository.save(newComment.toCommentEntity());
        return commentRepository.findAll();
    }

    public List<Comment> delete(Long commentId){
        commentRepository.deleteById(commentId);
        return commentRepository.findAll();
    }

    public List<Comment> findByPostId(Long postId){

        return  commentRepository.findByPostId(postId);
    }
}
