package com.new_movies.latest_hd_movies.controller;
import com.new_movies.latest_hd_movies.dto.AccessTokenDTO;
import com.new_movies.latest_hd_movies.dto.GithubUser;
import com.new_movies.latest_hd_movies.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.accessid}")
    private String accessid;
    @Value("${github.callbackurl}")
    private String callbackurl;
    @Value("${github.client_secret}")
    private String client_secret;


    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state, HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(accessid);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(callbackurl);
        accessTokenDTO.setClient_secret(client_secret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user != null){
            request.getSession().setAttribute("user",user);
            return "redirect:index";
        }else {
            return "redirect:index";
        }
    }
}
