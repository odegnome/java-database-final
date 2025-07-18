package com.project.code.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.project.code.Model.Store;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
// 1. Add the repository interface:
//    - Extend JpaRepository<Store, Long> to inherit basic CRUD functionality.
//    - This allows the repository to perform operations like save, delete, update, and find without having to implement these methods manually.

// Example: public interface StoreRepository extends JpaRepository<Store, Long> {}

// 2. Add custom query methods:
//    - **findById**:
//      - This method will retrieve a store by its ID.
//      - Return type: Store
//      - Parameter: Long id
    Store findByid(Long id);
// Example: public Store findById(Long id);

//    - **findBySubName**:
//      - This method will retrieve stores whose name contains a given substring.
//      - Return type: List<Store>
//      - Parameter: String pname
//      - Use @Query annotation to write a custom query.
    
    @Query("SELECT s FROM Store s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%',:pname,'%'))")
    List<Store> findBySubName(String pname);
}
