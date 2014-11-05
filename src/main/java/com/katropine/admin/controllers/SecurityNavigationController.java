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
package com.katropine.admin.controllers;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityNavigationController {
    
    @RequestMapping(value={"/", "/login"}, method=RequestMethod.GET )
    public String loginForm(Model model) {
        model.addAttribute("message", "This is a message from the controller");
        return "login";
    } 
     
    @RequestMapping(value="/error-login", method=RequestMethod.GET)
    public String invalidLogin(Model model) {
        model.addAttribute("message", "Wrong Username/Password combination");
        return "login";
    }
     
    @RequestMapping(value="/success-login", method=RequestMethod.GET)
    public String successLogin(Model model, Principal principal) {
        // Principal principal
        String name = "";
        name = principal.getName(); //get logged in username
        return "redirect:admin/springmvc/greeting/"+name;
    }
}