package com.fire.fire.controller;


import com.fire.fire.Model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MainController {


   // @GetMapping("/login")
   // public String login(User user){
   //     return ("logowanie_responsywne.html");
   // }
  //
  //
  //  @GetMapping("/PROFIL_2.html")
  //  public String Profil(User user){
  //      return ("PROFIL_2.html");
  //  }
  //
  //
   // @PostMapping("/logowanie_responsywne")
  //  public String registerUser(User user){
  //      System.out.print(user.getFirstName().toString());
   //     return "redirect:/PROFIL_2.html";
   // }

}
