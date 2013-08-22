/**
 * 
 */
package com.lsi.lpidsearch.repository;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.lsi.entity.Lpid;

/**
 * @author senthils
 *
 */

@Repository
public interface LpidRepository extends SolrCrudRepository<Lpid, String> {

	@Query("{!join from=lpidId to=pkey}attributeName:*?0* AND attributeValue:*?1*")
	List<Lpid> findLpidByAttributeNamesAndValues(String attributeName, String attributeValue);

}
