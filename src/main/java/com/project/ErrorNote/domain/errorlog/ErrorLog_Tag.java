package com.project.ErrorNote.domain.errorlog;

import com.project.ErrorNote.domain.tag.Tags;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "ErrorLog_Tag")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Comment("ErrorLog와 Tag의 중간 테이블")
@IdClass(ErrorLogTagId.class)
public class ErrorLog_Tag {

    @Id
    @Comment("오류게시글")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "errorLogId", nullable = false)
    private ErrorLogs errorLog;

    @Id
    @Comment("태그")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tagId", nullable = false)
    private Tags tag;
}
