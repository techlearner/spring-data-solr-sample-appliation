package com.lsi.lpidsearch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lsi.entity.AttributeValues;
import com.lsi.lpidsearch.repository.AttributeValuesRespository;
import com.lsi.lpidsearch.repository.CustomRepository;
import com.lsi.lpidsearch.service.AttributeValuesService;

@Service
public class AttributeValuesServiceImpl implements AttributeValuesService {

	@Autowired private AttributeValuesRespository attributeValuesRepository;
	
	@Autowired private CustomRepository customRepository;

	@Override
	public void indexAttributeValues(AttributeValues av) {
		attributeValuesRepository.save(av);
	}

	@Override
	public void deleteAttributeValueIndex(String id) {
		attributeValuesRepository.delete(id);
	}

	@Override
	public List<AttributeValues> fetchAll() {
		List<AttributeValues> list = (List<AttributeValues>) attributeValuesRepository.findAll();
		return list;
	}

	@Override
	public List<AttributeValues> findAttributeValuesByCustomImplementaion(String attrName, String attrValue,
			Pageable page) {
		List<AttributeValues> list = customRepository.findAttributeValuesByCustomImplementaion(attrName, attrValue, page);
		return list;
	}
	
	/*@Override
	public List<AttributeValues> findAttributeValuesByCustomImplementaion(String attrName, String attrValue) {
		List<AttributeValues> list = customRepository.findAttributeValuesByCustomImplementaion(attrName, attrValue);
		return list;
	}
*/	
	
}
