package com.example.grep.interfaces;

import com.example.grep.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarios extends JpaRepository<Usuarios, Integer> {
}