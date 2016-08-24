package info.dgsoft.restful.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.dgsoft.restful.api.domain.entity.User;
import info.dgsoft.restful.auth.repository.UserRepository;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author net.dgsoft
 */
@Controller
public class UserController
{

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	@RequestMapping("/get-all")
	@ResponseBody
	public Collection<User> getAll()
	{
		try
		{
			Collection<User> users = (Collection<User>) userDao.findAll();
			return users;
		} catch (Exception ex)
		{
			return null;
		}

	}

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	@Autowired
	private UserRepository userDao;

} // class UserController
