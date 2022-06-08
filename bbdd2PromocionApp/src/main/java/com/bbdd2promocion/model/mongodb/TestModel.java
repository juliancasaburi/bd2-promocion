package com.bbdd2promocion.model.mongodb;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "TestModel")
public class TestModel {

	@Id
	private String id;

	@Field(name = "title")
	private String title;

	@Field(name = "description")
	private String description;

	public TestModel() {

	}

	public TestModel(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TestModel [id=" + id + ", title=" + title + ", desc=" + description + "]";
	}

}
