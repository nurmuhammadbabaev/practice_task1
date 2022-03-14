package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Teacher;
import peaksoft.servise.ServiceTeacher;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final ServiceTeacher serviceTeacher;

    @Autowired
    public TeacherController(ServiceTeacher serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }




    @GetMapping
    public String getAllTeacher(Model model) {
        model.addAttribute("teachers", serviceTeacher.getAllTeacher());
        return "user-page";
    }


    @GetMapping("/new")
    public String newTeacher(@ModelAttribute("teacher")Teacher teacher) {
        //Добавляем компанию в БД

        return "addTeacher";
    }

    @PostMapping("/save")
    public String addTeacher(@ModelAttribute("teacher")Teacher teacher) {
        serviceTeacher.saveTeacher(teacher);
        return "redirect:/teachers";
    }
    @GetMapping("/{id}edit")
    public String editTeacher(@PathVariable("id")int id, Model model){
        model.addAttribute("teacher",serviceTeacher.getById(id));

        return "updateTeacher";
    }

    @PatchMapping("/{id}")
    public String updateTeacher(@ModelAttribute("teacher")Teacher teacher,@PathVariable("id") int id,Model model){
       serviceTeacher.update(id,teacher);
        model.addAttribute("teacher",teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/{id}")
    public String deleteTeacher(@PathVariable("id")int id ){
        serviceTeacher.removeTeacherById(id);
        return "redirect:/teachers";
    }
}
