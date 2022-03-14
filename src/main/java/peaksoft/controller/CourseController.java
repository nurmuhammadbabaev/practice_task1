package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.servise.ServiceCompany;
import peaksoft.servise.ServiceCourse;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final ServiceCompany serviceCompany;
    private final ServiceCourse serviceCourse;

    @Autowired
    public CourseController(ServiceCompany serviceCompany, ServiceCourse serviceCourse) {
        this.serviceCompany = serviceCompany;

        this.serviceCourse = serviceCourse;
    }


    @GetMapping
    public String getAllCourse(Model model) {
        model.addAttribute("courses", serviceCourse.getAllCourse());
        return "company-page";
    }


    @GetMapping("/new")
    public String newCourse(@ModelAttribute("course") Course course) {
        //Добавляем компанию в БД

        return "addCourse";
    }

    @PostMapping("/save")
    public String addCourse (@ModelAttribute("course") Course course) {

//        course.setCompany(serviceCompany.getById(31));

        serviceCourse.saveCourse(course);

        return "redirect:/courses";
    }

    @GetMapping("/{id}edit")
    public String editCourse(@PathVariable("id") int id, Model model) {
        model.addAttribute("course", serviceCourse.getById(id));

        return "updateCourse";
    }

    @PatchMapping("/{id}")
    public String updateCourse(@ModelAttribute("course") Course course, @PathVariable("id") int id, Model model) {
        serviceCourse.update(id, course);
        model.addAttribute("course", course);
        return "redirect:/courses";
    }

    @GetMapping("/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        serviceCourse.removeCourseById(id);
        return "redirect:/courses";
    }

    @GetMapping("/open")
    public String openStudent() {
        return "user-page";
    }


}
