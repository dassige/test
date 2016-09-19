package info.dgsoft.restful.impl.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import info.dgsoft.restful.domain.entity.DGTrackEntity;

@Transactional
public interface TrackRepository extends CrudRepository<DGTrackEntity, Long>
{

	public DGTrackEntity findById(int id);
	public Collection<DGTrackEntity> findByOrigin(String origin);
	@Query(value = "SELECT DISTINCT origin FROM gps_tracks " +
	        "ORDER BY origin ASC",
	        nativeQuery = true
	)
	public Collection<String> listTracked();

}
