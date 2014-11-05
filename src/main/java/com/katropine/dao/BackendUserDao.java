/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.katropine.dao;

import com.katropine.models.BackendUser;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kriss
 */
@Stateless
@EJB(beanInterface = BackendUserDaoLocal.class, name = "BackendUserDao", mappedName = "BackendUserDao")
public class BackendUserDao implements BackendUserDaoLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addBackendUser(BackendUser user) {
        this.em.persist(user);
    }
    
    @Override
    public void editBackendUser(BackendUser user) {
        this.em.merge(user);
    }

    @Override
    public void deleteBackendUser(int id) {
        this.em.remove(id);
    }

    @Override
    public BackendUser getBackendUser(int id) {
        return this.em.find(BackendUser.class, id);
    }
    @Override
    public BackendUser getByUsername(String username) {

         List<BackendUser> users = this.em.createNamedQuery("BackendUser.getByUsername")
                .setParameter("username", username)
                .getResultList();

        if (!users.isEmpty() && users.get(0).getId() > 0) {
            return users.get(0);
        }else{
            return null;
        }
       
    }
}
