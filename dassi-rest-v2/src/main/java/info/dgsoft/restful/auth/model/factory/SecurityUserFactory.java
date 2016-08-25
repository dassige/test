package info.dgsoft.restful.auth.model.factory;

import org.springframework.security.core.authority.AuthorityUtils;

import info.dgsoft.restful.api.security.SecurityUser;
import info.dgsoft.restful.auth.domain.entity.User;

public class SecurityUserFactory
{

	public static SecurityUser create(User user)
	{
		return new SecurityUser(user.getId(), user.getUsername(), user.getPassword(),
				user.getEmail(), user.getLastPasswordReset(),
				AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities()));
	}

}
