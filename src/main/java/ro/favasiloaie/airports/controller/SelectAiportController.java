package ro.favasiloaie.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.repository.AirportRepository;

import java.math.BigDecimal;
import java.util.Optional;
@Controller
public class SelectAiportController {
    @Autowired
private AirportRepository airportRepository;

    @GetMapping("/page/select/id/{id}")
    public ModelAndView displayAirport(@PathVariable("id") final Long id) {
        final ModelAndView mav = new ModelAndView("selected");
        final Optional<Airport> airport = airportRepository.findById(id);
        final String aiportName = airport.map(a -> a.getName()).orElse("Without name!");
        final String airportCountry = airport.map(a -> a.getCountry()).orElse("Without Country!");
        final Integer airportAltitude = airport.map(a -> a.getAltitude()).orElse(0);
        final String airportCity = airport.map(a -> a.getCity()).orElse("Nu avem Oras");

        mav.addObject("airportName", aiportName);
        mav.addObject("airportCountry", airportCountry);
        mav.addObject("airportAltitude", airportAltitude);
        mav.addObject("airportCity", airportCity);
        return mav;
    }
}