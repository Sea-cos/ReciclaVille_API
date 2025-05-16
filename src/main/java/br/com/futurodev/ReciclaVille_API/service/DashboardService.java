package br.com.futurodev.ReciclaVille_API.service;


import br.com.futurodev.ReciclaVille_API.model.dtos.DashboardResponse;
import br.com.futurodev.ReciclaVille_API.repository.DeclaracaoRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    DeclaracaoRepository declaracaoRepository;

    public DashboardService(DeclaracaoRepository declaracaoRepository){
        this.declaracaoRepository = declaracaoRepository;
    }

    public List<DashboardResponse> getDashboardData(){
        return declaracaoRepository.findDashboardData();
    }
}
