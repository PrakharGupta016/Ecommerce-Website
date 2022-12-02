package com.project.supermarketapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoryId;
  @Column(name="title",length=100,nullable = false)
  private String categoryTitle;
  @Column(name="description")
  private String categoryDescription;

  public String getCategoryTitle() {
    return categoryTitle;
  }

  public void setCategoryTitle(String categoryTitle) {
    this.categoryTitle = categoryTitle;
  }

  public String getCategoryDescription() {
    return categoryDescription;
  }

  public void setCategoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
  }
}
