package com.huntercodexs.oauth2clientdemo.config.oauth2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "oauth2_client")
public class Oauth2ClientEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String clientId;

    @Column
    private String clientSecret;

    @Column
    private String grantType;

    @Column
    private String urlToken;

    @Column
    private String urlCheckToken;

    @Column
    private int status;

}
