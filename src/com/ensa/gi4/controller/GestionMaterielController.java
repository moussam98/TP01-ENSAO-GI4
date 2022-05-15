package com.ensa.gi4.controller;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ensa.gi4.modele.TypeMateriel;
import com.ensa.gi4.service.api.GestionMaterielServiceFacade;

@Component("controllerPricipal")
public class GestionMaterielController {

	@Autowired
    @Qualifier("facade")
    private GestionMaterielServiceFacade gestionMaterielServiceFacade;

	
	public void afficherMenu() {
        System.out.println("1- AJOUTER");
        System.out.println("2- AFFICHER");
        System.out.println("3- MODIFIER");
        System.out.println("4- SUPPRIMER");
        System.out.println("5- CHERCHER");
        System.out.println("6- AFFICHER LA LISTE DE TOUS LES MATERIELS ");
        System.out.println("0- pour sortir de l'application, entrer 0");
        
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.next();
        String mat;
        switch(operation) {
        
        case "0":
        	sortirDeLApplication();
        	break;
        case "1":
        	System.out.print("1-pour livre \t 2-pour chaise : ");
            mat = scanner.next();
            Optional<String> checkType = Optional.of(mat); 
            
            if (checkType.isPresent()) {

                	System.out.print("Saisir le code  : ");
                    String code = scanner.next(); 
                    Optional<String> checkMaterialCode = Optional.of(code); 
                    
                    if (checkMaterialCode.isPresent()) {

                    	if(checkType.get().equals("1")) {
                        	gestionMaterielServiceFacade.ajouterNouveauMateriel(TypeMateriel.LIVRE, checkMaterialCode.get());
                        }
                    	else if(checkType.get().equals("2")) {
                        	gestionMaterielServiceFacade.ajouterNouveauMateriel(TypeMateriel.CHAISE, checkMaterialCode.get());
                        }
                    	else {
        					System.out.println("Le type " + mat + " n'est pas reconnu ");
        				}
					}
                    else {
						System.out.println("Code du materiel invalide, ajout non effectu�");
					}
                    
			}else {
				System.out.println("Choix invalide ! ");
			}
            break;
        case "2":
        	System.out.print("1-pour livre \t 2-pour chaise : ");
            mat = scanner.next();
            Optional<String> checkType1 = Optional.of(mat); 
            
            if (checkType1.isPresent()) {
    
            	if(checkType1.get().equals("1")) {
                 	gestionMaterielServiceFacade.afficherMateriel(TypeMateriel.LIVRE);
                 }
            	else if(checkType1.get().equals("2")) {
                 	gestionMaterielServiceFacade.afficherMateriel(TypeMateriel.CHAISE);
                 }
            	else {
                	 System.out.println("Le type " + checkType1.get() + " n'est pas reconnu ");
				}
			}else {
				System.out.println("Choix invalide ! ");
			}
            break;
        case "3":
        	System.out.print("1-pour livre \t 2-pour chaise : ");
            mat = scanner.next();
            Optional<String> checkType3 = Optional.of(mat); 
            
            if (checkType3.isPresent()) {
            	
            	System.out.print("Saisir ID du materiel à modifier : ");
                Integer id = scanner.nextInt(); 
                Optional<Integer> checkMaterialId = Optional.of(id); 
                
                System.out.print("Saisir le nouveau code du materiel : ");
                String code = scanner.next(); 
                Optional<String> checkMaterialCode = Optional.of(code); 
                
                if (checkMaterialId.isPresent()) {
                	
                	if (checkMaterialCode.isPresent()) {
                		if(checkType3.get().equals("1")) {
                        	gestionMaterielServiceFacade.modifierMateriel(TypeMateriel.LIVRE, id, code);
                        }
                    	else if(checkType3.get().equals("2")) {
                        	gestionMaterielServiceFacade.modifierMateriel(TypeMateriel.CHAISE, id, code);
                        }
                    	else {
        					System.out.println("Le type " + mat + " n'est pas reconnu ");
        				}
					}

				}
                else {
					System.out.println("Id du materiel invalide, modification non effectuée");
				}
			}else {
				System.out.println("Choix invalide ! ");
			}
            break;
        case "4":
        	System.out.print("1-pour livre \t 2-pour chaise : ");
            mat = scanner.next();
            Optional<String> checkType4 = Optional.of(mat); 
            
            if (checkType4.isPresent()) {
            	
            	System.out.print("Saisir ID du materiel à supprimer : ");
                Integer id = scanner.nextInt(); 
                Optional<Integer> checkMaterialId = Optional.of(id); 
                
                if (checkMaterialId.isPresent()) {

                	if(checkType4.get().equals("1")) {
                    	gestionMaterielServiceFacade.supprimerMateriel(TypeMateriel.LIVRE, id);
                    }
                	else if(checkType4.get().equals("2")) {
                    	gestionMaterielServiceFacade.supprimerMateriel(TypeMateriel.CHAISE, id);
                    }
                	else {
    					System.out.println("Le type " + mat + " n'est pas reconnu ");
    				}
				}
                else {
					System.out.println("Id du materiel invalide, Suppression non effectuée");
				}
			}else {
				System.out.println("Choix invalide ! ");
			}
            break;
        case "6":
        	gestionMaterielServiceFacade.listeMateriels();
            break;   
         
        case "5":
        	System.out.print("1-pour livre \t 2-pour chaise : ");
            mat = scanner.next();
            Optional<String> checkType5 = Optional.of(mat); 
            
            if (checkType5.isPresent()) {
            	
            	System.out.print("Saisir ID du materiel à chercher : ");
                Integer id = scanner.nextInt(); 
                Optional<Integer> checkMaterialCode = Optional.of(id); 
                
                if (checkMaterialCode.isPresent()) {

                	if(checkType5.get().equals("1")) {
                    	gestionMaterielServiceFacade.chercherMateriel(TypeMateriel.LIVRE, id);;
                    }
                	else if(checkType5.get().equals("2")) {
                    	gestionMaterielServiceFacade.chercherMateriel(TypeMateriel.CHAISE, id);;
                    }
                	else {
    					System.out.println("Le type " + mat + " n'est pas reconnu ");
    				}
				}
                else {
					System.out.println("Code du materiel invalide, recherche non effectuée");
				}
			}else {
				System.out.println("Choix invalide ! ");
			}
            break;
        default:
        	System.out.println("choix invalide");
        	break;
        }  
    }

    private void sortirDeLApplication() {
    	System.out.println("Fin du programme ! ");
        System.exit(0);
    }

}
