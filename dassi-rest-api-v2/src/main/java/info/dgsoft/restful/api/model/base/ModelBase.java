package info.dgsoft.restful.api.model.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ModelBase implements Serializable
{

	@Override
	public String toString()
	{
		return ReflectionToStringBuilder.toString(this);
	}

}
