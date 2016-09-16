package info.dgsoft.restful.api.service;

import java.io.Serializable;
import java.sql.Timestamp;

public class DGTrack implements Serializable
{

	private static final long serialVersionUID = 5876938207003243418L;

	private int id;
	private String origin;
	private Double longitude;
	private Double latitude;
	private Timestamp localTime;
	private Double speed;

	public DGTrack()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public DGTrack(int id, String origin, Double longitude, Double latitude, Timestamp localTime,
			Double speed)
	{
		super();
		this.id = id;
		this.origin = origin;
		this.longitude = longitude;
		this.latitude = latitude;
		this.localTime = localTime;
		this.speed = speed;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getOrigin()
	{
		return origin;
	}

	public void setOrigin(String origin)
	{
		this.origin = origin;
	}

	public Double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	public Double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	public Timestamp getLocalTime()
	{
		return localTime;
	}

	public void setLocalTime(Timestamp localTime)
	{
		this.localTime = localTime;
	}

	public Double getSpeed()
	{
		return speed;
	}

	public void setSpeed(Double speed)
	{
		this.speed = speed;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((localTime == null) ? 0 : localTime.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		DGTrack other = (DGTrack) obj;
		if (id != other.id) return false;
		if (latitude == null)
		{
			if (other.latitude != null) return false;
		} else if (!latitude.equals(other.latitude)) return false;
		if (localTime == null)
		{
			if (other.localTime != null) return false;
		} else if (!localTime.equals(other.localTime)) return false;
		if (longitude == null)
		{
			if (other.longitude != null) return false;
		} else if (!longitude.equals(other.longitude)) return false;
		if (origin == null)
		{
			if (other.origin != null) return false;
		} else if (!origin.equals(other.origin)) return false;
		if (speed == null)
		{
			if (other.speed != null) return false;
		} else if (!speed.equals(other.speed)) return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("DGTrack [id=");
		builder.append(id);
		builder.append(", origin=");
		builder.append(origin);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", localTime=");
		builder.append(localTime);
		builder.append(", speed=");
		builder.append(speed);
		builder.append("]");
		return builder.toString();
	}

}
