package com.kripton.gestionbudget.services;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.NodeDto;
import com.kripton.gestionbudget.Interface.NodeInterface;
import com.kripton.gestionbudget.Repository.NodeRepository;
import com.kripton.gestionbudget.entities.Node;

@Service
public class NodeService implements NodeInterface {

	@Autowired
	private NodeRepository nodeRepository;
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public List<NodeDto> getAll() {
		
		List<Node> nodes = nodeRepository.findAll();
		List<NodeDto> listeNodes = new ArrayList<NodeDto>();
		for(Node node: nodes) {
			NodeDto NDto = modelMapper.map(node,NodeDto.class);
			listeNodes.add(NDto);
		}
		
		return listeNodes;
	}

	@Override
	public NodeDto Add(NodeDto node) {
		Node nodeEntity = modelMapper.map(node, Node.class);
		Node newNode = nodeRepository.save(nodeEntity);
		NodeDto nodeDto = modelMapper.map(newNode, NodeDto.class);
		return nodeDto;
	}

	@Override
	public NodeDto Update(NodeDto node) {
		Node nodeEntity = modelMapper.map(node, Node.class);
		Node newNode = nodeRepository.save(nodeEntity);
		NodeDto nodeDto = modelMapper.map(newNode, NodeDto.class);
		return nodeDto;
	}

	@Override
	public void delete(NodeDto node) {
		Node nodeEntity = modelMapper.map(node, Node.class);
		nodeRepository.delete(nodeEntity);
		
	}

}
