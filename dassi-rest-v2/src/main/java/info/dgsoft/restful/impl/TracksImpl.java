package info.dgsoft.restful.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.dgsoft.restful.domain.entity.DGTrackEntity;
import info.dgsoft.restful.impl.persistence.TrackRepository;

@Service
public class TracksImpl implements TracksInterface
{

	@Autowired
	private TrackRepository repo;

	@Override
	public Collection<DGTrackEntity> getTracks(String origin)
	{
		return (Collection<DGTrackEntity>) repo.findByOrigin(origin);
	}

	@Override
	public void saveTrack(DGTrackEntity entity)
	{
		repo.save(entity);
	}
}