package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAAccidentRepository extends JpaRepository<Accident, Long>, CustomTestModelRepository {


}
