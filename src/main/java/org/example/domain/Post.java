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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String postText;
    @Column(nullable = false)
    private long postLike;

    @Nullable
    private String postImage;

    @Column(name = "regDate", nullable = false, updatable = false)
    private LocalDateTime regDate;

    @Column(name = "modDate")
    private LocalDateTime modDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @PrePersist
    protected void onCreate() {
        this.regDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.modDate = LocalDateTime.now();
    }

}