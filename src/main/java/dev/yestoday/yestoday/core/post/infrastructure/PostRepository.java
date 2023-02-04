package dev.yestoday.yestoday.core.post.infrastructure;

import dev.yestoday.yestoday.core.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
