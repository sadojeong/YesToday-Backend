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

    public List<Follow> delete(Long id){
        followRepository.deleteById(id);
        return followRepository.findAll();
    }

    public List<Follow> findByUserId(Long UserId){
        return followRepository.findByUserId(UserId);
    }

}
