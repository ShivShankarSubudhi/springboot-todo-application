package com.udemycourse.todoapp.service;


import com.udemycourse.todoapp.model.Todo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class TodoService {
    private static LinkedList<Todo> todos = new LinkedList<Todo>();

    static{

        todos.add(new Todo(1, "shiv", "Learn Springboot", new Date(),
                false));
        todos.add(new Todo(2, "shiv", "Learn Carbon Docs", new Date(), false));
        todos.add(new Todo(3, "shiv", "Learn JAVA collections", new Date(),
                false));
        todos.add(new Todo(4, "somu", "Learn JAVA Multithreading", new Date(),
                false));
    }

    public List<Todo> getTodosByName(String User){
        List<Todo> filterTodos = new LinkedList<Todo>();
        for (Todo todo: todos){
            if(todo.getUser().equalsIgnoreCase(User))
                filterTodos.add(todo);
        }
        return filterTodos;
    }

    public Todo findTodoById(Integer id){
        for (Todo todo: todos){
            if(todo.getId() == id) {
               return todo;
            }
        }
        return null;
    }

    public void updateTodobyId(Todo todo){
        todos.remove(todo);
        todos.add(todo);

    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(String user,String desc,Date targetDate,boolean isDone){
         todos.add(new Todo(todos.size() +1, user, desc, targetDate, isDone));
    }

    public void deleteTodo(Integer id){
        for (Todo todo: todos){
            if(todo.getId() == id) {
                todos.remove(todo);
                break;
            }
        }

    }






}
