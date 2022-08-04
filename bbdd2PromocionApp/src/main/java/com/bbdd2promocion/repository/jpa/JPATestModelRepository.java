package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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
