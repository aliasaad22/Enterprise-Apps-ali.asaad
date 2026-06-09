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
        Event e3 = new Event();
        e3.setId(nextId++);
        e3.setTitle("Kledinginzameling");
        e3.setOrganization("Anderlecht Solidarity");
        e3.setDescription("Inzameling van winterkledij voor kwetsbare gezinnen.");
        e3.setContactEmail("help@solidarity.be");
        e3.setDateTime(LocalDateTime.now().minusDays(2));
        e3.setLocation(loc1);

        Event e4 = new Event();
        e4.setId(nextId++);
        e4.setTitle("Jongeren Workshop");
        e4.setOrganization("Youth Support NGO");
        e4.setDescription("Workshop rond digitale vaardigheden voor jongeren.");
        e4.setContactEmail("info@youthsupport.be");
        e4.setDateTime(LocalDateTime.now().minusDays(4));
        e4.setLocation(loc2);

        Event e5 = new Event();
        e5.setId(nextId++);
        e5.setTitle("Gezondheidscheck Dag");
        e5.setOrganization("Community Health Brussels");
        e5.setDescription("Gratis medische controles voor buurtbewoners.");
        e5.setContactEmail("contact@healthbrussels.be");
        e5.setDateTime(LocalDateTime.now().minusDays(5));
        e5.setLocation(loc1);

        Event e6 = new Event();
        e6.setId(nextId++);
        e6.setTitle("Senioren Namiddag");
        e6.setOrganization("Anderlecht Care Group");
        e6.setDescription("Sociale activiteit voor senioren met koffie en spelletjes.");
        e6.setContactEmail("senioren@caregroup.be");
        e6.setDateTime(LocalDateTime.now().minusDays(6));
        e6.setLocation(loc2);

        Event e7 = new Event();
        e7.setId(nextId++);
        e7.setTitle("Milieu Actie Dag");
        e7.setOrganization("Green Brussels Initiative");
        e7.setDescription("Opkuis van parken en straten in Anderlecht.");
        e7.setContactEmail("green@initiative.be");
        e7.setDateTime(LocalDateTime.now().minusDays(7));
        e7.setLocation(loc1);

        Event e8 = new Event();
        e8.setId(nextId++);
        e8.setTitle("Job Coaching Sessies");
        e8.setOrganization("Employment Support NGO");
        e8.setDescription("Begeleiding voor werkzoekenden bij sollicitaties.");
        e8.setContactEmail("jobs@supportngo.be");
        e8.setDateTime(LocalDateTime.now().minusDays(8));
        e8.setLocation(loc2);

        Event e9 = new Event();
        e9.setId(nextId++);
        e9.setTitle("Taalcursus Nederlands");
        e9.setOrganization("Integration Brussels");
        e9.setDescription("Gratis taallessen voor nieuwkomers.");
        e9.setContactEmail("info@integration.be");
        e9.setDateTime(LocalDateTime.now().minusDays(9));
        e9.setLocation(loc1);

        Event e10 = new Event();
        e10.setId(nextId++);
        e10.setTitle("Sport & Jeugd Dag");
        e10.setOrganization("Youth Sports Anderlecht");
        e10.setDescription("Sportactiviteiten voor kinderen en jongeren.");
        e10.setContactEmail("sport@youth.be");
        e10.setDateTime(LocalDateTime.now().minusDays(10));
        e10.setLocation(loc2);

        Event e11 = new Event();
        e11.setId(nextId++);
        e11.setTitle("Digitale Inclusie Workshop");
        e11.setOrganization("Tech for All");
        e11.setDescription("Basis computer- en internetvaardigheden voor iedereen.");
        e11.setContactEmail("info@techforall.be");
        e11.setDateTime(LocalDateTime.now().minusDays(11));
        e11.setLocation(loc1);

        Event e12 = new Event();
        e12.setId(nextId++);
        e12.setTitle("Voedselpakketten Distributie");
        e12.setOrganization("Anderlecht Food Aid");
        e12.setDescription("Verdeling van voedselpakketten aan gezinnen in nood.");
        e12.setContactEmail("help@foodaid.be");
        e12.setDateTime(LocalDateTime.now().minusDays(12));
        e12.setLocation(loc2);


        events.add(e1);
        events.add(e2);
        
        events.add(e3);
        events.add(e4);
        events.add(e5);
        events.add(e6);
        events.add(e7);
        events.add(e8);
        events.add(e9);
        events.add(e10);
        events.add(e11);
        events.add(e12);
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
