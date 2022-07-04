package kata.PP.Task_3_1_1.controller;

import kata.PP.Task_3_1_1.entity.User;
import kata.PP.Task_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String getAllUser(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "getuser";
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "new";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String updateUserForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "edit";
        }
        userService.save(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.removeById(id);
        return "redirect:/";
    }

}
