package info.dgsoft.restful.model.factory;

import info.dgsoft.restful.api.service.DGTrack;
import info.dgsoft.restful.domain.entity.DGTrackEntity;

public class DGTrackFactory
{

	public static DGTrack create(DGTrackEntity entity)
	{
		return new DGTrack(entity.getId(), entity.getOrigin(), entity.getLongitude(),
				entity.getLatitude(), entity.getLocalTime(), entity.getSpeed());
	}

	public static DGTrackEntity create(DGTrack track)
	{
		return new DGTrackEntity(track.getId(), track.getOrigin(), track.getLongitude(),
				track.getLatitude(), track.getLocalTime(), track.getSpeed());
	}

}
