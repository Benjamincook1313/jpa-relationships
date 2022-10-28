package com.example.jparelationships.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private Long id;

  @Column(nullable = false)
  private String title;

  private Long isbn;
  private Integer totalPages;
  private Double rating;
  private Date publishedDate;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "photo_id")
  private Photo photo;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "books_categories",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Collection<Category> categories;

  @ManyToMany(mappedBy = "author")
  private Collection<Author> author;
}