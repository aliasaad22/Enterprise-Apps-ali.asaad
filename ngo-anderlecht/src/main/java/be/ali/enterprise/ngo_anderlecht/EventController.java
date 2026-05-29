package be.ali.enterprise.ngo_anderlecht;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("events", eventService.findLastTen());
        return "events/index";
    }

    @GetMapping("/new")
    public String newEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locations", eventService.getAllLocations());
        return "events/new";
    }

    @PostMapping("/new")
    public String createEvent(@Valid @ModelAttribute("event") Event event,
                          BindingResult bindingResult,
                          @RequestParam("locationId") Long locationId,
                          Model model) {

    if (bindingResult.hasErrors()) {
        model.addAttribute("locations", eventService.getAllLocations());
        return "events/new";
    }

    // locatie koppelen
    Location loc = eventService.getAllLocations()
            .stream()
            .filter(l -> l.getId().equals(locationId))
            .findFirst()
            .orElse(null);

    event.setLocation(loc);

    eventService.add(event);
    return "redirect:/events";
}


    @GetMapping("/{id}")
    public String details(@PathVariable Long id, Model model) {
        Event event = eventService.findById(id);
        if (event == null) {
            return "redirect:/events";
        }
        model.addAttribute("event", event);
        return "events/details";
    }
}
