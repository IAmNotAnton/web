package ru.alishev.springcourse.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String openPageHello(@RequestParam(value = "name", required = false)    String name,
                                @RequestParam(value = "surname", required = false) String surname,
                                Model model) {

        //System.out.println(name + " " + surname);
        model.addAttribute("msg", name + " " + surname);

        return "first/hello_world";
    }

    @GetMapping("/godbye")
    public String openGodByePage() {
        return "first/godbye";
    }

    @GetMapping("/calculator")
    public String openCalculator(@RequestParam(value = "a", required = false) String a,
                                 @RequestParam(value = "b", required = false) String b,
                                 @RequestParam(value = "act", required = false) String act,
                                 Model model) {

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("act", act);

        int num1;
        int num2;

        String result = "";

        try {
            num2 = Integer.parseInt(b);
            num1 = Integer.parseInt(a);

            if(act.equals("plus")) {
                result = (num2 + num1) + "";
            } else if(act.equals("*")) {
                result = (num2 * num1) + "";
            } else if(act.equals("-")) {
                result = (num1 - num2) + "";
            } else if(act.equals("/")) {
                result = (num1 / num2) + "";
            }

        } catch (NumberFormatException e) {
            result = "error";
        }
        System.out.println("act: " + act + " res: " + result);

        model.addAttribute("result", result);

        return "/first/calculator";
    }
}
