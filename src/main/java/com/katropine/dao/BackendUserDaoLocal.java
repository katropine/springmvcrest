/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.katropine.dao;

import com.katropine.models.BackendUser;
import javax.ejb.Local;

/**
 *
 * @author kriss
 */
@Local
public interface BackendUserDaoLocal {
    void addBackendUser(BackendUser user);
    void editBackendUser(BackendUser user);
    void deleteBackendUser(int id);
    BackendUser getBackendUser(int id);
    BackendUser getByUsername(String username);
}
