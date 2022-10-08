package com.example.todothymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.todothymeleaf.model.Todo;
import com.example.todothymeleaf.repository.TodoRepository;

@Controller
public class TodoController {

    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Todo> myList = todoRepository.findAll();

        for (Todo todo : myList) {
            System.out.println(todo.title);
        }

        model.addAttribute("myList", myList);
        model.addAttribute("todo", new Todo());
        return "home";
    }

    @PostMapping("/add")
    public String submit(@ModelAttribute Todo todo) {

        todoRepository.save(new Todo(todo.getTitle(), true));
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        todoRepository.deleteById(id);
        System.out.println("deleted");
        return "redirect:/";
    }

}
