/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.katropine.dao;

import com.katropine.models.Role;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kriss
 */
@Stateless
@EJB(beanInterface = RoleDaoLocal.class, name = "RoleDao", mappedName = "RoleDao")
public class RoleDao implements RoleDaoLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Role getRole(Integer id) {
        return this.em.find(Role.class, id);
    }
}
