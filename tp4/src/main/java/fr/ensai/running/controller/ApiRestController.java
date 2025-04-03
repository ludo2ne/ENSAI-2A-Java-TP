package fr.ensai.running.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.service.AthleteService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private AthleteService athleteService;

    /**
     * Get all athletes
     */
    @GetMapping("/athlete")
    public List<Athlete> allAthletes() {
        return athleteService.findAll();
    }

    /**
     * Get an athlete by id
     * 
     */
    @GetMapping("/athlete/{id}")
    public Athlete athleteById(@PathVariable long id) {

        return athleteService.findById(id);
    }

    /**
     * Add a new athlete
     */
    @PostMapping("/athlete")
    public ResponseEntity<Athlete> addAthlete(@RequestBody Athlete athlete) {
        Athlete savedAthlete = athleteService.save(athlete);
        return ResponseEntity.ok(savedAthlete);
    }

    /**
     * Delete an athlete by ID
     */
    @DeleteMapping("/athlete/{id}")
    public ResponseEntity<String> deleteAthlete(@PathVariable long id) {
        Athlete athlete = athleteService.findById(id);
        if (athlete != null) {
            athleteService.deleteById(id);
            return ResponseEntity.ok("Athlete deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Athlete not found.");
        }
    }

    // @GetMapping("/competition/{id_competition}/athlete/{id_athlete}")
    // public Registration registeredAthletes(@PathVariable(value = "id_athlete")
    // long id_athlete,
    // @PathVariable(value = "id_competition") long id_competition) {
    //
    // return competitionService.findByIdAthleteAndIdCompetition(id_athlete,
    // id_competition);
}
