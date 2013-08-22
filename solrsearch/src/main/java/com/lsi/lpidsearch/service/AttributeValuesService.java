package com.lsi.lpidsearch.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lsi.entity.AttributeValues;

public interface AttributeValuesService {

	void indexAttributeValues(AttributeValues av);
	
	void deleteAttributeValueIndex(String id);
	
	List<AttributeValues> fetchAll();
	
	List<AttributeValues> findAttributeValuesByCustomImplementaion(String attrName, String attrValue, Pageable page);
	
	//List<AttributeValues> findAttributeValuesByCustomImplementaion(String attrName, String attrValue);

}
