package com.bbdd2promocion.model;

import javax.persistence.*;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "TestModel")
@Entity
@Table(name = "test_models")
public class TestModel {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@BsonIgnore
	private Long id;

	@MongoId
	@Transient
	private String mongoId;

	@Field(name = "csvId")
	@Column(name = "csv_id")
	private String csvId;

	@Field(name = "title")
	@Column(name = "title")
	private String title;

	@Field(name = "description")
	@Column(name = "description")
	private String description;

	public TestModel() {

	}

	public TestModel(String csvId, String title, String description) {
		this.csvId = csvId;
		this.title = title;
		this.description = description;
	}

	public void setCsvId(String csvId) {
		this.csvId = csvId;
	}

	public String getCsvId() {
		return csvId;
	}

	public Long getId() {
		return id;
	}

	public String getMongoId() {
		return mongoId;
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
		return "TestModel{" +
				"csvId='" + csvId + '\'' +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
