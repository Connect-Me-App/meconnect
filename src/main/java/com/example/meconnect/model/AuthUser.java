package com.example.meconnect.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AuthUser {
    private static final long serialVersionId = 1L;
    @Id
    private String authToken;
    private Long id;
    private String userName;
    private List<GrantedAuthority> roles;
}
