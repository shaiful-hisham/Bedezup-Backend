package com.tams.bedezup.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.tams.bedezup.shared.dto.SystemUserDTO;

@RemoteServiceRelativePath("springGwtServices/systemUserService")
public interface SystemUserService extends RemoteService {

	SystemUserDTO findSystemUserDTOByUserNameAndPasswordEqual(String userName, String password);
}
