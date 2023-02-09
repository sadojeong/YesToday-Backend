package dev.yestoday.yestoday.core.follow.application;

import dev.yestoday.yestoday.core.follow.domain.Follow;
import dev.yestoday.yestoday.core.follow.dto.FollowDTO;
import dev.yestoday.yestoday.core.follow.infrastructure.FollowRepository;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    @Autowired
    private final FollowRepository followRepository;

    private final UserRepository userRepository;

    public FollowService(FollowRepository followRepository, UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    public List<Follow> findAll() {
        return followRepository.findAll();
    }

    public void save(Follow newFollow) {
        followRepository.save(newFollow);
    }

    public int numberOfFollower(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        List<Follow> follower = followRepository.findAllByFollowUser(user).orElseThrow();

        return follower.size();
    }

    public void delete(Long userId, Long followUserId) {
        User user = userRepository.findById(userId).orElseThrow();
        User followUser = userRepository.findById(followUserId).orElseThrow();
        List<Follow> follows = followRepository.findAllByUserAndFollowUser(user, followUser).orElseThrow();

        followRepository.deleteAll(follows);
    }

    public List<Follow> findByUserId(Long UserId){
        return followRepository.findByUserId(UserId);
    }

    public boolean checkFollow(Long userId, Long followUserId) {
        User user = userRepository.findById(userId).orElseThrow();
        User followUser = userRepository.findById(followUserId).orElseThrow();
        List<Follow> follows = followRepository.findAllByUserAndFollowUser(user, followUser).orElseThrow();
        return !follows.isEmpty();
    }

}
