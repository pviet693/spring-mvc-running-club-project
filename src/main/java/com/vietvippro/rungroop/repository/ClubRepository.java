package com.vietvippro.rungroop.repository;

import com.vietvippro.rungroop.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String title);
    @Query("select c from Club c where c.title like concat('%', :query, '%')")
    List<Club> searchClubs(String query);
}
