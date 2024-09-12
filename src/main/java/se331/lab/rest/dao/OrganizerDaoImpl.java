package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository

public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(101L)
                .name("Emily Thompson")
                .organizationName("Future Leaders Foundation")
                .address("123 Elm Street, New York").build());
        organizerList.add(Organizer.builder()
                .id(202L)
                .name("Michael Johnson")
                .organizationName("Global Youth Initiative")
                .address("456 Maple Avenue, San Francisco").build());
        organizerList.add(Organizer.builder()
                .id(303L)
                .name("Sarah Lee")
                .organizationName("World Wildlife Fund")
                .address("789 Oak Lane, Chicago").build());
        organizerList.add(Organizer.builder()
                .id(404L)
                .name("David Smith")
                .organizationName("Clean Earth Project")
                .address("101 Pine Road, Seattle").build());
        organizerList.add(Organizer.builder()
                .id(505L)
                .name("Laura Martinez")
                .organizationName("Urban Green Society")
                .address("202 Birch Street, Boston").build());
        organizerList.add(Organizer.builder()
                .id(606L)
                .name("James White")
                .organizationName("Save the Children Fund")
                .address("303 Cedar Drive, Los Angeles").build());
    }
        @Override
    public Organizer getOrganizer(Long organizerId) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(organizerId)).findFirst().orElse(null);
    }

    @Override
    public List<Organizer> getAllOrganizers(Integer pageSizeOrganizer, Integer pageorganizer) {
        pageSizeOrganizer = pageSizeOrganizer==null? organizerList.size(): pageSizeOrganizer;
        pageorganizer = pageorganizer  == null? 1: pageorganizer ;
        int firstIndex = (pageorganizer  - 1) * pageSizeOrganizer;
        return organizerList.subList(firstIndex,firstIndex+pageSizeOrganizer);
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }
}