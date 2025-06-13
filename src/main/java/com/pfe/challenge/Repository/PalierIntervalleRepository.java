package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.PalierIntervalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalierIntervalleRepository extends JpaRepository<PalierIntervalle, Long> {
    List<PalierIntervalle> findByRolePaliersId(Long rolePalierId);
}

