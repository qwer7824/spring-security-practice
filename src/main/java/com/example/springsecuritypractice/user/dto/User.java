package com.example.springsecuritypractice.user.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "T_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

    @GeneratedValue
    @Id
    private Long id;
    private String username;
    private String password;
    private String authority;

    public User(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.singleton((GrantedAuthority) () -> authority);
    }

    public Boolean isAdmin(){ return authority.equals("ROLE_ADMIN");}

    public boolean isAccountNonExpired(){return true;} // 계정만료

    public boolean isAccountNonLocked(){return true;} // 계정 락

    public boolean isCredentialsNonExpired(){return true;} // 패스워드가 만료가 된게 아닌지

    public boolean isEnabled(){return true;} // 계정이 유효한지




}
