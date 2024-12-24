package com.example.Java_guides_thymeleaf_delete_it_after_completion.Controller;

import com.example.Java_guides_thymeleaf_delete_it_after_completion.Repository.Project_work_List_Repository;
import com.example.Java_guides_thymeleaf_delete_it_after_completion.model.Project_work_list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class Project_Apartment_Controller {
    @GetMapping("/home")
    public String homepage(){
        return "Project_Home_Page";
    }

    @GetMapping("/data")
    public String datapage(){
        return "data";
    }



    @Autowired
    private Project_work_List_Repository repository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("projectWorkList", new Project_work_list());
        return "project_work_form"; // Name of the HTML file without .html extension
    }

    @PostMapping("/submit")
    public String submitRegistrationForm(@ModelAttribute Project_work_list projectWorkList) {
        repository.save(projectWorkList); // Save the data to the database
        return "redirect:/success"; // Redirect to a success page or another endpoint
    }

    @GetMapping("/success")
    public String success() {
        return "success"; // Name of the success HTML page
    }



   //RETRIVAL OF DATA



    @GetMapping("/last_7_hours")
    public String retrieveLast7Hours(Model model) {
        // Get the current time
        LocalDateTime endDate = LocalDateTime.now();

        // Calculate the time 7 hours ago
        LocalDateTime startDate = endDate.minusHours(7);

        // Fetch data using the repository method
        List<Project_work_list> dateAndTime = repository.findByCreatedAtBetween(startDate, endDate);

        // Add the data to the model for Thymeleaf
        model.addAttribute("dateAndTimeList", dateAndTime);

        // Return the view name
        return "last_7_hours";
    }

    @GetMapping("/last_24_hours")
    public String retrieveLast24Hours(Model model) {
        // Get the current time
        LocalDateTime endDate = LocalDateTime.now();

        // Calculate the time 7 hours ago
        LocalDateTime startDate = endDate.minusHours(24);

        // Fetch data using the repository method
        List<Project_work_list> dateAndTime = repository.findByCreatedAtBetween(startDate, endDate);

        // Add the data to the model for Thymeleaf
        model.addAttribute("dateAndTimeList", dateAndTime);

        // Return the view name
        return "last_24_hours";
    }


    @GetMapping("/viewAll")
    public String viewAllData(Model model) {
        // Retrieve all data from the database
        List<Project_work_list> projectWorkList = repository.findAll();

        // Add the retrieved data to the model to be displayed in the Thymeleaf template
        model.addAttribute("projectWorkList", projectWorkList);

        // Return the Thymeleaf template name (view)
        return "viewAll";  // Make sure this matches the name of your Thymeleaf HTML template
    }





















}
