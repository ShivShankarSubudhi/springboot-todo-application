package com.udemycourse.todoapp.controller;

import com.udemycourse.todoapp.model.Todo;
import com.udemycourse.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/todos",method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> findAll(){
       return todoService.getTodos();

    }

    @RequestMapping(value = "/list-todos",method = RequestMethod.GET)
     public String showTodos(ModelMap model){
        model.put("todos", todoService.getTodosByName((String) model.get("username")));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model){
        model.addAttribute("todo",new Todo(0,(String) model.get("username"),"Learn Technology",new Date(),false));
        return "add-todo";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "add-todo";
        }
        todoService.addTodo((String)model.get("username"),todo.getDesc(),new Date(),false);
        return "redirect:/list-todos";
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

        todo.setUser((String)model.get("username"));
        todoService.updateTodobyId(todo);
        return "redirect:/list-todos";
    }

}
