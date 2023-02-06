package dev.yestoday.yestoday.core.user.infrastructure;

import dev.yestoday.yestoday.core.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickname(String nickname);

    List<User> findByNicknameContaining(String nickname);
}
