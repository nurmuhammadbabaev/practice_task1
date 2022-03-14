package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import peaksoft.entity.Group;

import peaksoft.servise.ServiceGroup;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private final ServiceGroup serviceGroup;

    @Autowired
    public GroupController(ServiceGroup serviceGroup) {
        this.serviceGroup = serviceGroup;
    }
    @GetMapping
    public String getAllGroup(Model model) {
        model.addAttribute("groups", serviceGroup.getAllGroup());
        return "company-page";
    }


    @GetMapping("/new")
    public String newGroup(@ModelAttribute("group") Group group) {
        //Добавляем компанию в БД

        return "addGroup";
    }

    @PostMapping("/save")
    public String addGroup(@ModelAttribute("group") Group group) {
        serviceGroup.saveGroup(group);
        return "redirect:/groups";
    }
    @GetMapping("/{id}edit")
    public String editGroup(@PathVariable("id")int id,Model model){
        model.addAttribute("group", serviceGroup.getById(id));

        return "updateGroup";
    }

    @PatchMapping ("/{id}")
    public String updateGroup(@ModelAttribute("group")Group group,@PathVariable("id") int id){
        serviceGroup.update(id,group);
        return "redirect:/groups";
    }

    @GetMapping("/{id}")
    public String deleteGroup(@PathVariable("id")int id ){
        serviceGroup.removeGroupById(id);
        return "redirect:/groups";
    }
    @GetMapping("/open")
    public String openStudent(){
        return "user-page";
    }
}
