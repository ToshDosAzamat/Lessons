package com.example.authorizationserverservicespringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@NoArgsConstructor
@Table(name= "AUTHORITIES")
@Getter
@Setter
public class Authority implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String name;


  @Override
  public String getAuthority() {
    return this.name;
  }
}