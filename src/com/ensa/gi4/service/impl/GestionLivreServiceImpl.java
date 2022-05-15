package com.ensa.gi4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.listeners.MyEvent;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.modele.TypeMateriel;
import com.ensa.gi4.service.api.GestionMaterielService;

@Service("livre")
public class GestionLivreServiceImpl implements GestionMaterielService {
	@Autowired
	ApplicationPublisher publisher; 
	
	@Autowired
	MaterielDao materielDao;
    

	@Override
	public void listerMateriel() {
		if(materielDao.listMaterialByType(TypeMateriel.LIVRE).isEmpty())
			System.out.println("Aucun livre ajout� ! ");
		else {
			System.out.println(materielDao.listMaterialByType(TypeMateriel.LIVRE));
		}
	}

	@Override
	public void ajouterNouveauMateriel(Materiel materiel) {
		if(materielDao.add(materiel) == 1 )
			publisher.publish(new MyEvent<Materiel>(materiel, EventType.ADD));
	}

	@Override
	public void supprimerMateriel(long id) {
		Materiel materiel = chercherMateriel(id); 
		if (materielDao.deleteMaterial(id) == 1)
			publisher.publish(new MyEvent<Materiel>(materiel, EventType.REMOVE));
	}

	@Override
	public Materiel chercherMateriel(long id) {
		return materielDao.findOne(id ); 
	}


	@Override
	public void modifierMateriel(long id, String code) {
		materielDao.updateMaterial(id, code);
			Materiel materiel = chercherMateriel(id); 
			publisher.publish(new MyEvent<Materiel>(materiel, EventType.UPDATE));
		
	}

	@Override
	public List<Materiel> listeMateriels() {
		return materielDao.findAll(); 
	}
}
