package com.booleanuk.core;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TodoList {

    ArrayList<Task> listOfTasks;

    public TodoList() {
        this.listOfTasks = new ArrayList<>();
    }

    public boolean addTask(Task task) {
        try {
            this.listOfTasks.add(task);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ArrayList<Task> retrieveTasks () {
        try {
            for(Task task : this.listOfTasks) {
                System.out.println(task.name);
            }
        } catch (Exception e) {
            System.out.println("Error, returning empty list");
            return new ArrayList<>();
        }
        return this.listOfTasks;
    }

    public ArrayList<Task> getCompleteTasks() {
        ArrayList<Task> completedTasks = new ArrayList<>();
        try {
            for(Task task : this.listOfTasks) {
                if (task.status) {
                    System.out.println(task.name);
                    completedTasks.add(task);
                }
            }
        } catch (Exception e) {
            System.out.println("Error, returning empty list");
            return new ArrayList<>();
        }
        return completedTasks;
    }

    public ArrayList<Task> getIncompleteTasks() {
            ArrayList<Task> incompleteTasks = new ArrayList<>();
            try {
                for(Task task : this.listOfTasks) {
                    if (!task.status) {
                        System.out.println(task.name);
                        incompleteTasks.add(task);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error, returning empty list");
                return new ArrayList<>();
            }
            return incompleteTasks;
        }

     public Task searchTask(Task task) {
        try {
            for (Task t : this.listOfTasks) {
                if (t.name == task.name) {
                    return task;
                }
            }
        } catch (Exception e) {
            System.out.println("ERror, returning naked task");
            return new Task("");
        }
         System.out.println("Task does not exist, thus not found");
         return task;
     }

     public void removeTask(Task task) {
        if (this.listOfTasks.contains(task)) {
            this.listOfTasks.remove(this.listOfTasks.indexOf(task));
            System.out.println("Task: " + task.name + " was successfully removed");
        } else {
            System.out.println("Task: " + task.name + " is not currently in To-Do List");
        }
     }

     public void removeAllTasks() {
        if (!this.listOfTasks.isEmpty()) {
            for (int i = 0; i <= this.listOfTasks.size(); i++) {
                System.out.println("Task: " + this.listOfTasks.get(0).name + " was successfully removed");
                this.listOfTasks.remove(0);
            }
        } else {
            System.out.println("No tasks to remove");
        }
     }

     public ArrayList<Task> showTasksAscending() {
        Collections.sort(this.listOfTasks, Comparator.comparing(Task::getName));
         System.out.print("Tasks: ");
         for(Task task : this.listOfTasks) {
             System.out.print(task.name + " ");
         }
         System.out.println();
        return this.listOfTasks;
    }

    public ArrayList<Task> showTasksDescending() {
        Collections.sort(this.listOfTasks, Comparator.comparing(Task::getName, Comparator.reverseOrder()));
        System.out.print("Tasks: ");
        for(Task task : this.listOfTasks) {
            System.out.print(task.name + " ");
        }
        System.out.println();
        return this.listOfTasks;
    }

    public static void main(String[] args) {
        TodoList lst = new TodoList();
        Task task_1 = new Task("CV");
        Task task_2 = new Task("Sleep");
        Task task_3 = new Task("Abefest");
        Task task_4 = new Task("Zoo");
        lst.addTask(task_1);
        lst.addTask(task_2);
        lst.addTask(task_3);
        lst.addTask(task_4);

        lst.showTasksAscending();
        lst.showTasksDescending();

        lst.removeTask(task_1);
        lst.removeAllTasks();

    }

}
