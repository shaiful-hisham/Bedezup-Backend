package com.tams.bedezup.domain;

import java.util.ArrayList;

public interface FolderDTOInterface {

	public ArrayList <BaseDTO> getChildren();

	public void setChildren(ArrayList <BaseDTO> children);

	public void addChild(BaseDTO child);
}
