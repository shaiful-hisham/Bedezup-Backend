package com.tams.bedezup.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.tams.bedezup.shared.dto.GoodDTO;

public interface GoodServiceAsync {

	void findGoodDTOByIdEquals(Long id, AsyncCallback<GoodDTO> callback);

	void findGoodDTOList(AsyncCallback<ArrayList<GoodDTO>> callback);

}
