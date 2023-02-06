package dev.yestoday.yestoday.core.comment.application;

import dev.yestoday.yestoday.core.comment.domain.Comment;
import dev.yestoday.yestoday.core.comment.dto.CommentDTO;
import dev.yestoday.yestoday.core.comment.infrastructure.CommentRepository;
import dev.yestoday.yestoday.core.post.infrastructure.PostRepository;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void save(Comment newComment){
        newComment.setUser(userRepository.findById(newComment.getUserId()).get());

//
//        Feed feed = feedRepository.findById(newComment.getFeedId()).get();
//        newComment.setFeed(feed);

        commentRepository.save(newComment);

    }

    public void delete(Long commentId){
        commentRepository.deleteById(commentId);

    }

    public List<CommentDTO> findByPostId(Long postId){
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentDTO> returnComments = new ArrayList<>();

        for (Comment comment: comments
             ) {
            returnComments.add(new CommentDTO(comment));
        }
        return  returnComments;
    }
}
