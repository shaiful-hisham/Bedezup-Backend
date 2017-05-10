package com.tams.bedezup.client.helper;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;

public final class DialogBoxHelper {

	public static Dialog createSimpleDialogBox(String title, String message) {
		Dialog simpleDialog = new Dialog();
		simpleDialog.setBodyStyle("background: none;");
		simpleDialog.setHeaderVisible(true);
		simpleDialog.setHeadingText(title);
		simpleDialog.setPredefinedButtons(PredefinedButton.OK);
		Label label = new Label(message);
		simpleDialog.add(label);
		simpleDialog.setHideOnButtonClick(true);
		
		return simpleDialog;
	}
	
	public static Dialog createSimpleHtmlDialogBox(String title, String message) {
		Dialog simpleDialog = new Dialog();
		HTML messageLabel = new HTML();
		messageLabel.setHTML(message);
		
		simpleDialog.setBodyStyle("background: none;");
		simpleDialog.setHeaderVisible(true);
		simpleDialog.setHeadingText(title);
		simpleDialog.setPredefinedButtons(PredefinedButton.OK);
		simpleDialog.add(messageLabel);
		simpleDialog.setHideOnButtonClick(true);
		
		return simpleDialog;
	}
}
