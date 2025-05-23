package com.imc.imc_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imc.imc_api.model.ImcCalculation;
import com.imc.imc_api.repository.ImcRepository;

@Service
public class ImcService {

    @Autowired
    private ImcRepository imcRepository;

    public List<ImcCalculation> getAllImcCalculations() {
        return imcRepository.findAllByOrderByDateDesc();
    }

    public ImcCalculation saveImc(ImcCalculation imcCalculation) {
        ImcCalculation saved = imcRepository.save(imcCalculation);
        return saved;
    }

    public void deleteHistory() {
        imcRepository.deleteAll();
    }

    public void deleteById(Long id) {
        imcRepository.deleteById(id);
    }
}




