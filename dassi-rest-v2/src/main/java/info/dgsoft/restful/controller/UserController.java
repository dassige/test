package info.dgsoft.restful.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import info.dgsoft.restful.api.security.SecurityUser;
import info.dgsoft.restful.auth.domain.entity.User;
import info.dgsoft.restful.auth.model.factory.SecurityUserFactory;
import info.dgsoft.restful.auth.repository.UserRepository;

@Controller
public class UserController
{

	@Autowired
	private UserRepository userDao;

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Collection<SecurityUser> getAll()
	{
		try
		{
			Collection<User> users = (Collection<User>) userDao.findAll();
			Collection<SecurityUser> securityUsers = new ArrayList<>();
			for (User user : users)
			{
				securityUsers.add(SecurityUserFactory.create(user));
			}

			return securityUsers;
		} catch (Exception ex)
		{
			return null;
		}

	}

	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public SecurityUser getUser(@PathVariable String username)
	{
		try
		{
			User user = userDao.findByUsername(username);
			return SecurityUserFactory.create(user);
		} catch (Exception ex)
		{
			return null;
		}

	}

}
