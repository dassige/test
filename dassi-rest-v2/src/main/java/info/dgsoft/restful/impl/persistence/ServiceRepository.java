package info.dgsoft.restful.impl.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import info.dgsoft.restful.api.domain.entity.DGService;
import info.dgsoft.restful.api.domain.entity.User;

@Transactional
public interface ServiceRepository extends CrudRepository<DGService, Long>
{

	public User findById(int id);

}
