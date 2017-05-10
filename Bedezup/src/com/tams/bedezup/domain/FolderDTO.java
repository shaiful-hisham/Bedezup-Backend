/**
 * Sencha GXT 3.0.1 - Sencha for GWT
 * Copyright(c) 2007-2012, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.tams.bedezup.domain;

import java.util.ArrayList;

public class FolderDTO extends BaseDTO implements FolderDTOInterface {

  private static final long serialVersionUID = 1L;

  private ArrayList <BaseDTO> children = new ArrayList <BaseDTO>();

  
  public FolderDTO() {
	  super();
  }

  public FolderDTO(Long id, String name) {
    super(id, name);
  }

  public ArrayList <BaseDTO> getChildren() {
	return children;
  }

  public void setChildren(ArrayList <BaseDTO> children) {
    this.children = children;
  }

  public void addChild(BaseDTO child) {
    getChildren().add(child);
  }

  @Override
  public String toString() {
	  StringBuffer sb = new StringBuffer();
	  
	  if (children != null && !children.isEmpty()) {
			
			for (BaseDTO base : children) {
				sb.append("\n" + base.toString());
			}
	  }  
	  
	  return sb.toString();
  }
}
