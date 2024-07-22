package com.example.authorizationserverservicespringboot.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name="USERS")
@Data
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Collection<Authority> authorities;
    private Boolean isAccountExpired = false;
    private Boolean isAccountLocked = false;
    private Boolean isCredentialsExpired = false;
    private Boolean isEnabled = true;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isAccountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isCredentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

}
