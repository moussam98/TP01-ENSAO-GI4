package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.TypeMateriel;

public interface GestionMaterielServiceFacade {

	void afficherMateriel(TypeMateriel type);
	void ajouterNouveauMateriel(TypeMateriel type, String code);
	void chercherMateriel(TypeMateriel type, long id); 
	void modifierMateriel(TypeMateriel typeMateriel,  long id, String code); 
	void supprimerMateriel(TypeMateriel typeMateriel, long id);
	void listeMateriels(); 
}
