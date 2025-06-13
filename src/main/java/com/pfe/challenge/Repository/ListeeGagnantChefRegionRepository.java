package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ListeeGagnantChefRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeGagnantChefRegionRepository extends JpaRepository<ListeeGagnantChefRegion, Long> {}
