package com.lsi.lpidsearch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lsi.entity.Lpid;
import com.lsi.lpidsearch.repository.LpidRepository;
import com.lsi.lpidsearch.service.LpidService;

@Service
public class LpidServiceImpl implements LpidService {

	@Autowired private LpidRepository lpidRepository;
	
	@Override
	@Transactional
	public void createLpidIndex(Lpid lpid) {
		lpidRepository.save(lpid);
	}

	@Override
	@Transactional
	public void deleteLpidIndex(Long id) {
		lpidRepository.delete(id.toString());
	}
	
	@Override
	public List<Lpid> getAll() {
		return (List<Lpid>) lpidRepository.findAll();
	}
	
	@Override
	public List<Lpid> findLpidByAttributeNameAndValue(String attributeName, String attributeValue) {
		return lpidRepository.findLpidByAttributeNamesAndValues(attributeName, attributeValue);
	}

}
