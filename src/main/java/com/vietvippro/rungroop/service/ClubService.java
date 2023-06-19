package com.vietvippro.rungroop.service;

import com.vietvippro.rungroop.dto.ClubDto;
import com.vietvippro.rungroop.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(Long clubId);

    void updateClub(ClubDto club);

    void deleteClub(Long clubId);

    List<ClubDto> searchClubs(String query);
}
