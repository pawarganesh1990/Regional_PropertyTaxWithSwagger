package com.regional.property.solrRepository;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class Book {
	
    @Field
    private String id;

    @Field
    private String name;
    
    @Field
    private String description;
    
     
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

	public void setName(String title) {
		this.name = title;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", description=" + description + ", title=" + name + "]";
	}
}