package info.dgsoft.restful.model.factory;

import info.dgsoft.restful.api.service.DGService;
import info.dgsoft.restful.domain.entity.DGServiceEntity;

public class DGServiceFactory
{

	public static DGService create(DGServiceEntity entity)
	{
		return new DGService(entity.getId(), entity.getName(), entity.getUrl());
	}

}
