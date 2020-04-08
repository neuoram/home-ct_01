package fr.carboat.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import fr.carboat.models.Annonce;
import fr.carboat.models.ResultatVerification;
import fr.carboat.services.DetectionArnaqueService;

@Service
public class DetectionArnaqueServiceImpl implements DetectionArnaqueService {

	private static final char AROBASE = '@';
	@Autowired
	QuotationServiceImpl quotationService;
	@Autowired
	BlacklistServiceImpl blacklistService;

	@Override
	public void verifierAnnonce(Annonce annonce) {
		ResultatVerification resultatVerification = new ResultatVerification(
				annonce.getReference());
		String[] rules = new String[6];
		int i = 1;

		if (!verificationPrenom(annonce.getContacts().getFirstName())) {

			rules[i] = "rule::firstname::length";
			i++;
		}
		if (!verificationNom(annonce.getContacts().getLastName())) {

			rules[i] = "rule::lastname::length";
			i++;
		}
		if (!verificationAlphanumerique(annonce.getContacts().getEmail())) {

			rules[i] = "rule:✉:alpha_rate";
			i++;
		}
		if (!verificationNumerique(annonce.getContacts().getEmail())) {

			rules[i] = "rule:✉:number_rate";
			i++;
		}
		if (verificationCotation(
				quotationService.annonceCote(annonce.getVehicle()),
				annonce.getPrice())) {

			rules[i] = "rule::price::quotation_rate";
			i++;
		}
		if (blacklistService.immatriculationBlacklister(annonce.getVehicle()
				.getRegisterNumber())) {
			rules[i] = "rule::registernumber::blacklist";
			i++;
		}
		if (i > 1) {
			resultatVerification.setScam(true);
			resultatVerification.setRules(rules);
			Gson gson = new Gson();
			System.out.println(gson.toJson(resultatVerification));
		}
	}

	public boolean verificationPrenom(String prenom) {
		if (prenom.length() > 2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verificationNom(String nom) {
		if (nom.length() > 2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verificationAlphanumerique(String chaine) {
		int longeurDuAlphanumeriqueDansMail = longeurDuAlphanumeriqueDansMail(chaine);
		int longeurTotalDuMail = longeurTotalDuMail(chaine);
		float pourcentageAlphaNumerique = ((float) longeurDuAlphanumeriqueDansMail)
				/ ((float) longeurTotalDuMail);
		return (pourcentageAlphaNumerique * 100) > 70f;
	}

	public boolean verificationNumerique(String chaine) {
		int longeurDuNumeriqueDansMail = longeurDuNumeriqueDansMail(chaine);
		int longeurTotalDuMail = longeurTotalDuMail(chaine);
		float pourcentageNumerique = ((float) longeurDuNumeriqueDansMail)
				/ ((float) longeurTotalDuMail);
		return (pourcentageNumerique * 100) < 30f;
	}

	public boolean verificationCotation(Long cotation, int prix) {
		double fourchette = cotation * 0.2;
		double prixMinimum = cotation - fourchette;
		double prixMaximum = cotation + fourchette;
		if ((prixMinimum < prix) && (prix < prixMaximum)) {
			return true;
		} else {
			return false;
		}
	}

	private int longeurTotalDuMail(String chaine) {
		boolean mail = true;
		int somme = 0;
		for (int i = 0; i < chaine.length(); i++) {
			char c = chaine.charAt(i);
			if (mail) {
				if (c == AROBASE)
					mail = false;
				somme++;
			}
		}
		return somme - 1;

	}

	private int longeurDuAlphanumeriqueDansMail(String chaine) {
		boolean mail = true;
		int alphaNumerique = 0;
		for (int i = 0; i < chaine.length(); i++) {
			char c = chaine.charAt(i);
			if (mail) {
				if (Character.isDigit(c) || Character.isLetter(c)) {
					alphaNumerique++;
				}
				if (c == AROBASE)
					mail = false;
			}
		}
		return alphaNumerique;
	}

	private int longeurDuNumeriqueDansMail(String chaine) {
		boolean mail = true;
		int numerique = 0;
		for (int i = 0; i < chaine.length(); i++) {
			char c = chaine.charAt(i);
			if (mail) {
				if (Character.isDigit(c)) {
					numerique++;
				}
				if (c == AROBASE)
					mail = false;
			}
		}
		return numerique;
	}
}
