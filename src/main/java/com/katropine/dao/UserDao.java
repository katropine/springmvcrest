package com.katropine.dao;

import com.katropine.libs.BCrypt;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import com.katropine.models.User;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author kriss
 */
@Stateless
@EJB(beanInterface = UserDaoLocal.class, name = "UserDao", mappedName = "UserDao")
public class UserDao implements UserDaoLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addUser(User user) {
        this.em.persist(user);
    }
    
    @Override
    public void editUser(User user) {
        this.em.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        this.em.remove(this.getUser(id));
    }

    @Override
    public User getUser(int id) {
        return this.em.find(User.class, id);
    }
   
    
    @Override
    public List<User> getAllUsers(String search) {
        if (search == null) {
            return this.em.createNamedQuery("User.getAll").getResultList();
        }
        return this.em.createNamedQuery("User.searchAll")
                .setParameter("fname", "%" + search + "%")
                .setParameter("lname", "%" + search + "%")
                .setParameter("email", "%" + search + "%")
                .getResultList();
    }

    @Override
    public List<User> getAllUsers(String search, int offset, int limit) {
        if (search == null) {
            return this.em.createNamedQuery("User.getAll").getResultList();
        }
        return this.em.createNamedQuery("User.searchAll")
                .setParameter("fname", "%" + search + "%")
                .setParameter("lname", "%" + search + "%")
                .setParameter("email", "%" + search + "%")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public int countAllUsers(String search) {
        if (search == null) {
            return this.em.createNamedQuery("User.getAll").getResultList().size();
        }
        return ((Number) this.em.createNamedQuery("User.countAll")
                .setParameter("fname", "%" + search + "%")
                .setParameter("lname", "%" + search + "%")
                .setParameter("email", "%" + search + "%")
                .getSingleResult()).intValue();
    }

    @Override
    public void getUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public User getByEmail(String email){
        List<User> users = this.em.createNamedQuery("User.getByEmail")
               .setParameter("email", email)
                .getResultList();
        
        if (!users.isEmpty() && users.get(0).getId() > 0) {
            return users.get(0);
        }
        return new User();
    }
    
    @Override
    public User authenticate(User user) {
//        System.out.println("User0: "+user.getEmail());
//        List<User> users = this.em.createNamedQuery("User.authenticate")
//                .setParameter("email", user.getEmail())
//                .getResultList();
//        //&& BCrypt.checkpw(user.getCandidatePassword(), users.get(0).getPassword())
//        if (!users.isEmpty() && users.get(0).getId() > 0) {
//            return users.get(0);
//        }
        return new User();
    }
}
