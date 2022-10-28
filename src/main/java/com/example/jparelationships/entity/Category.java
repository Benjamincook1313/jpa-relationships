package com.example.jparelationships.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private Long id;

  @Column(nullable = false)
  private String category;

  @Column(nullable = false)
  private Long parentId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "parent_id")
  private Category parent;

  @OneToMany(mappedBy = "parent")
  private Collection<Category> children;

  @ManyToMany(mappedBy = "books")
  private Collection<Book> books;
}
