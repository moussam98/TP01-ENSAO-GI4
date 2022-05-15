package com.ensa.gi4.datatabase.impl;

import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.modele.TypeMateriel;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterielDaoImpl extends GenericDAO<Materiel> implements MaterielDao {
    @Override
    public List<Materiel> findAll() {
        return super.findAll("SELECT * FROM MATERIEL" );
    }

    @Override
    public Materiel findOne(long id) {
        return super.findOne("SELECT * FROM MATERIEL WHERE ID=?;", id);
    }

    @Override
    protected MaterielRowMapper getRowMapper() { // template method design pattern
        return new MaterielRowMapper();
    }

	@Override
	public int add(Materiel materiel) {
		return super.add("INSERT INTO  MATERIEL (NAME, CODE) VALUES (?,?)", materiel); 
		
	}

	@Override
	public List<Materiel> listMaterialByType(TypeMateriel typeMateriel) {
		String query = "SELECT * FROM MATERIEL WHERE NAME = ? ;";
		switch (typeMateriel) {
		case CHAISE:
			return super.listMaterialByType(query, typeMateriel.CHAISE); 
		case LIVRE: 
			return super.listMaterialByType(query, typeMateriel.LIVRE);
		default:
			break;
		}
		return null;
	}

	@Override
	public int updateMaterial(long id, String code) {
		String query = "UPDATE MATERIEL SET CODE = ? WHERE ID  = ? ; "; 
		return super.updateMaterial(query, code, id); 
	}

	@Override
	public int deleteMaterial(long id) {
		String query = "DELETE MATERIEL WHERE ID = ? ;"; 
		return super.deleteMaterial(query, id); 
	}

}
