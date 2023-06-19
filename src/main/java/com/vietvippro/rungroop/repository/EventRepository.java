package com.vietvippro.rungroop.repository;

import com.vietvippro.rungroop.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
