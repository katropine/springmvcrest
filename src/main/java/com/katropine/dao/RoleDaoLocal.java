/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.katropine.dao;

import com.katropine.models.Role;
import javax.ejb.Local;

/**
 *
 * @author kriss
 */
@Local
public interface RoleDaoLocal {
    
    Role getRole(Integer id);
    
}
