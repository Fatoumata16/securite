package com.secuite.secur.repository;

import com.secuite.secur.modele.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repouser extends JpaRepository<utilisateur, Long> {
    utilisateur findByNom(String nom);
}
