package info.dgsoft.restful.impl.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import info.dgsoft.restful.auth.domain.entity.User;
import info.dgsoft.restful.domain.entity.DGServiceEntity;

@Transactional
public interface ServiceRepository extends CrudRepository<DGServiceEntity, Long>
{

	public User findById(int id);

}
