
package com.imc.imc_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imc.imc_api.model.ImcCalculation;

@Repository
public interface ImcRepository extends JpaRepository<ImcCalculation, Long> {
    List<ImcCalculation> findAllByOrderByDateDesc();
}



