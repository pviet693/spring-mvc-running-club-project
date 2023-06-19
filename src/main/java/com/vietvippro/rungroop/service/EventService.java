package com.vietvippro.rungroop.service;

import com.vietvippro.rungroop.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

    List<EventDto> findAllEvent();

    EventDto findEventById(Long eventId);

    void updateEvent(EventDto eventDto);

    EventDto findByEventId(Long eventId);

    void deleteEvent(Long eventId);
}
