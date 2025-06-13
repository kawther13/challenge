package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.Commercant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercantRepository extends JpaRepository<Commercant, Long> {}