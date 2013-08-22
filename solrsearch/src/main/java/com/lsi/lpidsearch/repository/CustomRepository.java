package com.lsi.lpidsearch.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;

import com.lsi.entity.AttributeValues;
import com.lsi.entity.Lpid;

public interface CustomRepository {

	List<AttributeValues> findAttributeValuesByCustomImplementaion(String attributeName, String attributeValue, Pageable page);
	
	//public List<AttributeValues> findAttributeValuesByCustomImplementaion(String attributeName, String attributeValue);
	
    //@Query("attributeName:*?0* OR attributeValue:*?0*")
    
}
