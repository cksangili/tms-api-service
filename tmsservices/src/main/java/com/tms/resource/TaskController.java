package com.tms.resource;

import com.tms.dao.TaskDao;
import com.tms.entity.TaskEntity;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskController {

    private final TaskDao taskDao;

    public TaskController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @POST
    @Path("/save")
    @UnitOfWork
    public TaskEntity saveTask(@Valid TaskEntity entity){
        return taskDao.save(entity);
    }

    @GET
    @Path("/list")
    @UnitOfWork
    public TaskEntity getTask(@QueryParam("taskId") Integer taskId){
        return taskDao.find(taskId);
    }

    @GET
    @Path("/all")
    @UnitOfWork
    public ArrayList<TaskEntity> getAll(){
        return taskDao.fetchAll();
    }
}
