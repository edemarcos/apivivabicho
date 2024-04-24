package com.vivabicho.api.repositories;

import com.vivabicho.api.models.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Species, Long> {
}
