package com.iia.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.iia.shop.entity.Vehicule;

public class VehiculeDAO implements iDAO<Vehicule>{
	
	private static final String MARQUE = "marque";
	private static final String YEAR = "year";
	private static final String SPEED = "speed";
	private static final String MODEL = "model";
	private static final String COLOR = "color";
	private static final String PRICE = "price";
	private static final String ID = "id";
	private static final String TABLENAME = "Client";

	@Override
	public boolean create(Vehicule object) {
		String req = "INSERT INTO " + VehiculeDAO.TABLENAME
				+ " (" + VehiculeDAO.MARQUE + ", " + VehiculeDAO.YEAR
				+ ", " + VehiculeDAO.SPEED + ", " + VehiculeDAO.MODEL
				+ ", " + VehiculeDAO.COLOR + ", " + VehiculeDAO.PRICE +")"
				+ " VALUES ('"
				+ ((Vehicule)object).getMarque()+ "','" + ((Vehicule)object).getYear()
				+ ((Vehicule)object).getSpeed()+ "','" + ((Vehicule)object).getModel()
				+ ((Vehicule)object).getColor()+ "','" + ((Vehicule)object).getPrice()+
				"')"; 
		
		try {
			Statement st = Connexion.getConnection().createStatement();
			if (st.executeUpdate(req) == 1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("erreur lors de l'insertion du client");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Vehicule object) {
		String req = "UPDATE " + VehiculeDAO.TABLENAME + " SET "
					+ VehiculeDAO.MARQUE  + "='" + object.getMarque() + "', "
					+ VehiculeDAO.YEAR + "= '" + object.getYear() 
					+ VehiculeDAO.SPEED  + "='" + object.getSpeed() + "', "
					+ VehiculeDAO.MODEL  + "='" + object.getModel() + "', "
					+ VehiculeDAO.COLOR  + "='" + object.getColor() + "', "
					+ VehiculeDAO.PRICE  + "='" + object.getPrice() + "', "
						+ "' WHERE " + VehiculeDAO.ID + "=" + object.getId();
				
				try {
					Statement st = Connexion.getConnection().createStatement();
					if (st.executeUpdate(req) > 1){
						return true;
					}
				} catch (SQLException e) {
				System.out.println("erreur lors de la mise à jour du client");
				}
				return false;
	}

	@Override
	public boolean delete(Vehicule object) {
		String req = "DELETE FROM " + VehiculeDAO.TABLENAME + " WHERE id= " + ((Vehicule)object).getId();
		
		try {
			Statement st = Connexion.getConnection().createStatement();
			
			if(st.executeUpdate(req) >= 1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("erreur lors de la suppression du client");
			
		}
		
		return false;
	}

	@Override
	public Vehicule findById(int id) {
		String req = " SELECT * FROM "+ VehiculeDAO.TABLENAME 
		+" WHERE "+ VehiculeDAO.ID +" = "+ id;
		Statement st;
		try {
			st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			
			if(rs.next()){
				Vehicule vehicule = new Vehicule();
				vehicule.setId(rs.getInt(VehiculeDAO.ID));
				vehicule.setMarque(rs.getString(VehiculeDAO.MARQUE));
				vehicule.setYear(rs.getInt(VehiculeDAO.YEAR));
				vehicule.setSpeed(rs.getInt(VehiculeDAO.SPEED));
				vehicule.setModel(rs.getString(VehiculeDAO.MODEL));
				vehicule.setColor(rs.getString(VehiculeDAO.COLOR));
				vehicule.setPrice(rs.getDouble(VehiculeDAO.PRICE));
				
				return vehicule;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Vehicule> findAll() {
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		
		try {	String req = String.format("SELECT * FROM %s", VehiculeDAO.TABLENAME );
			
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			
			while(rs.next()){
				vehicules.add(this.cursorToVehicule(rs));
			}
			return vehicules;
			}
		catch (SQLException e) {
			System.out.println("");
		}
			
			return null;
	}
	
	private Vehicule cursorToVehicule(ResultSet resultSet){
		Vehicule vehicule = null;
		try{
			vehicule = new Vehicule();
			vehicule.setId(resultSet.getInt(VehiculeDAO.ID));
			vehicule.setMarque(resultSet.getString(VehiculeDAO.MARQUE));
			vehicule.setYear(resultSet.getInt(VehiculeDAO.YEAR));
			vehicule.setSpeed(resultSet.getInt(VehiculeDAO.SPEED));
			vehicule.setModel(resultSet.getString(VehiculeDAO.MODEL));
			vehicule.setColor(resultSet.getString(VehiculeDAO.COLOR));
			vehicule.setPrice(resultSet.getDouble(VehiculeDAO.PRICE));
		}
		catch ( SQLException e){
			System.out.println("erreur lors de la recupération du client");
		}
		return vehicule;
	}

	
}
