package com.lsi.entity;

import java.util.Date;
import java.util.Map;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

public class AttributeValues extends AbstractEntity {
	
	@Field
	private Long lpidId;
	
	@Id
	@Field
	private String id;
	
	@Field
	private Long sellerId;
	
	@Field
	private Date effectiveFrom;
	
	@Field
	private Date effectiveTo;
	
	//private Long sellerId;
	private Map<String, Object> attributeValues;
	
	@Field
	private String attributeName;
	
	@Field
	private Object attributeValue;
	
	/*public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
*/	public Map<String, Object> getAttributeValues() {
		return attributeValues;
	}
	public void setAttributeValues(Map<String, Object> attributeValues) {
		this.attributeValues = attributeValues;
	}
	public Long getLpidId() {
		return lpidId;
	}
	public void setLpidId(Long lpidId) {
		this.lpidId = lpidId;
	}
	public String getId() {
		return id;
	}
	public void setId(String sellerId) {
		this.id = sellerId;
	}
	public Date getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public Date getEffectiveTo() {
		return effectiveTo;
	}
	public void setEffectiveTo(Date effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public Object getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(Object attributeValue) {
		this.attributeValue = attributeValue;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
}
