package com.shopping.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author devagoud
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rest_uri")
public class RestUri {
    @Id
    private String uriId = UUID.randomUUID().toString();

    private String uri;
    private boolean preLogin;
    @Column(name = "http_method")
    @Enumerated(EnumType.STRING)
    private HttpMethod httpMethod;

    public RestUri(String uri, boolean preLogin, HttpMethod httpMethod) {
        this.uri = uri;
        this.preLogin = preLogin;
        this.httpMethod = httpMethod;
    }
}
