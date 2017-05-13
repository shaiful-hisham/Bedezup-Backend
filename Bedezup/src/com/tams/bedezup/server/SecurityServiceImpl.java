package com.tams.bedezup.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tams.bedezup.client.SecurityService;
import com.tams.bedezup.domain.SystemUser;
import com.tams.bedezup.shared.SessionEndedException;
import com.tams.bedezup.shared.UserState;

@Service("securityService")
public class SecurityServiceImpl extends RemoteServiceServlet implements SecurityService {

	private static Logger logger = Logger.getLogger(SecurityServiceImpl.class);
		
	private static final long serialVersionUID = -1750860652397204954L;

	
	@Override
	public UserState login(String userName, String password) {
		logger.debug("Login: Username: " + userName + ", Password: " + password);
		UserState state = new UserState();
		state.setStateObject(UserState.REDIRECT_STRING, "App.html");
		
		return state;
	}

	@Override
	public UserState logout() {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserState state = null;
		
		if (request != null) {
			// Get http session associates with this request, return null if not available
			HttpSession session = request.getSession(false);
		
			if (session != null) {
				state = (UserState) session.getAttribute(UserState.USER_STATE);
				
				if (state != null) {
					state.setStateObject(UserState.REDIRECT_STRING, "Login.html");
					
					// Update on logout info for system User
					/*Date now = new Date();
					Long userId = (Long) state.getStateObject(UserState.SYSTEM_USER_ID);
					SystemUser systemUser = systemUserDAO.findSystemUserByIdEquals(userId);
					systemUser.setLastLogout(now);
					systemUserDAO.updateSystemUser(systemUser);*/
					
					// Just to make sure
					session.removeAttribute(UserState.USER_STATE);
				}
				// If user state null, construct basic user state with redirection page url
				else {
					state = new UserState();
					state.setStateObject(UserState.REDIRECT_STRING, "Login.html");
				}
				
				session.invalidate();
			}
			// If session null, construct basic user state with redirection page url
			else {
				state = new UserState();
				state.setStateObject(UserState.REDIRECT_STRING, "Login.html");
			}
		}
		// If request null, construct basic user state with redirection page url
		else {
			state = new UserState();
			state.setStateObject(UserState.REDIRECT_STRING, "Login.html");
		}
		
		return state;
	}

	@Override
	public SystemUser getCurrentLoggedInSystemUser() throws SessionEndedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserState getCurrentLoggedInSystemUserState() throws SessionEndedException {
		// TODO Auto-generated method stub
		return null;
	}
}
