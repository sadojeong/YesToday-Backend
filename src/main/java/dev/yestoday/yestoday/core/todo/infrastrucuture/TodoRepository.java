package dev.yestoday.yestoday.core.todo.infrastrucuture;

import dev.yestoday.yestoday.core.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findByUserIdAndTodoDate(Long userId, LocalDate todoDate);
    public List<Todo> findByUserIdAndIsPosted(Long userId, boolean isPosted);
}
