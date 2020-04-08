package fr.carboat.services;

import fr.carboat.models.Vehicle;

public interface QuotationService {
	
	/**
	 * 
	 * Service permettant de calculer la cote d'une annonce
	 * 
	 * @param vehicle
	 * @return
	 */
	 Long annonceCote(Vehicle vehicle);
}
