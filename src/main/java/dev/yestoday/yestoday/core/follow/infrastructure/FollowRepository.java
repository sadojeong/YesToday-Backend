package dev.yestoday.yestoday.core.follow.infrastructure;

import dev.yestoday.yestoday.core.follow.domain.Follow;
import dev.yestoday.yestoday.core.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<List<Follow>> findAllByFollowUser(User user);
    public List<Follow> findByUserId(Long userId);
}
