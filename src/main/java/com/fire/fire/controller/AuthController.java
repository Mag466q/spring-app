package com.fire.fire.controller;


import com.fire.fire.Model.User;
import com.fire.fire.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthController {
    @Autowired
    private UserService userService;

     @RequestMapping(value = {"logowanie_responsywne","/","login"}, method = RequestMethod.GET)
    public ModelAndView login(User user) {
         ModelAndView modelAndView = new ModelAndView();;
         //System.out.print(user.getEmail());
         //System.out.print(user.getPassword());
         modelAndView.setViewName("logowanie_responsywne");
         return modelAndView;
     }
        @RequestMapping(value = {"/PROFIL_2"}, method = RequestMethod.GET)
         public ModelAndView side(User user) {
            ModelAndView modelAndView = new ModelAndView();
             Authentication auth = SecurityContextHolder.getContext().getAuthentication();
             user = userService.findUserByEmail(auth.getName());
             System.out.printf(user.toString());
             modelAndView.setViewName("/PROFIL_2");
             return modelAndView;
    }

}