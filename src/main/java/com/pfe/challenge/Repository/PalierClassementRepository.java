package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.PalierClassement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalierClassementRepository extends JpaRepository<PalierClassement, Long> {
    @Query("SELECT p FROM PalierClassement p WHERE p.rolePaliers.id = :rolePalierId")
    List<PalierClassement> findByRolePaliersId(@Param("rolePalierId") Long rolePalierId);

}
