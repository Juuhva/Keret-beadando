package com.aqamh4.beadando.keret.service.Rendeles;

import com.aqamh4.beadando.keret.entity.Rendeles;
import com.aqamh4.beadando.keret.entity.RendelesTetel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendelesRepository extends JpaRepository<Rendeles, Integer> {
    @Query("SELECT rt FROM RendelesTetel rt WHERE rt.rendeles.id = :id")
    List<RendelesTetel> findOrderById(@Param("id") int id);


    @Query("SELECT r FROM Rendeles r WHERE r.user.id = :userId")
    List<Rendeles> findOrderByUserId(@Param("userId") int userId);
}
