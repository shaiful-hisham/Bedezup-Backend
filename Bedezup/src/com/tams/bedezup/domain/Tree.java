package com.tams.bedezup.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Tree implements Serializable {

	private static final long serialVersionUID = 1L;

	private Menu rootNode;
	
	private HashMap <Menu, List <Menu>> tree;
	
	
	public Tree(Menu root) {
		this.rootNode = root;
		tree = new HashMap <Menu, List <Menu>>();
	}
	
	public Menu getRootNode() {
		return rootNode;
	}

	public void setRootNode(Menu rootNode) {
		this.rootNode = rootNode;
	}
	
	public Menu getNodeFromNodeTitleEquals(String title) {
		return searchNode(title, rootNode);
	}
 
	public void addNodeList(Menu parentNode, List <Menu> newNodeList) {
		tree.put(parentNode, newNodeList);
	}
	
	public List <Menu> getNodeListFromNodeEquals(Menu node) {
		List <Menu> menuList = new ArrayList <Menu>();
				
        if (tree.get(node) != null && !tree.get(node).isEmpty()) {
            menuList = tree.get(node);
        }
        
        return menuList;
    }
	
	private Menu searchNode(String title, Menu node) {
		Menu foundMenu = null;
		
		if (node != null) {
			
	        if (node.getTitle().equalsIgnoreCase(title)) {
	           foundMenu = node;
	           return foundMenu;
	        } 
	        else if (getNodeListFromNodeEquals(node) != null && !getNodeListFromNodeEquals(node).isEmpty()) {
	        	
	        	for (Menu menu : getNodeListFromNodeEquals(node)) {
	        		foundMenu = searchNode(title, menu);
	        		
	        		if (foundMenu != null) {
	        			break;
	        		}
	        	}
	        }
	    } 
		
		return foundMenu;
	}
}
