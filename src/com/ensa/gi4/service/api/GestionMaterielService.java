package com.ensa.gi4.service.api;

import java.util.List;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void supprimerMateriel(long id);
    Materiel chercherMateriel(long id);
    void modifierMateriel(long id, String code);
    List<Materiel> listeMateriels(); 
}
