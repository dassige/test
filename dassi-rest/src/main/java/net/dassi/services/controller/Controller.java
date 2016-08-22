package net.dassi.services.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.dassi.services.api.Employee;
import net.dassi.services.api.Service;
import net.dassi.services.impl.EmployeeImpl;
import net.dassi.services.impl.ServicesImpl;

@RestController
public class Controller {

	@ApiOperation(value = "GetEmployee", nickname = "nick GetEmployee", notes = "get the employees")

	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = Employee.class),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), 
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/api/services/employees", method = RequestMethod.GET, produces = "application/json")
	public Collection<Employee> getEmployeeNames() {
		return EmployeeImpl.getEmployees();
	}

	@ApiOperation(value = "GetServices", nickname = "nick GetServices", notes = "gets the services")

	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = Service.class),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), 
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/api/services/services", method = RequestMethod.GET, produces = "application/json")
	public Collection<Service> getServices() {
		return new ServicesImpl().getServices();
	}

}
