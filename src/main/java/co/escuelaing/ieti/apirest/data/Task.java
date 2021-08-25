/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.escuelaing.ieti.apirest.data;

import co.escuelaing.ieti.apirest.dto.TaskDTO;

/**
 *
 * @author Javier
 */
public class Task {
    public String id;
    public String name;
    public String description;
    public String status;
    public String assignedTo;
    public String dueDate;
    public String created;

    public Task(String id){
        this.id = id;
    }

    public Task(TaskDTO taskDTO) {
        this.name = taskDTO.getName();
        this.description = taskDTO.getDescription();
        this.status = taskDTO.getStatus();
        this.assignedTo = taskDTO.getAssignedTo();
        this.dueDate = taskDTO.getDueDate();
        this.created = taskDTO.getCreated();
    }
    
    public Task(String id, String name, String description, String status, String assignedTo, String dueDate, String created) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}
