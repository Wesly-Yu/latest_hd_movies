package com.new_movies.latest_hd_movies.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    //用户id
    private Integer id;
    //用户名称
    private String name;
    //用户帐户id
    private String accountId;
    //用户的token
    private String token;
    //创建时间
    private Long gmtCreate;
    //修改时间
    private Long gmtModified;
}
