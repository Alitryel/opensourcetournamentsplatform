package ru.alitryel.opensourcetournamentsplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/calculate-form")
    public String showCalculateForm() {
        return "calculateForm";
    }

    @GetMapping("/calculate")
    public String calculateTime(
            @RequestParam(name = "developmentTime") int developmentTime,
            @RequestParam(name = "beerLiters") int beerLiters,
            @RequestParam(name = "laziness") int laziness,
            @RequestParam(name = "desire") int desire,
            @RequestParam(name = "teamSize") int teamSize,
            Model model
    ) {
        double result = (developmentTime * beerLiters * laziness * desire) / teamSize;

        model.addAttribute("result", result);

        return "result";
    }

}

