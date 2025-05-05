package com.codeid.eshopper.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categories", schema = "oe")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name", nullable = false, length = 100)
    private String name;


    public Category() {

    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    // @Override
    // public String toString() {
    //     return "Category{id=" + id + ", name='" + name + "'}";
    // }

    // // equals and hashCode (opsional tapi baik untuk koleksi)
    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (!(o instanceof Category)) return false;
    //     Category category = (Category) o;
    //     return id != null && id.equals(category.id);
    // }

    // @Override
    // public int hashCode() {
    //     return getClass().hashCode();
    // }
}
