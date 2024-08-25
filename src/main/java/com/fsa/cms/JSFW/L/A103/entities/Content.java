package com.fsa.cms.JSFW.L.A103.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "brief")
    private String brief;
    @Column(name = "content")
    private String contentText;
    @Column(name = "createddate")
    @CreationTimestamp
    private LocalDate createdDate;
    @Column(name = "updatedtime")
    @UpdateTimestamp
    private LocalDate updatedTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Member member;
}
