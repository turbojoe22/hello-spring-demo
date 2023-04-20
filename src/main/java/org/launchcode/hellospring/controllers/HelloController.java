package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

//     Handle request at path /hello
//
//
//     lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

//     Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

//     Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

//     /hello/form


    @RequestMapping(value = "form", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = method ='post' '/hello' >" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language'>" +
                "<option value = 'English'>English<option>" +
                "<option value = 'French'>French<option>" +
                "<option value = 'Spanish'>Spanish<option>" +
                "<option value = 'German'>German<option>" +
                "<option value = 'Portuguese'>Portuguese<option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }



    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equals("English")){
            greeting =  "Hello " ;
        } else if (language.equals("French")){
            greeting = "Bonjour " ;
        } else if (language.equals("Spanish")){
            greeting = "Hola " ;
        } else if (language.equals("German")){
            greeting = "Hallo ";
        } else if (language.equals("Portuguese")){
            greeting = "Ola " ;
        }
        return greeting + name;
    }
    @RequestMapping(value = "method", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name, @RequestParam String language) {
        if (name == "") {
            name = "World";
        }
        return createMessage(name, language);
    }

    }


