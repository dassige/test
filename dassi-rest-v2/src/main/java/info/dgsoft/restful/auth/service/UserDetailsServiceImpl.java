package info.dgsoft.restful.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import info.dgsoft.restful.auth.domain.entity.User;
import info.dgsoft.restful.auth.model.factory.SecurityUserFactory;
import info.dgsoft.restful.auth.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = this.userRepository.findByUsername(username);

		if (user == null)
		{
			throw new UsernameNotFoundException(
					String.format("No user found with username '%s'.", username));
		} else
		{
			return SecurityUserFactory.create(user);
		}
	}

}
