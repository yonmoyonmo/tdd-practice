package tdd.practice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdd.practice.entity.UserName;

@Repository
public interface UserNameRepository extends JpaRepository<UserName, Long> {
    Long countByUserName(String userName);
}
