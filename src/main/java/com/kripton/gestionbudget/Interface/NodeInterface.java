package com.kripton.gestionbudget.Interface;

import java.util.List;

import com.kripton.gestionbudget.DTO.NodeDto;

public interface NodeInterface {
	
	public List<NodeDto> getAll();
	public NodeDto Add(NodeDto node);
	public NodeDto Update(NodeDto node);
	public void delete(NodeDto node);

}
