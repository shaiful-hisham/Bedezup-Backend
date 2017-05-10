package com.tams.bedezup.client.icon;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Icons extends ClientBundle {
	@Source("login-icon.png")ImageResource login();
	@Source("logout-icon.png")ImageResource logout();
	@Source("reset-icon.png")ImageResource reset();
	@Source("reset16.png")ImageResource reset16();
	@Source("grid.png")ImageResource grid();
	
	@Source("expand-icon.png")ImageResource expand();
	@Source("collapse-icon.png")ImageResource collapse();
	
	@Source("app-icon.png")ImageResource app();
	@Source("save-icon.png")ImageResource app_add();
	@Source("read-icon.png")ImageResource app_read();
	@Source("delete-icon.png")ImageResource app_del();
	@Source("update-icon.png")ImageResource app_edit();
	@Source("retrieve-icon.png")ImageResource app_retrieve();
	
	@Source("attachment-icon.png")ImageResource attachment();
	@Source("excel-icon.png")ImageResource excel();
	@Source("pdf.png")ImageResource pdf();
	
	@Source("ok-icon.png")ImageResource ok();
	@Source("finalize-icon.png")ImageResource finalized();
	
	@Source("submit-icon.png")ImageResource save();
	@Source("cancel-icon.png")ImageResource cancel();
	
	@Source("bar_chart.png")ImageResource bar_chart();
	
	@Source("yes24.png")ImageResource yes();
	@Source("submit.png")ImageResource submit();
	
	@Source("folder.png")ImageResource folder();
	
	@Source("forget-password-icon.png")ImageResource forgetPassword();
	@Source("change-password-icon.png")ImageResource changePassword();
	
	@Source("profile-icon.png")ImageResource profile();
	@Source("income-icon.png")ImageResource income();
	@Source("budget-icon.png")ImageResource budget();
	@Source("commitment-icon.png")ImageResource commitment();
	@Source("expense-icon.png")ImageResource expense();
	@Source("tool-icon.png")ImageResource tool();
	@Source("statistics-icon.png")ImageResource statistics();
	@Source("settings-icon.png")ImageResource settings();
}
