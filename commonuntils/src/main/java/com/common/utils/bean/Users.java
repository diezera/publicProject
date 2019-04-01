package com.common.utils.bean;

import com.common.utils.util.ShuaigeCheng;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import javax.persistence.Id;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {
    @Id
    @ShuaigeCheng(level = 1)
    private Integer userId;
    @ShuaigeCheng(level = 2)
    private String phoneNumber;
    @ShuaigeCheng(level = 3)
    private String username;
    private boolean maillistVerified;
}
