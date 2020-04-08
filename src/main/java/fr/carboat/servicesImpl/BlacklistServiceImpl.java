package fr.carboat.servicesImpl;

import org.springframework.stereotype.Service;

import fr.carboat.services.BlacklistService;

@Service
public class BlacklistServiceImpl implements BlacklistService{

	private static final String IMMATRICULATION = "AA123AA";

	public boolean immatriculationBlacklister(String immatriculation) {

		if(IMMATRICULATION.equalsIgnoreCase(immatriculation)){
			attendreLaReponse();
			return true;
		}else {
			attendreLaReponse();
			return false;
		}
	}

	void attendreLaReponse(){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
