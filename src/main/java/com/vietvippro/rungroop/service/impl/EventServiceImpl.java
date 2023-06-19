package com.vietvippro.rungroop.service.impl;

import com.vietvippro.rungroop.dto.EventDto;
import com.vietvippro.rungroop.models.Club;
import com.vietvippro.rungroop.models.Event;
import com.vietvippro.rungroop.repository.ClubRepository;
import com.vietvippro.rungroop.repository.EventRepository;
import com.vietvippro.rungroop.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.vietvippro.rungroop.mapper.EventMapper.mapToEvent;
import static com.vietvippro.rungroop.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(
            EventRepository eventRepository,
            ClubRepository clubRepository
    ) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);

        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvent() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findEventById(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
