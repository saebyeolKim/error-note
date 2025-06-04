package com.project.ErrorNote.domain.category;

import com.project.ErrorNote.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "Category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Comment("카테고리")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId", nullable = false, updatable = false)
    private Long categoryId;

    @Comment("카테고리명")
    @Column(length = 100, nullable = false)
    private String name;
}
