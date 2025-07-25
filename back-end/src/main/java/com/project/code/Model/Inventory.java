package com.project.code.Model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.*;

@Entity
public class Inventory {
   // 1. Add 'id' field:
//    - Type: private long 
//    - This field will represent the unique identifier for the inventory entry.
//    - Use @Id to mark it as the primary key.
//    - Use @GeneratedValue(strategy = GenerationType.IDENTITY) to auto-increment it.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
// 2. Add 'product' field:
//    - Type: private Product
//    - This field will represent the product associated with the inventory entry.
//    - Use @ManyToOne to establish a many-to-one relationship with the Product entity.
    @ManyToOne
    @JsonBackReference("inventory-product")
    @JoinColumn(name = "product_id")
    private Product product;
// 3. Add 'store' field:
//    - Type: private Store
//    - This field will represent the store where the inventory is located.
//    - Use @ManyToOne to establish a many-to-one relationship with the Store entity.
    @ManyToOne
    @JsonBackReference("inventory-store")
    @JoinColumn(name = "store_id")
    private Store store;
// 4. Add 'stockLevel' field:
//    - Type: private Integer
//    - This field will represent the current stock level of the product at the store.
    private Integer stockLevel;
// 5. Add relationships:
//    - **Product Relationship**: Use @ManyToOne to link this inventory entry to a product.
//    - **Store Relationship**: Use @ManyToOne to link this inventory entry to a store.
//    - Use @JsonBackReference("inventory-product") to prevent circular references during JSON serialization for the product field.
//    - Use @JsonBackReference("inventory-store") to prevent circular references during JSON serialization for the store field.

// 6. Use @JoinColumn for foreign key associations:
//    - For the 'product' field, use @JoinColumn(name = "product_id") to specify the foreign key column.
//    - For the 'store' field, use @JoinColumn(name = "store_id") to specify the foreign key column.

// 7. Create a constructor:
//    - Add a constructor that takes a Product, Store, and Integer stockLevel to initialize the Inventory object.
    public Inventory(Product product, Store store, Integer stockLevel) {
        this.product = product;
        this.store = store;
        this.stockLevel = stockLevel;
    }
// 8. Add @Entity annotation:
//    - Use @Entity above the class definition to mark it as a JPA entity that will be mapped to a database table.

// 9. Add Getters and Setters:
//    - Add getters and setters for 'id', 'product', 'store', and 'stockLevel' fields.
//    - Example: public Long getId(), public void setId(Long id)
//    - Example: public Product getProduct(), public void setProduct(Product product)
//    - Example: public Store getStore(), public void setStore(Store store)
//    - Example: public Integer getStockLevel(), public void setStockLevel(Integer stockLevel)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }
}

