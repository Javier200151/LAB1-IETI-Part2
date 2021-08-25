/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.escuelaing.ieti.apirest.controller;

import co.escuelaing.ieti.apirest.service.TaskService;
import co.escuelaing.ieti.apirest.dto.TaskDTO;
import co.escuelaing.ieti.apirest.data.Task;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javier
 */
@RestController
@RequestMapping( "/v1/task" )
public class TaskController
{
    @Autowired
    private final TaskService taskService;

    public TaskController( TaskService taskService )
    {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> all()
    {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.all());
    }
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById( @PathVariable String id )
    {
       return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Task> create( @RequestBody TaskDTO taskDTO )
    {
        try 
        {
            return ResponseEntity.status(HttpStatus.OK).body(taskService.create(new Task(taskDTO)));
        } catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDTO taskDTO, @PathVariable String id )
    {
        try 
        {
            return ResponseEntity.status(HttpStatus.OK).body(taskService.update(new Task(taskDTO), id));
        } catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        try 
        {
            taskService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }      
    }
}      