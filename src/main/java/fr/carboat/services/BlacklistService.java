package fr.carboat.services;

public interface BlacklistService {

	/**
	 * 
	 * Service permettant de blacklister une immatriculation
	 * 
	 * @param immatriculation
	 * @return
	 */
	public boolean immatriculationBlacklister(String immatriculation);
}
