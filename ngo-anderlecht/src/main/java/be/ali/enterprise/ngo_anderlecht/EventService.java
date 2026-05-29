package be.ali.enterprise.ngo_anderlecht;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private final List<Location> locations = new ArrayList<>();
    private long nextId = 1;

    public EventService() {

        // Locaties
        Location loc1 = new Location(1L, "Gemeenschapscentrum Anderlecht", "Kaai 16, 1070 Anderlecht", 120);
        Location loc2 = new Location(2L, "Buurtcentrum Zuid", "Zuidlaan 45, 1070 Anderlecht", 80);

        locations.add(loc1);
        locations.add(loc2);

        // Events
        Event e1 = new Event();
        e1.setId(nextId++);
        e1.setTitle("Voedselbedeling");
        e1.setOrganization("Anderlecht Community Care");
        e1.setDescription("Wekelijkse voedselbedeling voor gezinnen in nood.");
        e1.setContactEmail("info@anderlechtcare.be");
        e1.setDateTime(LocalDateTime.now().minusDays(1));
        e1.setLocation(loc1);

        Event e2 = new Event();
        e2.setId(nextId++);
        e2.setTitle("Buurtfeest");
        e2.setOrganization("Partnerorganisatie XYZ");
        e2.setDescription("Een gezellig buurtfeest met muziek en activiteiten.");
        e2.setContactEmail("contact@partnerxyz.be");
        e2.setDateTime(LocalDateTime.now().minusDays(3));
        e2.setLocation(loc2);

        events.add(e1);
        events.add(e2);
    }

    public List<Event> findLastTen() {
        return events.stream()
                .sorted(Comparator.comparing(Event::getDateTime).reversed())
                .limit(10)
                .toList();
    }

    public Event findById(Long id) {
        return events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void add(Event event) {
        event.setId(nextId++);
        events.add(event);
    }

    public List<Location> getAllLocations() {
        return locations;
    }
}
