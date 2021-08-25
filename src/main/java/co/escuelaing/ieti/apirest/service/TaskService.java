/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.escuelaing.ieti.apirest.service;

import co.escuelaing.ieti.apirest.data.Task;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface TaskService {
    Task create( Task task );

    Task findById( String id );
        
    List<Task> all();

    void deleteById( String id );

    Task update( Task task, String id );
}
