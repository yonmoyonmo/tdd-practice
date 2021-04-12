package tdd.practice;

import org.springframework.data.jpa.repository.JpaRepository;
import tdd.practice.entity.UserName;

public interface UserNameRepository extends JpaRepository<UserName, Long> {
}
