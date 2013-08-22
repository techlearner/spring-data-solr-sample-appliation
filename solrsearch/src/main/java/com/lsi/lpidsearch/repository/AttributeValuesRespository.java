package com.lsi.lpidsearch.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.lsi.entity.AttributeValues;

@Repository
public interface AttributeValuesRespository extends SolrCrudRepository<AttributeValues, String> {

}
