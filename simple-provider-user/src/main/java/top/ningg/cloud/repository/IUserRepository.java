package top.ningg.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.ningg.cloud.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
