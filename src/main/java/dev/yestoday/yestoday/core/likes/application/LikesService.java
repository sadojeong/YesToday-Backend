package dev.yestoday.yestoday.core.likes.application;

import dev.yestoday.yestoday.core.likes.dto.LikesDTO;
import dev.yestoday.yestoday.core.post.infrastructure.PostRepository;
import dev.yestoday.yestoday.core.likes.domain.Likes;
import dev.yestoday.yestoday.core.likes.infrastructure.LikesRepository;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LikesService {

    private LikesRepository likesRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public LikesService(LikesRepository likesRepository, UserRepository userRepository, PostRepository postRepository) {
        this.likesRepository = likesRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<Likes> findAll(){
        return likesRepository.findAll();
    }

    public List<Likes> save(LikesDTO newLikes){
        User user = userRepository.findById(newLikes.getUserId()).get();
        newLikes.setUser(user);

//        Feed feed = feedRepository.findById(newLikes.getFeedId()).get();
//        newLikes.setFeed(feed);

        likesRepository.save(newLikes.toLikesEntity());
        return likesRepository.findAll();
    }

    public List<Likes> delete(Long likeId){
        likesRepository.deleteById(likeId);
        return likesRepository.findAll();
    }

    public List<Likes> findByUserId(Long userId){
        return likesRepository.findByUserId(userId);
    }

    public boolean findByUserIdAndPostId(Long userId, Long PostId){
        if (likesRepository.findByUserIdAndPostId(userId, PostId).isEmpty()){
            return false;
        }
        return true;
    }
}
