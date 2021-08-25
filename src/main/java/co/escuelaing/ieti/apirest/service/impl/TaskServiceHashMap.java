/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.escuelaing.ieti.apirest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.escuelaing.ieti.apirest.data.Task;
import co.escuelaing.ieti.apirest.service.TaskService;

import co.escuelaing.ieti.apirest.data.Task;
import co.escuelaing.ieti.apirest.service.TaskService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.HashMap;
/**
 *
 * @author Javier
 */
@Service
public class TaskServiceHashMap implements TaskService{

    private final HashMap<String, Task> tasksHash;
    private static final AtomicInteger COUNTER_ID = new AtomicInteger(1);

    public TaskServiceHashMap() {
        this.tasksHash = new HashMap<>();
    }

    @Override
    public Task create(Task task) {
        for (Task t: tasksHash.values()) {
            if(t.getName()==task.getName() && t.getDescription()==task.getDescription() && t.getAssignedTo()==task.getAssignedTo() && t.getDueDate()==task.getDueDate() && t.getCreated()==task.getCreated()){
                throw new RuntimeException("Create task error.");
            }else{
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                task.setId(String.valueOf(COUNTER_ID.getAndIncrement()));
                task.setCreated(format.format(new Date()));
                tasksHash.put(task.getId(), task);
            }
        }

        return task;
    }

    @Override
    public Task findById(String id) {
        return tasksHash.get(id);
    }

    @Override
    public List<Task> all() {
        return new ArrayList<>(tasksHash.values());
    }

    @Override
    public Task update(Task task, String id) {
        if (tasksHash.containsKey(id))
        {
            task.setId(id);
            task.setCreated(tasksHash.get(id).getCreated());
            tasksHash.replace(id, task);
            return task;
        }else
        {
            return null;
        }
    }

    @Override
    public void deleteById(String id) {
        tasksHash.remove(id);
        
    }
}
