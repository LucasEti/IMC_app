package com.imc.imc_api.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imc.imc_api.model.ImcCalculation;
import com.imc.imc_api.service.ImcService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/imc")
public class ImcController {
    @Autowired
    private ImcService imcService;

    // GET : récupérer l’historique
	@GetMapping("/history")
	public List<ImcCalculation> getImcHistory() {
		return imcService.getAllImcCalculations();
	}

    // POST : calculer l’IMC et enregistrer dans la BDD
    @PostMapping("/calculate")
    public ImcCalculation calculateAndSave(@RequestBody ImcCalculation request) {
        double poids = request.getPoids();
        double taille = request.getTaille();

        if (taille <= 0 || poids <= 0) {
            throw new IllegalArgumentException("Taille et poids doivent être positifs.");
        }

        double imc = poids / (taille * taille);
        String categorie = getCategorie(imc);

        request.setImc(Math.round(imc * 10.0) / 10.0);
        request.setCategorie(categorie);
        request.setDate(LocalDate.now());

        return imcService.saveImc(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllImc() {
        System.out.println(">> Reçu requête DELETE ALL");
        imcService.deleteHistory();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImcById(@PathVariable Long id) {
        System.out.println(">> Reçu requête DELETE id");
        imcService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

     // Méthode privée pour catégoriser l’IMC
    private String getCategorie(double imc) {
        if (imc < 18.5) return "Maigreur";
        if (imc < 25) return "Normal";
        if (imc < 30) return "Surpoids";
        return "Obésité";
    }

    }

   