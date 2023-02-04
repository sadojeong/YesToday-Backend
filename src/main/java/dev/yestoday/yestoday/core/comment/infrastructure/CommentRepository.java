package dev.yestoday.yestoday.core.comment.infrastructure;

import dev.yestoday.yestoday.core.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByPostId(Long id);
}
