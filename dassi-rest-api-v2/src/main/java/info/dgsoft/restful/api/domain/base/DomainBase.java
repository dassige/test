package info.dgsoft.restful.api.domain.base;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class DomainBase implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString()
	{
		return ReflectionToStringBuilder.toString(this);
	}

}
