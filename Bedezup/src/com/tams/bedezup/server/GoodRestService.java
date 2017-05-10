package com.tams.bedezup.server;

import java.util.ArrayList;

import com.tams.bedezup.domain.Good;

public interface GoodRestService {

	public Good findGoodByIdEquals(Long id);
	
	public ArrayList <Good> findGoodList();
}
