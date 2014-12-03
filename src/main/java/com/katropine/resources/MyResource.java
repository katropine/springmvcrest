/**
* @package Restful - katropine
* @author Kristian Beres <kristian@katropine.com>
* @copyright Katropine (c) 2014, www.katropine.com
* @since Nov 6, 2014
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
package com.katropine.resources;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
@Component 
public class MyResource {

	@RequestMapping(value="/info", method = RequestMethod.GET, produces = "application/json")
	public String createInfo(){
		return "\n\n\t!!!Protected Resource(createInfo) Accessed !!!! Returning from Myresource createInfo\n";

	}

	@RequestMapping(value="/getMyInfo",method = RequestMethod.GET, produces = "application/json")
	public String getMyInfo(){
		
		return "\n\n\t Protected Resource(getMyInfo) Accessed !!!! Returning from Myresource getMyInfo\n";
	}

	@RequestMapping(value="/updateInfo",method = RequestMethod.GET, produces = "application/json")
	public String updateMyInfo(){
		return "\n\n\t Protected Resource(updateInfo) Accessed !!!! Returning from Myresource updateInfo\n";
		
	}

}
