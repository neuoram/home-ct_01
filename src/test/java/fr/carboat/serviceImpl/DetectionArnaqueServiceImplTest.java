package fr.carboat.serviceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import fr.carboat.models.Annonce;
import fr.carboat.models.Contacts;
import fr.carboat.servicesImpl.DetectionArnaqueServiceImpl;

@RunWith(SpringRunner.class)
public class DetectionArnaqueServiceImplTest {
	DetectionArnaqueServiceImpl detectionArnaque = new DetectionArnaqueServiceImpl();
	Annonce annonce;
    
	@Before
	public void setUp() throws JsonSyntaxException, JsonIOException,
			FileNotFoundException {

		String jsonAnnonce = "";
		try {
			jsonAnnonce = IOUtils.toString(Resources
					.getResource("annonce.json").openStream(), "UTF-8");
		} catch (IOException e) {
		}
		Gson gson = new Gson();
		annonce = gson.fromJson(jsonAnnonce, Annonce.class);
	}
	
	@Test
	public void verificationPrenomAvecPlusDeuxCaractereTest() {
		// given
		Annonce annonceAvecPrenomvalide = annonce;

		String prenomValide = annonceAvecPrenomvalide.getContacts()
				.getFirstName();
		// when
		boolean verification = detectionArnaque
				.verificationPrenom(prenomValide);
		// then
		Assert.assertTrue(verification);
	}

	@Test
	public void verificationPrenomAvecMoinDeuxCaractereTest() {
		// given
		Annonce annonceAvecPrenomNONvalide = annonce;
		annonceAvecPrenomNONvalide.setContacts(new Contacts("a", "Dupont",
				"testdepots@yopmail.fr", null));
		// when
		boolean verification = detectionArnaque
				.verificationPrenom(annonceAvecPrenomNONvalide.getContacts()
						.getFirstName());
		// then
		Assert.assertFalse(verification);

	}

	@Test
	public void verificationNomAvecPlusDeuxCaractereTest() {
		// given
		Annonce annonceAvecNomvalide = annonce;

		String nomValide = annonceAvecNomvalide.getContacts().getLastName();
		// when
		boolean verification = detectionArnaque.verificationPrenom(nomValide);
		// then
		Assert.assertTrue(verification);
	}

	@Test
	public void verificationNomAvecMoinDeuxCaractereTest() {
		// given
		Annonce annonceAvecNomNONvalide = annonce;
		annonceAvecNomNONvalide.setContacts(new Contacts("a", "Dupont",
				"testdepots@yopmail.fr", null));
		// when
		boolean verification = detectionArnaque
				.verificationPrenom(annonceAvecNomNONvalide.getContacts()
						.getFirstName());
		// then
		Assert.assertFalse(verification);

	}

	@Test
	public void verificationAlphanumeriqueValideTest() {
		// given
		Annonce annonceAvecAlphanumeriqueValide = annonce;
		// when
		boolean verification = detectionArnaque
				.verificationAlphanumerique(annonceAvecAlphanumeriqueValide
						.getContacts().getEmail());
		// then
		Assert.assertTrue(verification);
	}

	@Test
	public void verificationAlphanumeriqueNONValideTest() {
		// given
		String emailNONValide = "++testdep++@yopmail.fr";
		// when
		boolean verification = detectionArnaque
				.verificationAlphanumerique(emailNONValide);
		// then
		Assert.assertFalse(verification);
	}

	@Test
	public void verificationNumeriqueValideTest() {
		// given
		Annonce annonceAvecNumeriqueValide = annonce;
		// when
		boolean verification = detectionArnaque
				.verificationNumerique(annonceAvecNumeriqueValide.getContacts()
						.getEmail());
		// then
		Assert.assertTrue(verification);
	}

	@Test
	public void verificationNumeriqueNONValideTest() {
		// given
		String emailNONValide = "545454epots@yopmail.fr";
		// when
		boolean verification = detectionArnaque
				.verificationNumerique(emailNONValide);
		// then
		Assert.assertFalse(verification);
	}

	@Test
	public void verificationCotationValideTest() {
		// given

		// when
		boolean verification = detectionArnaque.verificationCotation(35000L,
				30000);
		// then
		Assert.assertTrue(verification);
	}

	@Test
	public void verificationCotationNONValideTest() {
		// given

		// when
		boolean verification = detectionArnaque.verificationCotation(35000L,
				19000);
		// then
		Assert.assertFalse(verification);
	}
}
