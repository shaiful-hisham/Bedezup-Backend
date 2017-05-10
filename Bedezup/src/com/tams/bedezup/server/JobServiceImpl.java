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
package com.tams.bedezup.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tams.bedezup.client.JobService;
import com.tams.bedezup.domain.Job;
import com.tams.bedezup.server.dao.JobDAO;
import com.tams.bedezup.shared.dto.JobDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Service("jobService")
public class JobServiceImpl extends RemoteServiceServlet implements JobService, JobRestService {

	private static final long serialVersionUID = 3420155716311012558L;
	
	@Autowired
	private JobDAO jobDAO;
	
	
	/*
	 * Methods for GXT client
	 */
	@Override
	public JobDTO findJobDTOByIdEquals(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<JobDTO> findJobDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobDTO> findJobDTOListByJobStatusCodeEquals(String jobStatusCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Methods for Restful web service
	 */
	@Override
	public Job findJobByIdEquals(Long id) {
		return jobDAO.findOne(id);
	}
	
	@Override
	public ArrayList<Job> findJobList() {
		return (ArrayList<Job>) jobDAO.findAll();
	}

	@Override
	public List<Job> findJobListByJobStatusCodeEquals(String jobStatusCode) {
		return jobDAO.findJobListByJobStatusCodeEquals(jobStatusCode);
	}
}
