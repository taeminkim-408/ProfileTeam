package org.example.domain;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cId;
    @Nullable
    private String cName;
    @Column(nullable = false)
    private String cComment;
    @Nullable
    private String c_Image;

    @Column(name = "regDate", nullable = false, updatable = false)
    private LocalDateTime regDate;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @PrePersist
    protected void onCreate() {
        this.regDate = LocalDateTime.now();
    }
}