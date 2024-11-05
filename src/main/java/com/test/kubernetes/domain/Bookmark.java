package com.test.kubernetes.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "bookmarks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {

    @Id
    @SequenceGenerator(name = "bookmark_id_generator", sequenceName = "bookmark_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookmark_id_generator")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    private Instant createdAt;
}
