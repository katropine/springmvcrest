/**
 * @package Restful - katropine
 * @author Kristian Beres <kristian@katropine.com>
 * @copyright Katropine (c) 2014, www.katropine.com
 * @since Oct 29, 2014
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
package com.katropine.resources;

import com.katropine.models.Greeting;
import com.katropine.models.User;
import com.katropine.services.UserServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


// rest example

@RestController
@RequestMapping("/springrest")
@Component 
public class SpringrestController{
    
    @Autowired
    protected UserServiceInterface userService;
    
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET, produces = "application/json")
    public Greeting findOwner(@PathVariable Long id) {
         return new Greeting(id, "This is Greeting");
    }
    
    /**
     * curl -v -X POST -H "Content-Type: application/json" 'http://localhost:8080/springmvcrest/oauth/token?username=kriss@test.com&password=test&client_id=client1&client_secret=client1&grant_type=password'

        {
                "access_token":"89fda693-ec29-451b-8be0-2b71c7f11999",
                "token_type":"bearer",
                "refresh_token":"2b86f070-ed56-41f4-8d13-faddc104b1bd",
                "expires_in":299880,"scope":"client1"
        }


       curl -v -X GET -H "Authorization:Bearer f8987a33-e15a-407f-b725-886a935d2c15"  'http://localhost:8080/springmvcrest/api/springrest/users'
        
        
       curl -v -X GET -H "Authorization:Bearer 89fda693-ec29-451b-8be0-2b71c7f11999"  "http://localhost:8044/springmvcrest/oauth/logout"
       
     * @return 
     */
    @ResponseBody 
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> findOwner() {
         return userService.getAll();
    }
    
}
