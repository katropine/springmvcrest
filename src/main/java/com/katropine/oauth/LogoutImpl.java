package com.katropine.oauth;

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
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class LogoutImpl implements LogoutSuccessHandler {

    InMemoryTokenStore tokenstore;

    public InMemoryTokenStore getTokenstore() {
        return tokenstore;
    }

    public void setTokenstore(InMemoryTokenStore tokenstore) {
        this.tokenstore = tokenstore;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse,
            Authentication paramAuthentication) throws IOException,
            ServletException {
        removeaccess(paramHttpServletRequest);
        paramHttpServletResponse.getOutputStream().write("\n\tYou Have Logged Out successfully.".getBytes());

    }

    public void removeaccess(HttpServletRequest req) {

        String tokens = req.getHeader("Authorization");
        System.out.println(tokens);
        String value = tokens.substring(tokens.indexOf(" ")).trim();
        DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(value);
        System.out.println(token);
        tokenstore.removeAccessToken(value);
        System.out.println("\n\tAccess Token Removed Successfully!!!!!!!!");

    }

}
