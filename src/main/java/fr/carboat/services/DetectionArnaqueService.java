package fr.carboat.services;

import fr.carboat.models.Annonce;


public interface DetectionArnaqueService {

	/**
	 * détection d'arnaques sur des annonces
	 * @param annonce
	 */
	void verifierAnnonce(Annonce annonce);
}
