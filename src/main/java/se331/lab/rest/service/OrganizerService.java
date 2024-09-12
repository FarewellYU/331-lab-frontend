package se331.lab.rest.service;


import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizerSize();
    List<Organizer> getAllOrganizers(Integer pageSizeOrganizer, Integer pageorganizer);

    Organizer getOrganizer(Long organizerId);
}