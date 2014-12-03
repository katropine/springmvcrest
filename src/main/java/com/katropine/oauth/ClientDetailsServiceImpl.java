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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws OAuth2Exception {
        
        /**
         * Request access
         * curl -v -X GET -H "Content-Type: application/json" 'http://localhost:8080/springmvcrest/oauth/token?username=user1&password=user1&client_id=client1&client_secret=client1&grant_type=password'\
         * 
         * Request To access protected resource getMyInfo:
         * curl -H "Authorization:Bearer 6fd0f4b7-ca03-49ff-ae46-eea5e6929325"  "http://localhost:8080/springmvcrest/api/getMyInfo"
         * 
         * Request To logout
         * curl -H "Authorization:Bearer 6fd0f4b7-ca03-49ff-ae46-eea5e6929325"  "http://localhost:8080/springmvcrest/api/logou"
         * 
         */
        System.out.println("client: "+clientId);
        if(clientId.equals("client1")) {
            System.out.println("In client: "+clientId);
            
            List<String> authorizedGrantTypes = new ArrayList<>();
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            authorizedGrantTypes.add("client_credentials");
            
            Collection<String> col = new ArrayList<>();
            col.add("client1");
            
            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId("client1");
            clientDetails.setClientSecret("client1");
            clientDetails.setScope(col);
            clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);

            return clientDetails;

        } else if (clientId.equals("client2")) {
            System.out.println("In client: "+clientId);
            
            List<String> authorizedGrantTypes = new ArrayList<>();
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            authorizedGrantTypes.add("client_credentials");

            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId("client2");
            clientDetails.setClientSecret("client2");
            clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);

            return clientDetails;
        } else {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
    }

}
