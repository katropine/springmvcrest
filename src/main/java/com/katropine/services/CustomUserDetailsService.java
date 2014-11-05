/**
* @package Restful - katropine
* @author Kristian Beres <kristian@katropine.com>
* @copyright Katropine (c) 2014, www.katropine.com
* @since Oct 31, 2014
* @licence MIT
*
* Copyright (c) 2014 Katropine - Kristian Beres, http://www.katropine.com/
*
* Permission is hereby granted, free of charge, to any person obtaining
* a copy of this software and associated documentation files (the
* "Software"), to deal in the Software without restriction, including
* without limitation the rights to use, copy, modify, merge, publish,
* distribute, sublicense, and/or sell copies of the Software, and to
* permit persons to whom the Software is furnished to do so, subject to
* the following conditions:
*
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
* LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
* OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
* WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.katropine.services;

import com.katropine.dao.BackendUserDaoLocal;
import com.katropine.dao.UserDaoLocal;
import com.katropine.models.BackendUser;
import com.katropine.models.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
@Transactional
@Configurable
public class CustomUserDetailsService implements UserDetailsService{
    
    @EJB(mappedName = "BackendUserDao")
    @Autowired
    private BackendUserDaoLocal userDAO;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        BackendUser domainUser = userDAO.getByUsername(username);
         
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Integer access = 1;
        
        org.springframework.security.core.userdetails.User sessUser =  new org.springframework.security.core.userdetails.User(
                domainUser.getUsername(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(access)
        );
       
        return sessUser;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities(Integer access) {
//        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(access));
//        return authList;
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        if (access.compareTo(1) == 0) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        else{
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authList;
    }
     
    public List<String> getRoles(Integer role) {
 
        List<String> roles = new ArrayList<String>();
 
        if (role.intValue() == 1) {
            roles.add("ROLE_ADMINISTRATOR");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_USER");
        }
        return roles;
    }
     
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
