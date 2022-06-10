package com.bbdd2promocion.model.postgresql;

import javax.persistence.*;

@Entity
@Table(name = "test_models")
public class TestModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	public TestModel() {

	}

	public TestModel(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Long getId() {
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
