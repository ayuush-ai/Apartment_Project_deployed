package com.example.Java_guides_thymeleaf_delete_it_after_completion.Controller;

import com.example.Java_guides_thymeleaf_delete_it_after_completion.EmailMessage;
import com.example.Java_guides_thymeleaf_delete_it_after_completion.Repository.UserRepository;
import com.example.Java_guides_thymeleaf_delete_it_after_completion.Service.EmailService;
import com.example.Java_guides_thymeleaf_delete_it_after_completion.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET request to show the login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());  // Empty user object to bind form
        return "loginForm";
    }

    // POST request to handle form submission
    @PostMapping("/login")
    public String handleLogin(@ModelAttribute User user) {
        // Save the user data
        userRepository.save(user);
        return "redirect:/login";  // Redirect after saving data (or show success message)
    }






    //EMAIL



    @Autowired
    private EmailService emailService;

    // Show the form for sending emails
    @GetMapping("/sendEmailForm")
    public String showSendEmailForm(Model model) {
        model.addAttribute("emailMessage", new EmailMessage());
        return "sendEmailForm";
    }

    // Handle the form submission and send email to all users
    @PostMapping("/sendEmail")
    public String sendEmailToAllUsers(@ModelAttribute EmailMessage emailMessage) {
        // Get all user emails from the database
        List<User> users = userRepository.findAll();
        List<String> emails = users.stream()
                .map(User::getEmail)
                .toList(); // Convert User list to List<String> of emails

        // Send email to all users
        emailService.sendEmailToUsers(emails, "Custom Message", emailMessage.getMessage());

        return "redirect:/sucessfully_sent";  // Redirect after sending email
    }


    @GetMapping("/sucessfully_sent")
    public String showSuccessPage() {
        return "sucessfully_sent";  // Return the success page
    }






}
