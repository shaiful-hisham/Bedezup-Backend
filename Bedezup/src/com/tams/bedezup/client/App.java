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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.Mask;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.ExpandMode;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.CloseEvent;
import com.sencha.gxt.widget.core.client.event.CloseEvent.CloseHandler;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.tams.bedezup.client.icon.Icon;
import com.tams.bedezup.shared.UserState;


public class App implements EntryPoint {
	
	private Viewport viewport;
	
	private BorderLayoutContainer mainLayout;
	
	private TabPanel tab;
	
	
	public void onModuleLoad() {
		viewport = new Viewport();
		mainLayout = new BorderLayoutContainer();
		tab = new TabPanel();
		
		createNorthView();
		createWestView();
		createCenterView();
		
		viewport.add(mainLayout);
		RootPanel.get("main").add(viewport);
	}
	
	private void createNorthView() {
		StringBuffer sb = new StringBuffer();

		sb.append("<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"2\" bgcolor=\"#3892d3\" height=\"50px\">");
		sb.append("<tr>");
		sb.append("<td width=\"8%\" align=\"left\" valign=\"top\"><img src=\"images/header-logo.png\" width=\"77px\" height=\"50px\" /></td>");
		sb.append("<td width=\"92%\" align=\"left\" valign=\"top\">");
		sb.append("<div id=\"demo-title\">BedeZup Manager</div><br/>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");

		HTML html = new HTML();
		html.addStyleName("head-title");
		html.setHTML(sb.toString());

		BorderLayoutData northLayoutData = new BorderLayoutData(50);
		northLayoutData.setMargins(new Margins(5));
		northLayoutData.setCollapsible(false);
		northLayoutData.setSplit(true);

		mainLayout.setNorthWidget(html, northLayoutData);
		viewport.forceLayout();
	}
	
	private void createWestView() {
		AccordionLayoutContainer accordion = new AccordionLayoutContainer();
		accordion.setExpandMode(ExpandMode.SINGLE_FILL);
		
		ContentPanel jobHolderPanel = createJobHolderPanel();
		ContentPanel messageHolderPanel = createMessageHolderPanel();
		ContentPanel managementHolderPanel = createManagementHolderPanel();
		ContentPanel statisticHolderPanel = createStatisticHolderPanel();
		
		accordion.add(jobHolderPanel);
		accordion.add(messageHolderPanel);
		accordion.add(managementHolderPanel);
		accordion.add(statisticHolderPanel);
		
		TextButton logoutButton = new TextButton("Logout", Icon.ICONS.logout());
		logoutButton.setWidth(80);
		logoutButton.setBorders(false);
		logoutButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ConfirmMessageBox cmb = new ConfirmMessageBox("CONFIRMATION REQUIRED", "Confirm to logout?");
				cmb.addDialogHideHandler(new DialogHideHandler() {

					@Override
					public void onDialogHide(DialogHideEvent event) {
						switch (event.getHideButton()) {
							case YES:
								doLogout();
								break;
								
							case NO:
								break;
								
							default:
								break;
						}	
					}
				});
				
				cmb.setWidth(300);
				cmb.show();
			}
		});
		
		ContentPanel leftPanel = new ContentPanel();
		leftPanel.setBorders(false);
		leftPanel.setHeaderVisible(false);
		leftPanel.setButtonAlign(BoxLayoutPack.START);
		leftPanel.getButtonBar().setLayoutData(new MarginData(2, 2, 2, 2));
		leftPanel.getButtonBar().add(logoutButton);
		leftPanel.add(accordion, new MarginData(new Margins(5)));
		
		ContentPanel westPanel = new ContentPanel();
		westPanel.setHeadingText("Navigation");
		westPanel.add(leftPanel);

		BorderLayoutData westLayoutData = new BorderLayoutData(300);
		westLayoutData.setCollapsible(true);
		westLayoutData.setSplit(true);
		westLayoutData.setCollapseMini(true);
		westLayoutData.setMargins(new Margins(5, 5, 5, 5));

		mainLayout.setWestWidget(westPanel, westLayoutData);
	}

	private void createCenterView() {
		ContentPanel centerPanel = new ContentPanel();
		centerPanel.setHeadingText("Workspace");
		centerPanel.setHeight("100%");
		centerPanel.setBorders(false);

		MarginData centerMargin = new MarginData(5, 5, 5, 5);

		tab.setBorders(false);
		tab.setBodyBorder(false);
		tab.setVisible(false);
		tab.addCloseHandler(new CloseHandler<Widget>() {

			@Override
			public void onClose(CloseEvent<Widget> event) {
				if (tab.getWidgetCount() < 1)
					tab.setVisible(false);
			}
		});

		centerPanel.add(tab);
		mainLayout.add(centerPanel, centerMargin);
	}
	
	private void doLogout() {
		AsyncCallback <UserState> callback = new AsyncCallback <UserState>() {

			@Override
			public void onFailure(Throwable arg0) {
				Mask.unmask(mainLayout.getElement());
				redirectLoginPage();
			}

			@Override
			public void onSuccess(UserState state) {
				Mask.unmask(mainLayout.getElement());
				redirectLoginPage();
			}
		};
		Mask.mask(mainLayout.getElement(), "Logging out.");
		SecurityService.Util.getInstance().logout(callback);
	}
	
	private void redirectLoginPage() {
		com.google.gwt.user.client.Window.open(com.google.gwt.core.client.GWT.getHostPageBaseURL() + "Login.html", "_self", "");	
	}
	
	private ContentPanel createJobHolderPanel() {
		AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
		ContentPanel jobHolderPanel = new ContentPanel(appearance);
		jobHolderPanel.setHeaderVisible(true);
		jobHolderPanel.getHeader().setIcon(Icon.ICONS.app());
		jobHolderPanel.setHeadingHtml("Job");
		jobHolderPanel.setAnimCollapse(true);
		jobHolderPanel.setCollapsible(true);
		jobHolderPanel.setExpanded(true);
		
		return jobHolderPanel;
	}
	
	private ContentPanel createMessageHolderPanel() {
		AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
		ContentPanel messageHolderPanel = new ContentPanel(appearance);
		messageHolderPanel.setHeaderVisible(true);
		messageHolderPanel.getHeader().setIcon(Icon.ICONS.budget());
		messageHolderPanel.setHeadingHtml("Message");
		messageHolderPanel.setAnimCollapse(true);
		messageHolderPanel.setCollapsible(true);
		messageHolderPanel.setExpanded(true);
		
		return messageHolderPanel;
	}
	
	private ContentPanel createManagementHolderPanel() {
		AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
		ContentPanel managementHolderPanel = new ContentPanel(appearance);
		managementHolderPanel.setHeaderVisible(true);
		managementHolderPanel.getHeader().setIcon(Icon.ICONS.settings());
		managementHolderPanel.setHeadingHtml("Management");
		managementHolderPanel.setAnimCollapse(true);
		managementHolderPanel.setCollapsible(true);
		managementHolderPanel.setExpanded(true);
		
		return managementHolderPanel;
	}
	
	private ContentPanel createStatisticHolderPanel() {
		AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
		ContentPanel statisticHolderPanel = new ContentPanel(appearance);
		statisticHolderPanel.setHeaderVisible(true);
		statisticHolderPanel.getHeader().setIcon(Icon.ICONS.statistics());
		statisticHolderPanel.setHeadingHtml("Statistic");
		statisticHolderPanel.setAnimCollapse(true);
		statisticHolderPanel.setCollapsible(true);
		statisticHolderPanel.setExpanded(true);
		
		return statisticHolderPanel;
	}
}
