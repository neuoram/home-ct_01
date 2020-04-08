package fr.carboat.servicesImpl;

import org.springframework.stereotype.Service;

import fr.carboat.models.Vehicle;
import fr.carboat.services.QuotationService;

@Service
public class QuotationServiceImpl implements QuotationService {

	private static final long COTE = 35000L;
	private static final int WS_RESPONSE_TIME = 50;

	public Long annonceCote(Vehicle vehicle) {
		try {
			Thread.sleep(WS_RESPONSE_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return COTE;
	}

}
