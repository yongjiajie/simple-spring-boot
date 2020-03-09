package sg.com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.com.example.demo.model.User;
import sg.com.example.demo.model.UserRepository;
import sg.com.example.demo.model.UserResults;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public UserResults findUsers() {
        List<User> users = (List<User>) userRepository.findBySalaryBetween(0.00, 4000.00);
        return new UserResults(users);
    }

}
