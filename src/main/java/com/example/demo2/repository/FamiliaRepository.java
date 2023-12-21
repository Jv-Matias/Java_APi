package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo2.model.Familia;
import java.util.List;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    List<Familia> findByMercadorias_Id(Long mercadoriaId);
}
