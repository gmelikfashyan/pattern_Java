package com.example.pr18;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/teams")
    public String greetingSubmit(@ModelAttribute Team team) {
        teamService.save(team);
        return "teams";
    }
    @GetMapping("/teams")
    public String createTeam(Model model) {
        model.addAttribute("team", new Team());
        return "teams";
    }
    @GetMapping("allTeams")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        return "allTeams";
    }

    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamService.delete(id);
        return "allTeams";
    }

}
