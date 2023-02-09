package dev.yestoday.yestoday.core.post.application;

import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.post.dto.PostDTO;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.post.infrastructure.PostRepository;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostService {
    @Autowired
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository,UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> findAll() { return postRepository.findAll(); }

    public void save(Post newPost) {
        User user  = userRepository.findById(newPost.getUserId()).get();
        newPost.setUser(user);
        postRepository.save(newPost);
    }

    public List<Post> delete(Long id){
        postRepository.deleteById(id);
        return postRepository.findAll();
    }

    public void update(PostDTO newPost){
        Post updatePost = postRepository.findById(newPost.getId()).get();
        User user = userRepository.findById(newPost.getUserId()).get();
        updatePost.setUser(user);

        updatePost.setContent(newPost.getContent());
        updatePost.setImageUrl(newPost.getImageUrl());
        updatePost.setImageType(newPost.getImageType());
        postRepository.save(updatePost);

    }
}