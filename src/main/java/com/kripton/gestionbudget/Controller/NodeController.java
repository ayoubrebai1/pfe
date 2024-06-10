package com.kripton.gestionbudget.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kripton.gestionbudget.DTO.NodeDto;
import com.kripton.gestionbudget.services.NodeService;
@RestController
@RequestMapping("/node")
public class NodeController {
	@Autowired
	private NodeService nodeService;  
	@GetMapping
	public ResponseEntity<List<NodeDto>> getAllNode(){
		List<NodeDto> nodesDto = nodeService.getAll();
		return new ResponseEntity<List<NodeDto>>(nodesDto,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<NodeDto> addNode(@RequestBody NodeDto node){
		
		NodeDto nodeDto = nodeService.Add(node);
		return new ResponseEntity<NodeDto>(nodeDto,HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<NodeDto> updateNode(@RequestBody NodeDto node){
		NodeDto nodeDto = nodeService.Update(node);
		return new ResponseEntity<NodeDto>(nodeDto,HttpStatus.ACCEPTED);
	}
	@DeleteMapping
	public ResponseEntity<Object> deleteNode(@RequestBody NodeDto node){
		nodeService.delete(node);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
