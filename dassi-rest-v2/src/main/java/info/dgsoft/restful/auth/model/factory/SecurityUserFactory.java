package info.dgsoft.restful.auth.model.factory;

import org.springframework.security.core.authority.AuthorityUtils;

import info.dgsoft.restful.api.domain.entity.User;
import info.dgsoft.restful.auth.model.security.SecurityUser;

public class SecurityUserFactory
{

	public static SecurityUser create(User user)
	{
		return new SecurityUser(user.getId(), user.getUsername(), user.getPassword(),
				user.getEmail(), user.getLastPasswordReset(),
				AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities()));
	}

}
