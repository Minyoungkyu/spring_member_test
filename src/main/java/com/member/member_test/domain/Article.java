package com.member.member_test.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    @NonNull
    private Long userId;

    @NonNull
    private String title;

    @NonNull
    private String body;

    @OneToOne
    @JoinColumn(name = "member_loginId")
    private Member loginId;


}
