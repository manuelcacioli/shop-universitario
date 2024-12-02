package com.example.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "prezzo", precision = 10, scale = 2)
    private BigDecimal prezzo;
    @Column(name = "imageUrl")
    private String imageUrl;
}
