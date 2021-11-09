package com.tms.dao;

import com.tms.entity.TaskEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDao extends AbstractDAO<TaskEntity>{
    SessionFactory sessionFactory = null;

    public TaskDao(SessionFactory sessionFactory) {
            super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public TaskEntity find(Integer id){
        return get(id);
    }

    public TaskEntity save(TaskEntity entity){
        if(entity.getTaskId()==0)
            entity.setTaskId(generateUniqueId());
        return persist(entity);
    }

    public ArrayList<TaskEntity> fetchAll(){
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(TaskEntity.class);
        // get all employee records.
        ArrayList list = (ArrayList) criteria.list();

        return list;
    }
    public int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }
}
