package com.shopping.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author devagoud
 */
@Data
@Entity
@Table(name = "policy")
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    @Id
    private String policyId = UUID.randomUUID().toString();
    @Column(name = "policy")
    private String policy;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "uri_id")
    private RestUri restUri;

    public Policy(String id, String policy) {
        this.policyId = id;
        this.policy = policy;
    }

    public Policy(String policy, RestUri restUri){
        this.policy = policy;
        this.restUri = restUri;
    }
}

