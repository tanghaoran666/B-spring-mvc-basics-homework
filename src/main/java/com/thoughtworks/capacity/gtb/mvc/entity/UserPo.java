package com.thoughtworks.capacity.gtb.mvc.entity;

import lombok.Builder;

@Builder
public class UserPo {
    private int id;
    private String username;
    private String password;
    private String email;
}
