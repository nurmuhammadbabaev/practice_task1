package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Student;
import peaksoft.servise.ServiceStudent;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final ServiceStudent serviceStudent;

    @Autowired
    public StudentController(ServiceStudent serviceStudent) {
        this.serviceStudent = serviceStudent;
    }

    @GetMapping
    public String getAllStudent(Model model) {
        model.addAttribute("students", serviceStudent.getAllStudent());
        return "user-page";
    }


    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student")Student student) {
        //Добавляем компанию в БД

        return "addStudent";
    }

    @PostMapping("/save")
    public String addStudent(@ModelAttribute("student") Student student) {
       serviceStudent.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/{id}edit")
    public String editStudent(@PathVariable("id")int id, Model model){
        model.addAttribute("student",serviceStudent.getById(id));

        return "updateStudent";
    }

    @PatchMapping("/{id}")
    public String updateStudent(@ModelAttribute("student")Student student,@PathVariable("id") int id,Model model){
       serviceStudent.update(id,student);
        model.addAttribute("student",student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable("id")int id ){
        serviceStudent.removeStudentById(id);
        return "redirect:/students";
    }

}
