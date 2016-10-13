package com.iia.shop;

import java.util.List;
import java.util.Scanner;

import com.iia.shop.dao.VehiculeDAO;
import com.iia.shop.dao.Connexion;
import com.iia.shop.entity.Vehicule;


import com.iia.shop.entity.Vehicule;

public class Store {

	private static Scanner sc;

	public static void main(String[] args) {
		
		VehiculeDAO vDao = new VehiculeDAO();
		
		boolean result;
			
		System.out.println("Gestion des véhicules");
		System.out.println("1 - créer un véhicule");
		System.out.println("2 - mettre à jour un véhicule");
		System.out.println("3 - voir tous les véhicules");
		System.out.println("4 - sélectionner un véhicule");
		System.out.println("5 - supprimer un véhicule");
		
		sc = new Scanner(System.in);
		
		System.out.println("Votre choix");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			Vehicule newVehicule = new Vehicule();
			int ajoutint;
			String ajoutstring;
			double ajoutdouble;
			
			
			System.out.println("Rentrez la Marque : ");
			ajoutstring = sc.nextLine();
			newVehicule.setMarque(ajoutstring);
			
			
			System.out.println("Rentrez l'Année :");
			ajoutint = sc.nextInt();
			newVehicule.setYear(ajoutint);
			
			System.out.println("Rentrez la Vitesse :");
			ajoutint = sc.nextInt();
			newVehicule.setSpeed(ajoutint);
			
			System.out.println("Rentrez le Modele : ");
			ajoutstring = sc.nextLine();
			newVehicule.setMarque(ajoutstring);
			
			System.out.println("Rentrez la Couleur : ");
			ajoutstring = sc.nextLine();
			newVehicule.setColor(ajoutstring);
			
			System.out.println("Rentrez le Prix :");
			ajoutdouble = sc.nextDouble();
			newVehicule.setPrice(ajoutdouble);
			
			
			result = vDao.create(newVehicule);
			
			Connexion.close();
			break;
		case 2:
			System.out.println("Votre choix");
			int choixvehicule = sc.nextInt();
			Vehicule vehiculesupprupd = (Vehicule)vDao.findById(choixvehicule);
			result = vDao.delete(vehiculesupprupd);
			
			Vehicule updVehicule = new Vehicule();
			int ajoutintupd;
			String ajoutstringupd;
			double ajoutdoubleupd;
			
			
			System.out.println("Rentrez la Marque : ");
			ajoutstringupd = sc.nextLine();
			updVehicule.setMarque(ajoutstringupd);
			
			
			System.out.println("Rentrez l'Année :");
			ajoutintupd = sc.nextInt();
			updVehicule.setYear(ajoutintupd);
			
			System.out.println("Rentrez la Vitesse :");
			ajoutintupd = sc.nextInt();
			updVehicule.setSpeed(ajoutintupd);
			
			System.out.println("Rentrez le Modele : ");
			ajoutstringupd = sc.nextLine();
			updVehicule.setMarque(ajoutstringupd);
			
			System.out.println("Rentrez la Couleur : ");
			ajoutstringupd = sc.nextLine();
			updVehicule.setColor(ajoutstringupd);
			
			System.out.println("Rentrez le Prix :");
			ajoutdoubleupd = sc.nextDouble();
			updVehicule.setPrice(ajoutdoubleupd);
			
			
			result = vDao.create(updVehicule);
			
			Connexion.close();
			break;
		case 3:
			List<Vehicule> vehicules = vDao.findAll();
			for(Vehicule vehicule2 : vehicules){
				System.out.println(vehicule2.getMarque());
			}
			Connexion.close();
			break;
			
		case 4:
			System.out.println("Votre choix");
			int findid = sc.nextInt();
			Vehicule vehicule = (Vehicule)vDao.findById(findid);
			System.out.println(vehicule.getMarque());
			Connexion.close();
			break;
			
		case 5:
			System.out.println("Votre choix");
			int choix = sc.nextInt();
			Vehicule vehiculesuppr = (Vehicule)vDao.findById(choix);
			result = vDao.delete(vehiculesuppr);
			Connexion.close();
			break;
		default:
			break;
		}

	}

	
}
