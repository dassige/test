package info.dgsoft.restful.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import info.dgsoft.ApplicationConfiguration;
import info.dgsoft.restful.api.domain.entity.DGService;
import info.dgsoft.restful.impl.ServicesInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class MainController
{
	@Autowired
	private ServicesInterface serviceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String index()
	{
		return "Proudly handcrafted by " + "<a href='http://dgsoft.info/'>DGSoft Ltd.</a>";
	}

	@ApiOperation(value = "GetServices", nickname = "nick GetServices", notes = "gets the services")
	@ApiResponses(
			value = { @ApiResponse(code = 200, message = "Success", response = DGService.class),
					@ApiResponse(code = 401, message = "Unauthorized"),
					@ApiResponse(code = 403, message = "Forbidden"),
					@ApiResponse(code = 404, message = "Not Found"),
					@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/services/services", method = RequestMethod.GET,
			produces = "application/json")
	@ResponseBody
	public Collection<DGService> getServices()
	{
		Collection<DGService> dgServices = serviceImpl.getServices();
		return dgServices;
	}

	@ApiOperation(value = "GetInfo", nickname = "nick GetInfo", notes = "get app info")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/services/info", method = RequestMethod.GET,
			produces = "application/json")
	@ResponseBody
	public String getApplicationInfo()
	{
		return new ApplicationConfiguration().getInfo();
	}
}
