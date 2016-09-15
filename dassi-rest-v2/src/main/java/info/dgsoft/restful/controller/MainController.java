package info.dgsoft.restful.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.dgsoft.ApplicationConfiguration;
import info.dgsoft.restful.api.service.DGService;
import info.dgsoft.restful.domain.entity.DGServiceEntity;
import info.dgsoft.restful.impl.ServicesInterface;
import info.dgsoft.restful.model.factory.DGServiceFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MainController
{
	private final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private ServicesInterface serviceImpl;
	@RequestMapping(value = "/public/",method = RequestMethod.GET)
	@ResponseBody
	public String index()
	{
		return "Proudly handcrafted by " + "<a href='http://dgsoft.info/'>DGSoft Ltd.</a>";
	}

	@ApiOperation(value = "GetServices", nickname = "nick GetServices", notes = "gets the services")
	@ApiResponses(
			value = { @ApiResponse(code = 200, message = "Success", response = DGServiceEntity.class),
					@ApiResponse(code = 401, message = "Unauthorized"),
					@ApiResponse(code = 403, message = "Forbidden"),
					@ApiResponse(code = 404, message = "Not Found"),
					@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/services/services", method = RequestMethod.GET,
			produces = "application/json")
	@ResponseBody
	public Collection<DGService> getServices()
	{
		Collection<DGServiceEntity> dgServiceEntities = serviceImpl.getServices();
		Collection<DGService> dgServices = new ArrayList<>();
		for (DGServiceEntity entity : dgServiceEntities)
		{
			dgServices.add(DGServiceFactory.create(entity));
			
		}
		return dgServices;
	}
	
	@ApiOperation(value = "DisplayBody", nickname = "nick DisplayBody", notes = "displays the body content of the request")
	@RequestMapping(value = "/public/tools/body" , method = RequestMethod.POST,
			produces = "application/json")
	@ResponseBody
	public String displayBody(@RequestBody String body)
	{
		logger.debug(body);
		return body;
	}

	@ApiOperation(value = "GetInfo", nickname = "nick GetInfo", notes = "get app info")
	@RequestMapping(value = "/public/services/info/", method = RequestMethod.GET,
			produces = "application/json")
	@ResponseBody
	public String getApplicationInfo()
	{
		return ":-O";
		//return new ApplicationConfiguration().getInfo();
	}
}
