package com.example.pr23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FootballerController {
    private FootballerService footballerService;

    @Autowired
    public FootballerController(FootballerService footballerService) {
        this.footballerService = footballerService;
    }

    @PostMapping("/footballers")
    public String greetingSubmit(@ModelAttribute Footballer footballer) {
        footballerService.save(footballer);
        return "footballers";
    }
    @GetMapping("/footballers")
    public String createFootballer(Model model) {
        model.addAttribute("footballer", new Footballer());
        return "footballers";
    }
    @GetMapping("allFootballers")
    public String allFootballers(Model model) {
        model.addAttribute("footballers", footballerService.getFootballers());
        return "allFootballers";
    }

    @DeleteMapping("/footballers/{id}")
    public String deleteFootballer(@PathVariable Long id) {
        footballerService.delete(id);
        return "allFootballers";
    }
    @GetMapping(value = "/team/{footballerId}/footballer")
    public  @ResponseBody Team getFootballersTeam(@PathVariable("footballerId") Long footballerId){
        return footballerService.getTeamByFootballer(footballerId);
    }

    @GetMapping ("/footballers/filterByFirstName")
    public String filterByFirstName(@RequestParam("firstName") String firstName, Model model) {
        model.addAttribute("footballers", footballerService.filterFootballersByFirstName(firstName));
        return "allFootballers";
    }
    @GetMapping ("/footballers/filterBySecondName")
    public @ResponseBody List<Footballer> filterBySecondName(@RequestParam("secondName") String secondName, Model model) {
        return footballerService.filterFootballerBySecondName(secondName);
    }
    @GetMapping ("/footballers/filterByTeam")
    public @ResponseBody List<Footballer> filterByTeam(@RequestParam("team") Long team, Model model) {
        return footballerService.filterFootballerByTeam(team);
    }
}
