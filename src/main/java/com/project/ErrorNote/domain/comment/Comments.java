package com.project.ErrorNote.domain.comment;

import com.project.ErrorNote.domain.errorlog.ErrorLogs;
import com.project.ErrorNote.domain.user.Users;
import com.project.ErrorNote.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "Comments")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Comment("오류에 대한 회고나 메모")
public class Comments extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId", nullable = false, updatable = false)
    private Long commentId;

    @Comment("회원")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    @Comment("오류게시글")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "errorLogId", nullable = false)
    private ErrorLogs errorLog;
}
