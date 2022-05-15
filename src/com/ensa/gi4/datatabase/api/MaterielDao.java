package com.ensa.gi4.datatabase.api;

import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.modele.TypeMateriel;

import java.util.List;

public interface MaterielDao {
    List<Materiel> findAll();

    Materiel findOne(long id);
    // compléter par les autres méthodes
    
    int add(Materiel materiel);
    List<Materiel> listMaterialByType(TypeMateriel typeMateriel);  
    int updateMaterial(long id, String code); 
    int deleteMaterial(long id ); 
}
