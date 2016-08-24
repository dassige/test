package info.dgsoft.restful.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import info.dgsoft.restful.api.domain.entity.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long>
{

	public User findByUsername(String username);

}
