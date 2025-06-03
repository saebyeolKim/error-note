package com.project.ErrorNote.domain.errorlog;

import com.project.ErrorNote.domain.category.Category;
import com.project.ErrorNote.domain.user.Users;
import com.project.ErrorNote.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "ErrorLogs")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Comment("오류 내용과 해결 과정이 담긴 게시글")
public class ErrorLogs extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "errorLogId", nullable = false, updatable = false)
    private Integer errorLogId;

    @Comment("회원")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    @Comment("카테고리")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @Comment("제목")
    @Column(length = 100, nullable = false)
    private String title;

    @Comment("내용")
    @Column(nullable = false)
    private String content;
}
