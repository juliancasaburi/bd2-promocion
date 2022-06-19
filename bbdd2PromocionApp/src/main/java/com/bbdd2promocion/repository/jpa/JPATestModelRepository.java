package com.bbdd2promocion.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbdd2promocion.model.TestModel;

import org.springframework.stereotype.Repository;

@Repository
public interface JPATestModelRepository extends JpaRepository<TestModel, String>, CustomTestModelRepository {

	/**
	 * Recupera un TestModel cuyo title contiene title.
	 *
	 * @param title
	 * @return el TestModel cuyo title contiene title.
	 */
	List<TestModel> findByTitleContaining(String title);
}
