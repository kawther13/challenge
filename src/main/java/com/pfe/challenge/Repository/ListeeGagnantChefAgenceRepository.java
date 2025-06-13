package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ListeeGagnantChefAgence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeGagnantChefAgenceRepository extends JpaRepository<ListeeGagnantChefAgence, Long> {}
