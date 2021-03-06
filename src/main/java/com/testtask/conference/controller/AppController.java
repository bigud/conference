package com.testtask.conference.controller;

import com.testtask.conference.dao.LectureRepository;
import com.testtask.conference.dao.RoomRepository;
import com.testtask.conference.dao.SceduleRepository;
import com.testtask.conference.model.Lecture;
import com.testtask.conference.model.Room;
import com.testtask.conference.model.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.testtask.conference.model.User;
import com.testtask.conference.dao.ConfRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Controller
public class AppController {
    @Autowired
    ConfRepository confRepository;
    @Autowired
    LectureRepository lRepository;
    @Autowired
    SceduleRepository sceduleRepository;
    @Autowired
    RoomRepository roomRepository;

//    @RequestMapping("/info")
//    public String infoPage(@RequestParam(value = "name", required = false, defaultValue = "test") String name, Model model){
//        model.addAttribute("name", name);
//        return "info";
//    }
    @RequestMapping("/register")
    public String register(@RequestParam(value  = "name", required = true, defaultValue = "listener") String name,
                           @RequestParam(value  = "email", required = true, defaultValue = "") String email,
                           @RequestParam(value  = "password", required = true, defaultValue = "") String password, Model model){
        model.addAttribute("name", name);
        User user = new User();
        user.setName(name);
        user.setLogin(name);
        user.setEmail(email);
        user.setRole("ROLE_LISTENER");
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        confRepository.save(user);
        model.addAttribute("user", "User created + " + name);
        return "register";

    }
    @RequestMapping("/newlecture")
    public String newlecture(
            @RequestParam(value = "content", required = false, defaultValue = "bla-bla-bla") String content,
            @RequestParam(value = "title", required = false, defaultValue = "") String title,
            @RequestParam(value = "datetime", required = false, defaultValue = "") String datetime,
            @RequestParam(value = "room", required = false, defaultValue = "1") int roomNumber,
            Model model) {
        Room room = roomRepository.findOne(roomNumber);
//        if (room != null) {
//            model.addAttribute("error", "Wrong room number on this date/time!");
//        } else {
//        try {
        Lecture lecture = new Lecture();
        lecture.setContent(content);
        lecture.setTitle(title);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = confRepository.findByLogin(name);
        Set<User> usrs = lecture.getLecturer();
        if (usrs == null) {
            usrs = new HashSet<User>();
        }
        usrs.add(user);
        lecture.setLecturers(usrs);
        lRepository.save(lecture);
            //
            Schedule schedule = new Schedule();
            schedule.setDatetime(datetime);
            schedule.setRoom(room);
            sceduleRepository.save(schedule);
        model.addAttribute("message", "Schedule is updated.");
//        } catch (Exception exception){
//            model.addAttribute("error", "This room has been occupied already!");
//        } }
        return "newlecture";

    }
    @RequestMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login.html";
//    }

    @RequestMapping("/userlist")
    public String userlist(@RequestParam(value  = "login", required = true, defaultValue = "presenter1") String login, Model model){
        model.addAttribute("list", confRepository.findAll());
            User user = confRepository.findByLogin(login);
            if (user != null) {
                user.setRole("ROLE_PRESENTER");
                confRepository.save(user);
            }
        return "userlist";
    }
    @RequestMapping("/index")
    public String index(Model model){
        //System.out.println(confRepository.findAll().toString());
        model.addAttribute("list", sceduleRepository.findAll());
        return "index";
    }
    @RequestMapping("/login-error")
    public String login_error(Model model){
        model.addAttribute("message", "Login incorrect!");
        return "login-error";
    }
}
