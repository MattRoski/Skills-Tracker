package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {
    @GetMapping //without ("/someInHere") this is the root folder, the default main page
    @ResponseBody
    public String mainPage(){
        return "<h1>Skills Tracker</h1>" +
                "<h2>Here are some skills to learn.</h2>" +
                "<ol>" +
                "<li>JavaScript</li>" +
                "<li>Java</li>" +
                "<li>Python</li>" +
                "</ol>"
                ;
    }

    @PostMapping("formSubmit")
    @ResponseBody
    //the follow parameters must be named exactly as what you named your inputs in the form ex: input type = 'text' --> NAME = 'name' <--
    public String processForm(@RequestParam String name, @RequestParam String firstChoice, @RequestParam String secondChoice, @RequestParam String thirdChoice){
        return "<h1>" + name +"</h1>" +
                "<ol>" +
                "<li>" + firstChoice + "</li>" +
                "<li>"+ secondChoice +"</li>" +
                "<li>"+ thirdChoice +"</li>" +
                "</ol>";

    }


    //Need to make a method to handle the POST request of the form, only have 2 GET requests @GetMapping atm
    //leads to a 405 error
    @GetMapping("form")
    @ResponseBody
    public String skillsForm(){
        return "<form action = 'formSubmit' method='post'>" +  //by adding action = 'formSubmit' we will be redirected to /formSubmit instead of form
                "Name:<br>" +
               " <input type =' text' name = 'name' />" +
                "<br>My favorite language:<br>" +
                "<select name = 'firstChoice'>" +
                    "<option value = 'JavaScript'>JavaScript</option>" +
                    "<option value = 'Java'>Java</option>" +
                    "<option value = 'Python'>Python</option>" +
                "</select>" +
                "<br>My second favorite language:<br>" +
                    "<select name = 'secondChoice'>" +
                        "<option value = 'JavaScript'>JavaScript</option>" +
                        "<option value = 'Java'>Java</option>" +
                        "<option value = 'Python'>Python</option>" +
                "</select>" +
                "<br>My third favorite language:<br>" +
                "<select name = 'thirdChoice'>" +
                    "<option value = 'JavaScript'>JavaScript</option>" +
                    "<option value = 'Java'>Java</option>" +
                    "<option value = 'Python'>Python</option>" +
                "</select>" +
                "<br><input type='submit' value='Submit' />" +
                "</form>"
                ;
    }

}
