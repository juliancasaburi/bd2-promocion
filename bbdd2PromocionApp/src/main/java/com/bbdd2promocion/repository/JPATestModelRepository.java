package com.bbdd2promocion.repository;

import java.util.List;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bbdd2promocion.repository.CustomTestModelRepository;

import com.bbdd2promocion.model.TestModel;

import org.springframework.stereotype.Repository;

@Repository
public interface JPATestModelRepository extends JpaRepository<TestModel, UUID>, CustomTestModelRepository {

	/**
	 * Recupera un TestModel cuyo title contiene title.
	 *
	 * @param title.
	 * @return el TestModel cuyo title contiene title.
	 */
	List<TestModel> findByTitleContaining(String title);
}
