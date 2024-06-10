package com.kripton.gestionbudget.services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.Detail_budgetDto;
import com.kripton.gestionbudget.Interface.Detail_budgetInterface;
import com.kripton.gestionbudget.Repository.Detail_budgetRepository;
import com.kripton.gestionbudget.entities.Detail_budget;
@Service
public class Detail_budgetService implements Detail_budgetInterface{
	
	@Autowired
	private Detail_budgetRepository detailBudgetRepository;
	/*@Autowired 
	private Rubrique_budgetRepository rep;*/
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<Detail_budgetDto> getAll() {
		
		List<Detail_budget> detailBudgets = detailBudgetRepository.findAll();
		List<Detail_budgetDto> listeDetailbudget = new ArrayList<Detail_budgetDto>();
		for(Detail_budget detail: detailBudgets) {
			Detail_budgetDto DDto = modelMapper.map(detail,Detail_budgetDto.class);
			listeDetailbudget.add(DDto);
		}
		
		return listeDetailbudget;
	}

	@Override
	public void Delete(Detail_budgetDto detailBudget) {
		//Detail_budget newDetail = detailBudgetRepository.findById(detailBudget.getId_detail_budget()).get();
		detailBudgetRepository.deleteById(detailBudget.getId_detail_budget());;
	}

	@Override
	public Detail_budgetDto Add(Detail_budgetDto detailBudget) {
		Detail_budget newDetail = modelMapper.map(detailBudget, Detail_budget.class);
		//newDetail.setRubrique_budget(rep.findById(detailBudget.getRubrique_budget().getId_rubrique()).get());
		Detail_budget detailEntity = detailBudgetRepository.save(newDetail);
		Detail_budgetDto detailDto = modelMapper.map(detailEntity, Detail_budgetDto.class);
		return detailDto;
	}

	@Override
	public Detail_budgetDto Update(Detail_budgetDto detailBudget) {
		Detail_budget newDetail = modelMapper.map(detailBudget, Detail_budget.class);
		
		Detail_budget detailEntity = detailBudgetRepository.save(newDetail);
		Detail_budgetDto detailDto = modelMapper.map(detailEntity, Detail_budgetDto.class);
		return detailDto;
	}

	@Override
	public Detail_budgetDto getById(Integer id) {
		Detail_budget detailBudget = detailBudgetRepository.findById(id).get();
		Detail_budgetDto detailDto = modelMapper.map(detailBudget, Detail_budgetDto.class);
		return detailDto;
	}

	@Override
	public Detail_budgetDto changeStatus(Detail_budgetDto status) {
		Detail_budget detail = detailBudgetRepository.findById(status.getId_detail_budget()).get();
		if(detail.getStatus() == null) {
			detail.setStatus("green");
		}
		else if(detail.getStatus().equals("green")) {
			detail.setStatus("red");
		}
		else if(detail.getStatus().equals("red")) {
			detail.setStatus("green");
		}
		else {
			detail.setStatus("green");
		}
		
		
		Detail_budget newdetail= detailBudgetRepository.save(detail);
		Detail_budgetDto detailDto = modelMapper.map(newdetail, Detail_budgetDto.class);
		return detailDto;
	}

	@Override
	public Detail_budgetDto sendMessage(Detail_budgetDto detailBudget) {
		
		Detail_budget newDetail = detailBudgetRepository.findById(detailBudget.getId_detail_budget()).get();
		newDetail.setArgument(detailBudget.getArgument());
		Detail_budget detailEntity = detailBudgetRepository.save(newDetail);
		Detail_budgetDto detailDto = modelMapper.map(detailEntity, Detail_budgetDto.class);
		return detailDto;
	}

	
}
