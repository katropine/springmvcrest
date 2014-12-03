/**
 * @package Restful - katropine
 * @author Kristian Beres <kristian@katropine.com>
 * @copyright Katropine (c) 2014, www.katropine.com
 * @since Nov 6, 2014
 * @licence MIT
 * 
* Copyright (c) 2014 Katropine - Kristian Beres, http://www.katropine.com/
 * 
* Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions:
 * 
* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.katropine.oauth;

import com.katropine.dao.UserDaoLocal;
import com.katropine.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomUserAuthenticationProvider implements AuthenticationProvider {
    
    private static final Logger LOGGER = Logger.getLogger("CustomUserAuthenticationProvider");
    
    @EJB(mappedName = "UserDao")
    @Autowired
    private UserDaoLocal userDAO;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        LOGGER.warning("!!!Authenticate: "+authentication.getPrincipal().toString()+":"+authentication.getCredentials().toString());
        
        if (!supports(authentication.getClass())) {
            return null;
        }
        if (authentication.getCredentials() == null) {
            LOGGER.warning("No credentials found in request.");
            boolean throwExceptionWhenTokenRejected = false;
            if (throwExceptionWhenTokenRejected) {
                throw new BadCredentialsException("No pre-authenticated credentials found in request.");
            }
            return null;
        }
        
        User user = userDAO.getByEmail(authentication.getPrincipal().toString());
        
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        if(!enc.matches(authentication.getCredentials().toString(), user.getPassword())){
            throw new BadCredentialsException("Bad User Credentials.");
        }
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        CustomUserPasswordAuthenticationToken auth = new CustomUserPasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), grantedAuthorities);

        return auth;
        
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {

        return true;
    }

}
