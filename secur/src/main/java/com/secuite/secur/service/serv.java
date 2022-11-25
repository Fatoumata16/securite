package com.secuite.secur.service;

import com.secuite.secur.modele.role;
import com.secuite.secur.modele.utilisateur;
import com.secuite.secur.repository.reporole;
import com.secuite.secur.repository.repouser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional

public class serv {
    @Autowired
    private final repouser repocolaborateu;
    @Autowired
    private final reporole ro;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public utilisateur ajout(utilisateur u){
        // collaborateur u=new collaborateur(nom,mot,null);
        // utilisateur co=new utilisateur(null,nom,mot,new ArrayList<>());
         String a=u.getMot2passe();
          u.setMot2passe(passwordEncoder.encode(a));
         return repocolaborateu.save(u);
    }
    public role ajouter(String nom){
         role r= new role(null,nom);
        return ro.save(r);
    }
    public List<utilisateur> lire() { // on retourne repository.la méthode(findAll) pour afficher tous les commentaires;
        return repocolaborateu.findAll();
    }
    public List<role> liree() { // on retourne repository.la méthode(findAll) pour afficher tous les commentaires;
        return ro.findAll();
    }
    public void addroleToUser(String username,String rolenom){
        utilisateur col=repocolaborateu.findByNom(username);
        role r=ro.findByRolename(rolenom);
        col.getRoles().add( r);
        //col.setR((List<role>) r);
    }
    public String supprimer(Long idSolutions) {
        repocolaborateu.deleteById(idSolutions);
        return "Solution Supprimer !";
    }
    public utilisateur loadUserByName(String nom){
        return repocolaborateu.findByNom(nom);
    }

}
