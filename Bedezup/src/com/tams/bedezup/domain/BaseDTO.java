/**
 * Sencha GXT 3.0.0 - Sencha for GWT
 * Copyright(c) 2007-2012, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.tams.bedezup.domain;

import java.io.Serializable;
import java.util.List;

import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.TreeStore.TreeNode;

public class BaseDTO implements BaseDTOInterface, Serializable, TreeStore.TreeNode <BaseDTO> {

  private static final long serialVersionUID = 1L;

  private Long id;
  
  private String name;
  
  
  public BaseDTO() {
  }
  
  public BaseDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getKey() {
    return id;
  }

  public void setKey(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public BaseDTO getData() {
    return this;
  }

  @Override
  public List<? extends TreeNode<BaseDTO>> getChildren() {
    return null;
  }

  @Override
  public String toString() {
    return id + ": " + name;
  }
}
