package demo.repository;

import org.springframework.data.repository.CrudRepository;
import demo.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {


}