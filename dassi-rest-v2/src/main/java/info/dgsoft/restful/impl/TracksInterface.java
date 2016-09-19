package info.dgsoft.restful.impl;

import java.util.Collection;

import info.dgsoft.restful.domain.entity.DGTrackEntity;

public interface TracksInterface
{
	public Collection<DGTrackEntity> getTracks(String origin);

	void saveTrack(DGTrackEntity track);

	Collection<String> getTracked();
}
