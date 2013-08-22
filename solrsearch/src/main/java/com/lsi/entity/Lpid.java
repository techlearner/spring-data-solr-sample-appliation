package com.lsi.entity;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

public final class Lpid extends AbstractEntity {

	@Id
	@Field
	private String id;
	
	@Field
	private String pkey;
	
	@Field
	private String description;
	
	@Field
	private String name;
	
	@Field
	private Date lastChanged;
	
	public Lpid() {
		
	}
	
	public Lpid(String id, String pkey, String description, String name, Date lastChanged) {
		this.id = id;
		this.pkey = pkey;
		this.description = description;
		this.lastChanged = lastChanged;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastChanged() {
		return lastChanged;
	}

	public void setLastChanged(Date lastChanged) {
		this.lastChanged = lastChanged;
	}

	public String getPkey() {
		return pkey;
	}

	public void setPkey(String pkey) {
		this.pkey = pkey;
	}

}
