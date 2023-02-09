package dev.yestoday.yestoday.core.likes.infrastructure;

import dev.yestoday.yestoday.core.likes.domain.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LikesRepository extends JpaRepository<Likes, Long> {
    public List<Likes> findByUserId (Long id);
    public Likes findByUserIdAndPostId(Long userId, Long postId);
}
