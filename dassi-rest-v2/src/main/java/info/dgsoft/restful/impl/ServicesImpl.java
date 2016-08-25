package info.dgsoft.restful.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.dgsoft.restful.domain.entity.DGServiceEntity;
import info.dgsoft.restful.impl.persistence.ServiceRepository;

@Service
public class ServicesImpl implements ServicesInterface
{

	@Autowired
	private ServiceRepository serviceRepo;

	@Override
	public Collection<DGServiceEntity> getServices()
	{
		return (Collection<DGServiceEntity>) serviceRepo.findAll();
	}

}