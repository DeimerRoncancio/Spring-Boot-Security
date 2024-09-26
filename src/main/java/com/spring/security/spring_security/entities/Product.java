package com.spring.security.spring_security.entities;

import com.spring.security.spring_security.validation.IsExistDb;
import com.spring.security.spring_security.validation.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Revisión 1 - @Valid y BindingErrors
    /*
     * Aquí hay varios ejemplos de notaciones que nos servirán para los diferentes errores dispobibles.
     */
    // Nota 1
    /*
     * Hay dos notaciones para validar si un campo de text esta vacio. Esta "@NotEmpty", y también
     * "@NotBlank". La diferencia es que "@NotBlank" valida incluso espacios en blanco.
     */
    // @NotBlank(message = "{NotBlank.product.name}")
    // @Size(min=5, max=500, message = "{Size.product.name}")
    private String name;

    @NotNull(message = "{NotNull.product.price}")
    @Min(value = 500, message = "{Min.product.price}")
    private Integer price;

    // @NotBlank(message = "{NotBlank.product.description}")
    @IsRequired(message = "es requerido! (usando anotaciones)")
    private String description;

    @IsRequired
    @IsExistDb
    private String sku;

    public Product() {
    }

    public Product(String name, Integer price, String description, String sku) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.sku = sku;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
