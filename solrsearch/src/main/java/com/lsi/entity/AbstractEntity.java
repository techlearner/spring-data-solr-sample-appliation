package com.lsi.entity;

import org.apache.solr.client.solrj.beans.Field;

public class AbstractEntity {

	@Field
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
