package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TodoListTest {
    @Test
    public void testAdd() {
        TodoList lst = new TodoList();
        Task task = new Task("CV");

        Assertions.assertEquals(true, lst.addTask(task));
        Assertions.assertTrue(lst.addTask(new Task("Sleep")));
    }

    @Test
    public void testRetrieveTasks() {
        TodoList lst = new TodoList();
        List<Task> ex = new ArrayList<Task>();

        Task task_1 = new Task("CV");
        Task task_2 = new Task("Sleep");

        lst.addTask(new Task("CV"));
        lst.addTask(new Task("Sleep"));

        ex.add(task_1);
        ex.add(task_2);

        Assertions.assertNotEquals(lst.retrieveTasks(), ex);
    }

    @Test
    public void testSetStatus() {
        TodoList lst = new TodoList();
        Task task = new Task("CV");
        Assertions.assertFalse(task.status);

        task.setStatus(true);
        Assertions.assertTrue(task.status);
    }

    @Test
    public void testGetCompleteTasks() {
        TodoList lst = new TodoList();
        Task task_1 = new Task("CV");
        Task task_2 = new Task("Sleep");

        lst.addTask(task_1);
        lst.addTask(task_2);

        Assertions.assertFalse(task_1.status);
        lst.addTask(task_1);
        lst.addTask(task_2);
        task_1.setStatus(true);

        Assertions.assertSame(task_1, lst.getCompleteTasks().get(0));
        Assertions.assertNotSame(task_2, lst.getCompleteTasks().get(0));
    }

    @Test
    public void testGetIncompleteTasks() {
        TodoList lst = new TodoList();
        Task task_1 = new Task("CV");
        Task task_2 = new Task("Sleep");

        lst.addTask(task_1);
        lst.addTask(task_2);

        Assertions.assertFalse(task_1.status);
        lst.addTask(task_1);
        lst.addTask(task_2);
        task_1.setStatus(true);

        Assertions.assertNotSame(task_1, lst.getIncompleteTasks().get(0));
        Assertions.assertSame(task_2, lst.getIncompleteTasks().get(0));
    }

    @Test
    public void testSearchTask() {
        TodoList lst = new TodoList();
        Task task_1 = new Task("CV");
        Task task_2 = new Task("Sleep");
        lst.addTask(task_1);

        Assertions.assertTrue(lst.listOfTasks.contains(lst.searchTask(task_1)));
        Assertions.assertFalse(lst.listOfTasks.contains(lst.searchTask(task_2)));
    }

    @Test
    public void testRemoveTask() {
        TodoList lst = new TodoList();
        Task task_1 = new Task("CV");
        lst.addTask(task_1);

        lst.removeTask(task_1);

        Assertions.assertTrue(lst.listOfTasks.isEmpty());
    }

    @Test
    public void testRemoveAllTasks() {
        TodoList lst = new TodoList();
        Task task_1 = new Task("CV");
        Task task_2 = new Task("Sleep");
        lst.addTask(task_1);
        lst.addTask(task_2);

        lst.removeAllTasks();

        Assertions.assertTrue(lst.listOfTasks.isEmpty());
    }

    @Test
    public void testShowTasksAscending() {
        TodoList lst = new TodoList();
        Task task_1 = new Task("CV");
        Task task_2 = new Task("Sleep");
        Task task_3 = new Task("Abefest");
        Task task_4 = new Task("Zoo");
        lst.addTask(task_1);
        lst.addTask(task_2);
        lst.addTask(task_3);
        lst.addTask(task_4);

        Assertions.assertEquals(lst.showTasksAscending().get(0), lst.listOfTasks.get(0));
    }

    @Test
    public void testShowTasksDescending() {
        TodoList lst = new TodoList();
        Task task_1 = new Task("CV");
        Task task_2 = new Task("Sleep");
        Task task_3 = new Task("Abefest");
        Task task_4 = new Task("Zoo");
        lst.addTask(task_1);
        lst.addTask(task_2);
        lst.addTask(task_3);
        lst.addTask(task_4);

        Assertions.assertEquals(lst.showTasksAscending().get(3), lst.listOfTasks.get(3));
    }
}
