package dev.yestoday.yestoday.core.user.infrastructure;

import dev.yestoday.yestoday.core.user.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByKey(String key);
}
