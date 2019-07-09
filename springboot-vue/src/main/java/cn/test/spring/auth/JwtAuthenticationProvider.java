package cn.test.spring.auth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider
{
	Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	protected HttpServletRequest request;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		String authToken = (String) authentication.getPrincipal();
		String username = "";//JwtTokenUtil.getUsernameFromToken(authToken);
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if(auth!=null && auth.isAuthenticated())
//		{
//			return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), null, new ArrayList<>());
//		}
		if (username != null ) {
//			if (JwtTokenUtil.isTokenExpired(authToken)) {
//				throw new CredentialsExpiredException("Access Token is expired. Please login again.");
//			}

		} else {
			throw new BadCredentialsException("Invalid token String.");
		}

		logger.info("user: {} Authenticated successfully.",username);
		return new UsernamePasswordAuthenticationToken(authToken, null, new ArrayList<>());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
