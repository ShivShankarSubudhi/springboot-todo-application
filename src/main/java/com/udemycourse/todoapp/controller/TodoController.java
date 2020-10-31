package com.udemycourse.todoapp.controller;

import com.udemycourse.todoapp.model.Todo;
import com.udemycourse.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.Banner;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoController {
    @Autowired
    TodoService todoService;

    @InitBinder
    public  void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
    }

    @RequestMapping(value = "/todos",method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> findAll(){
       return todoService.getTodos();

    }

    @RequestMapping(value = "/list-todos",method = RequestMethod.GET)
     public String showTodos(ModelMap model){
        model.put("todos", todoService.getTodosByName(getLoggedInUsername(model)));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model){
        model.addAttribute("todo",new Todo(0, getLoggedInUsername(model),"Learn Technology",new Date(),false));
        return "add-todo";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "add-todo";
        }
        System.out.println("targetDate" + todo.getTargetDate());
        todoService.addTodo(getLoggedInUsername(model),todo.getDesc(),todo.getTargetDate(),false);
        return "redirect:/list-todos";
    }

    private String getLoggedInUsername(ModelMap model) {
        Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
           return ((UserDetails) principal).getUsername();
        }

        return  principal.toString();
    }


    @RequestMapping(value = "/delete-todo")
    public String deleteTodoById(@RequestParam Integer id){
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,@RequestParam Integer id){
        model.put("todo", todoService.findTodoById(id));
        return "add-todo";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.POST)
    public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result){
       if(result.hasErrors()){
            return "add-todo";
        }

        todo.setUser(getLoggedInUsername(model));
        todoService.updateTodobyId(todo);
        return "redirect:/list-todos";
    }

}
