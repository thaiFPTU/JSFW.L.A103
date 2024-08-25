package com.fsa.cms.JSFW.L.A103.entities;

import com.fsa.cms.JSFW.L.A103.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(nullable = false,name = "username")
    private String username;
    @Column(nullable = false,name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(unique = true,nullable = false,name = "email")
    private String email;
    @Column(name = "description")
    private String Description;
    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDate CreatedDate;
    @UpdateTimestamp
    @Column(name = "updateddate")
    private LocalDate UpdatedDate;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Content> contents;
}
