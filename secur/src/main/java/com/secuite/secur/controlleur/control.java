package com.secuite.secur.controlleur;

import com.secuite.secur.modele.role;
import com.secuite.secur.modele.utilisateur;
import com.secuite.secur.service.serv;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class control  {
    @Autowired
    private serv s;


    @GetMapping("/read")
   // @PreAuthorize("hasRole('ADMIN')")
    public List<utilisateur> read(){
        return s.lire();
    }

    @PostMapping("/readl")
   // @PreAuthorize("hasRole('ADMIN')")
    public utilisateur create(@RequestBody utilisateur o){
        return s.ajout(o );
    }
    @GetMapping("/reade")
   // @PreAuthorize("hasRole('USER')")
    public List<role> readd(){
        return s.liree();
    }

    @PostMapping("/creat")
    public role create(@RequestBody String commentaires){
        return s.ajouter(commentaires);
    }
    @GetMapping("/reade/{n}/{o}")
    public String r (@PathVariable String n,@PathVariable String o){
         s.addroleToUser(n,o);
         return "super role ajouté a l'utilisateur avec succes";
    }

    @GetMapping("/reade/{n}")
    public String r (@PathVariable Long n){
        return s.supprimer(n);

    }

}
