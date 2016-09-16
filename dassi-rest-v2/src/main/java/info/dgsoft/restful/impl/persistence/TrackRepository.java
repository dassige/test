package info.dgsoft.restful.impl.persistence;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import info.dgsoft.restful.auth.domain.entity.User;
import info.dgsoft.restful.domain.entity.DGTrackEntity;

@Transactional
public interface TrackRepository extends CrudRepository<DGTrackEntity, Long>
{

	public DGTrackEntity findById(int id);
	public Collection<DGTrackEntity> findByOrigin(String origin);

}
