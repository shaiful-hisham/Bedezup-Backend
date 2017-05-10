package com.tams.bedezup.server;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tams.bedezup.client.GoodService;
import com.tams.bedezup.domain.Good;
import com.tams.bedezup.server.dao.GoodDAO;
import com.tams.bedezup.server.mapper.OrikaDTOMapper;
import com.tams.bedezup.shared.dto.GoodDTO;

@Service("goodService")
public class GoodServiceImpl extends RemoteServiceServlet implements GoodService, GoodRestService {

	private static final long serialVersionUID = 9095836137165229521L;
	
	@Autowired
	private OrikaDTOMapper orikaDTOMapper;
	
	@Autowired
	private GoodDAO goodDAO;
	
	
	/*
	 * Methods for GXT client
	 */
	@Override
	public GoodDTO findGoodDTOByIdEquals(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodDTO> findGoodDTOList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Methods for Restful web service
	 */
	@Override
	public Good findGoodByIdEquals(Long id) {
		return goodDAO.findOne(id);
	}

	@Override
	public ArrayList <Good> findGoodList() {
		return (ArrayList<Good>) goodDAO.findAll();
	}
}
