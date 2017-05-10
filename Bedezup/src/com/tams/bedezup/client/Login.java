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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.dom.Mask;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.tams.bedezup.client.helper.DialogBoxHelper;
import com.tams.bedezup.client.icon.Icon;
import com.tams.bedezup.shared.UserState;

public class Login implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		LoginDialog d = new LoginDialog();
	    d.show();
	}
	
	class LoginDialog extends Dialog {
		
		private TextField userName;
		  
		private PasswordField password;
		
		private TextButton forgetPasswordButton;
		
		private static final String FORGET_PASSWORD = "FORGOT PASSWORD";
		
		
		public LoginDialog() {
			this.setPixelSize(450, 400);  
			this.setClosable(false);
			this.setCollapsible(false);
			this.setHeadingText("Login - BedeZup Manager");
			
			VerticalLayoutContainer p = new VerticalLayoutContainer();
		    	    
		    // Logo
		    CenterLayoutContainer logoContainer = new CenterLayoutContainer();
		    ContentPanel logoPanel = new ContentPanel();
		    logoPanel.setHeaderVisible(false);
		    logoPanel.setBodyStyleName("logo");
		    logoPanel.setSize("150px", "150px");
		    logoContainer.add(logoPanel);
		    p.add(logoContainer, new VerticalLayoutData(1, -1, new Margins(60, 0, 30, 0)));
		    
		    /*StringBuffer sb = new StringBuffer();
			sb.append("<br/><br/><center>Access to this location is restricted to authorized users only");
			sb.append(" and any unauthorized access to this area is prohibited.</center><br/><br/>");
			
			HTML html = new HTML();
			html.setHTML(sb.toString());
			html.setHeight("20px");
			html.setStyleName("head-login");
			p.add(html);*/
			
		    userName = new TextField();
		    userName.setAllowBlank(false);
		    userName.setToolTip("Enter your username.");		    
		    
		    password = new PasswordField();
		    password.setAllowBlank(false);
		    password.setToolTip("Enter your password.");
		    password.addDomHandler(new KeyDownHandler() {
		    	
			    @Override public void onKeyDown(KeyDownEvent event) {
			        if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
			            doLogin();			        	
			        }
			    }
			}, KeyDownEvent.getType());	
		    
		    forgetPasswordButton = new TextButton("Forget Password?");
		    forgetPasswordButton.setIcon(Icon.ICONS.forgetPassword());
		    forgetPasswordButton.addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					Dialog dialog = new Dialog();
					dialog.setHeaderVisible(true);
					dialog.setHeadingText(FORGET_PASSWORD);
					dialog.setBorders(false);
					dialog.setModal(true);
					dialog.setWidth(430);
					dialog.setHeight(210);
					dialog.setResizable(false);
					
					/*ForgetPasswordPanel forgetPasswordPanel = new ForgetPasswordPanel(dialog);
					forgetPasswordPanel.setHeaderVisible(false);
					forgetPasswordPanel.setUi();
					
					VerticalLayoutContainer vlc = new VerticalLayoutContainer();
					vlc.setBorders(false);
					vlc.add(forgetPasswordPanel, new VerticalLayoutData(-1, 1));*/
					
					//dialog.add(vlc);
					dialog.setPredefinedButtons();
					dialog.show();
				}
		    });    
		    
		    HorizontalPanel buttonPanel = new HorizontalPanel();
		    buttonPanel.setSpacing(5);
		    buttonPanel.add(forgetPasswordButton);
		    
		    Label copyrightLabel1 = new Label("Tams Idea Sdn Bhd");
		    Label copyrightLabel2 = new Label("Copyright @ 2017. All Rights Reserved.");
		    copyrightLabel1.setStyleName("copyright");
		    copyrightLabel2.setStyleName("copyright");
		    
		    p.add(new FieldLabel(userName, "Username"), new VerticalLayoutData(1, -1, new Margins(45, 0, 5, 0)));
		    p.add(new FieldLabel(password, "Password"), new VerticalLayoutData(1, -1));
		    
		    p.add(buttonPanel, new VerticalLayoutData(1, -1, new Margins(0, 0, 0, 100)));
		    p.add(copyrightLabel1, new VerticalLayoutData(1, -1, new Margins(0, 0, 0, 105)));
		    p.add(copyrightLabel2, new VerticalLayoutData(1, -1, new Margins(0, 0, 10, 105)));
		    
		    ContentPanel cp = new ContentPanel();
			cp.setWidth("100%");
			cp.setHeight(90);
			
			cp.setBodyStyle("background: none; padding: 20px");
			cp.setHeaderVisible(false);
			cp.add(p);
					    
		    this.add(cp);
		    this.setFocusWidget(userName);
			this.show();
		}
		
		@Override
		protected void createButtons() {
			TextButton btnLogin = new TextButton("Login");
			btnLogin.setWidth(80);
			btnLogin.setIcon(Icon.ICONS.login());
			btnLogin.addSelectHandler(new SelectHandler() {
				
				@Override
				public void onSelect(SelectEvent event) {
					if (userName.getText() == null || password.getText() == null || userName.getText().equals("") || password.getText().equals("")) {
						Dialog simpleDialog = DialogBoxHelper.createSimpleDialogBox("Notification", "Please enter username and password.");
						simpleDialog.setWidth(300);
						simpleDialog.setModal(true);
						simpleDialog.show();
					}
					else {
						doLogin();
					}
				}		    	
		    });
			
			TextButton btnReset = new TextButton("Reset");
			btnReset.setWidth(80);
			btnReset.setIcon(Icon.ICONS.reset());
		    btnReset.addSelectHandler(new SelectHandler() {
				@Override
				public void onSelect(SelectEvent event) {
					userName.setText("");
					password.setText("");
					LoginDialog.this.setFocusWidget(userName);
				}		    	
		    });
		    
		    HorizontalPanel buttonPanel = new HorizontalPanel();
		    buttonPanel.setSpacing(10);
		    buttonPanel.add(btnLogin);
		    buttonPanel.add(btnReset);
		    
		    this.getButtonBar().add(buttonPanel);
		}
		
		private void doLogin() {
			AsyncCallback<UserState> callback = new AsyncCallback <UserState>() {

				@Override
				public void onFailure(Throwable arg0) {
					Mask.unmask(getElement());
					
					Dialog simpleDialog = DialogBoxHelper.createSimpleDialogBox("Notification", "Login failed. Please check your username and password.");
					simpleDialog.setWidth(300);
					simpleDialog.setModal(true);
					simpleDialog.show();
				}

				@Override
				public void onSuccess(UserState state) {
					userName.setText("");
					password.setText("");
					Mask.unmask(getElement());
					//Log.debug("Login success.");
					
					if (state != null) {
						Window.open(com.google.gwt.core.client.GWT.getHostPageBaseURL() + state.getStateObject(UserState.REDIRECT_STRING), "_self", "");
					}
					else {
						Dialog simpleDialog = DialogBoxHelper.createSimpleDialogBox("Notification", "Login failed. Please check your username and password.");
						simpleDialog.setWidth(300);
						simpleDialog.setModal(true);
						simpleDialog.show();
					}
				}
			};
		
			String userNameStr = userName.getCurrentValue();
			String passwordStr = password.getCurrentValue();
			
			//Log.debug("Username: " + userNameStr);
			//Log.debug("Password: " + passwordStr);
			
			Mask.mask(getElement(), "Authenticating user...");
			SecurityService.Util.getInstance().login(userNameStr, passwordStr, callback);
		}
	}
}
