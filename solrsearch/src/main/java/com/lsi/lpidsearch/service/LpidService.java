package com.lsi.lpidsearch.service;

import java.util.List;

import com.lsi.entity.Lpid;

public interface LpidService {
	
	void createLpidIndex(Lpid lpid);
	
	void deleteLpidIndex(Long id);
	
	List<Lpid> getAll();
	
	List<Lpid> findLpidByAttributeNameAndValue(String attributeName, String attributeValue);
}
