package com.ensa.gi4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.modele.TypeMateriel;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.api.GestionMaterielServiceFacade;

@Component("facade")
public class GestionMaterielServiceFacadeImpl implements GestionMaterielServiceFacade {
	
	@Autowired
	@Qualifier("livre")
	private GestionMaterielService livreMaterielService;
	@Autowired
	@Qualifier("chaise")
	private GestionMaterielService chaiseMaterielService;

	@Override
	public void ajouterNouveauMateriel(TypeMateriel type, String code) {
		final Materiel materiel;
		final GestionMaterielService serviceActuel;

		switch (type){
		case LIVRE: 
			materiel = new Livre();
			serviceActuel = livreMaterielService;
			break; 
		case CHAISE : 
			materiel = new Chaise();
			serviceActuel = chaiseMaterielService;
			break; 
		default:
			System.out.println("Le type " + type + " n'est pas reconnu");
			return;
		}
		
		materiel.setName(type.toString().toLowerCase());
		materiel.setCode(code);
		serviceActuel.ajouterNouveauMateriel(materiel);
	}

	@Override
	public void afficherMateriel(TypeMateriel type) {
		final GestionMaterielService serviceActuel;
	
		switch (type){
		case LIVRE: 
			serviceActuel = livreMaterielService;
			break; 
		case CHAISE : 
			serviceActuel = chaiseMaterielService;
			break; 
		default:
			System.out.println("Le type " + type + " n'est pas reconnu");
			return;
		}

		 serviceActuel.listerMateriel();
	}

	@Override
	public void chercherMateriel(TypeMateriel type, long id) {
		final GestionMaterielService serviceActuel;
		Materiel materiel; 
		
		
		switch (type){
		case LIVRE: 
			serviceActuel = livreMaterielService;
			break; 
		case CHAISE : 
			serviceActuel = chaiseMaterielService;
			break; 
		default:
			System.out.println("Le type " + type + " n'est pas reconnu");
			return;
		}

		 materiel = serviceActuel.chercherMateriel(id);
		 
		 System.out.println(materiel);
	}

	@Override
	public void modifierMateriel(TypeMateriel type, long id, String code) {
		final GestionMaterielService serviceActuel;
		
		switch (type){
		case LIVRE: 
			serviceActuel = livreMaterielService;
			break; 
		case CHAISE : 
			serviceActuel = chaiseMaterielService;
			break; 
		default:
			System.out.println("Le type " + type + " n'est pas reconnu");
			return;
		}
		
		serviceActuel.modifierMateriel(id, code);
		
		
	}

	@Override
	public void supprimerMateriel(TypeMateriel type, long id) {
		final GestionMaterielService serviceActuel;
	
		switch (type){
		case LIVRE: 
			serviceActuel = livreMaterielService;
			break; 
		case CHAISE : 
			serviceActuel = chaiseMaterielService;
			break; 
		default:
			System.out.println("Le type " + type + " n'est pas reconnu");
			return;
		}
		
		serviceActuel.supprimerMateriel(id);
	}

	@Override
	public void listeMateriels() {
		List<Materiel> materiels = livreMaterielService.listeMateriels(); 
		System.out.println(materiels);
		
	}

	
}
