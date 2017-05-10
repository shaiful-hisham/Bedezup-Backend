/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.tams.bedezup.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.tams.bedezup.shared.dto.JobDTO;

@RemoteServiceRelativePath("springGwtServices/jobService")
public interface JobService extends RemoteService {
	
	public JobDTO findJobDTOByIdEquals(Long id);
	
	public ArrayList <JobDTO> findJobDTOList();
	
	public List <JobDTO> findJobDTOListByJobStatusCodeEquals(String jobStatusCode);
	
	
	public static class Util {
		
		private static volatile JobServiceAsync instance;
		
		// Enforce singleton, double checked locking
		public static JobServiceAsync getInstance(){
			if (instance == null) {
				synchronized(Util.class) {
					if (instance == null) {
						instance = GWT.create(JobService.class);
						ServiceDefTarget target = (ServiceDefTarget) instance;
						target.setServiceEntryPoint(GWT.getModuleBaseURL() + "springGwtServices/jobService");
					}
				}
			}
			
			return instance;
		}
	}
}
