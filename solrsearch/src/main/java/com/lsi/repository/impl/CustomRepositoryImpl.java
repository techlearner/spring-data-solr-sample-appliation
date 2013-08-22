package com.lsi.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FilterQuery;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Repository;

import com.lsi.entity.AttributeValues;
import com.lsi.lpidsearch.repository.CustomRepository;

@Repository
public class CustomRepositoryImpl implements CustomRepository {
	
	public static final String TYPE = "type";
	
	public static final String ATTRIBUTE_VALUES = "attributeValues";
	
	public static final String LPID = "lpid";
	
	public static final String ATTRIBUE_NAME_FIELD = "attributeName";
	
	public static final String ATTRIBUE_VALUE_FIELD = "attributeValue";
	

	@Autowired private SolrTemplate solrTemplate;
	
	
	public List<AttributeValues> findAttributeValuesByCustomImplementaion(String attributeName, String attributeValue, Pageable page) {
		
		Criteria criteria = new Criteria(TYPE).contains(ATTRIBUTE_VALUES);
		Criteria filterCriteria =  new Criteria(ATTRIBUE_NAME_FIELD);
		filterCriteria.contains(attributeName)
		.and(new Criteria(ATTRIBUE_VALUE_FIELD).contains(attributeValue));
		//.and(new Criteria(TYPE).contains(ATTRIBUTE_VALUES));
		
		SimpleQuery simpleQuery = new SimpleQuery(criteria);
		simpleQuery.setPageRequest(page);
		//solrTemplate.queryForObject(simpleQuery, Lpid.class);
		
		
		
		
		FilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
		
		simpleQuery.addFilterQuery(filterQuery);
		
		
		Page result = solrTemplate.queryForPage(simpleQuery, AttributeValues.class);
		return result.getContent();
		
		//Filter filter  = new CachingWrapperFilter(new QueryWrapperFilter(new MultiTermQuery()))
		
		
	}
	

}
