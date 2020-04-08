package com.carboat.homect_01;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.io.Resources;
import com.google.gson.Gson;

import fr.carboat.models.Annonce;
import fr.carboat.servicesImpl.DetectionArnaqueServiceImpl;

@SpringBootApplication
@ComponentScan(basePackages = { "fr.carboat.*" })
public class HomeCt01Application implements CommandLineRunner {

	@Autowired
	DetectionArnaqueServiceImpl detectionArnaqueService;

	public static void main(String[] args) {
		SpringApplication.run(HomeCt01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		detectionArnaqueService.verifierAnnonce(annonce());
	}

	private Annonce annonce() {
		Annonce annonce = new Annonce();
		String jsonAnnonce = "";
		String fichierJson = "annonce.json";
		try {
			jsonAnnonce = IOUtils.toString(Resources.getResource(fichierJson)
					.openStream(), "UTF-8");
		} catch (IOException e) {
		}
		Gson gson = new Gson();
		annonce = gson.fromJson(jsonAnnonce, Annonce.class);
		return annonce;
	}

}
