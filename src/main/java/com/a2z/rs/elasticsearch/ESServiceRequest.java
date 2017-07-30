package com.a2z.rs.elasticsearch;

import java.io.Serializable;

public class ESServiceRequest implements Serializable {

	private static final long serialVersionUID = 2471305573113622189L;
	
	private String aliasName;
	private String indexName;
	private String indexType;

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getIndexType() {
		return indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}

}
