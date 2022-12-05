package com.project.supermarketapp.entities;


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.util.Collection;
//import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Entity
@Table(name ="users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
//public class User implements UserDetails {
    public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


@Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")

    private String last_name;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn( name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;

    public User(String first_name, String last_name, String email, String password, Collection<Role> roles) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.roles = roles;

    }

    public User() {
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public Collection<Role> getRoles() {
        return roles;
    }
//        @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//       List<SimpleGrantedAuthority> authorities  = this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//       return authorities;
//    }
////
//    @Override
//    public String getUsername() {
//        return this.email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
//    @JoinTable(name ="user_role",joinColumns = @JoinColumn(name ="user",referencedColumnName = "id"),
//    inverseJoinColumns = @JoinColumn(name ="role",referencedColumnName = "id"))
//    private Collection<Role> roles  = new HashSet<>();


}
