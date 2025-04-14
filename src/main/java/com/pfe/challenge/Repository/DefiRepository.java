package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.Defi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefiRepository extends JpaRepository<Defi, Integer> {


}
