package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")

    public String showRollDicePage(Model viewModel) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        viewModel.addAttribute("numbers", numbers);
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String showRollDicePage(@PathVariable String n, Model viewModel){

        Random random = new Random();

        Integer randomNum = random.nextInt(6) + 1;
        String randomStr = String.valueOf(randomNum);


        // making the numbers array available in the html //
        viewModel.addAttribute("randomNum", randomStr);

        if(n.equals(randomStr)){
            viewModel.addAttribute("success", "You guessed it!");
        } else {
            viewModel.addAttribute("success", "Nope...");
        }
        return "roll-dice";
    }

}

//  th:replace="partials/master :: footer"

//  Goes inside of a html container.  Partials/master is the path to the file.