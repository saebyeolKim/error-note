package com.project.ErrorNote.domain.tag;

import com.project.ErrorNote.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "Tags")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Comment("오류 분류용 태그 #JPA, #NPE 등")
public class Tags extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagId", nullable = false, updatable = false)
    private Long tagId;

    @Comment("태그명")
    @Column(length = 20, nullable = false)
    private String name;
}
