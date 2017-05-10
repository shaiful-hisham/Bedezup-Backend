package com.tams.bedezup.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.tams.bedezup.shared.dto.GoodDTO;

@RemoteServiceRelativePath("springGwtServices/goodService")
public interface GoodService extends RemoteService {

	public GoodDTO findGoodDTOByIdEquals(Long id);
	
	public ArrayList <GoodDTO> findGoodDTOList();
	
	
	public static class Util {
		
		private static volatile GoodServiceAsync instance;
		
		// Enforce singleton, double checked locking
		public static GoodServiceAsync getInstance(){
			if (instance == null) {
				
				synchronized(Util.class) {
					
					if (instance == null) {
						instance = GWT.create(GoodService.class);
						ServiceDefTarget target = (ServiceDefTarget) instance;
						target.setServiceEntryPoint(GWT.getModuleBaseURL() + "springGwtServices/goodService");
					}
				}
			}
			return instance;
		}
	}
}
