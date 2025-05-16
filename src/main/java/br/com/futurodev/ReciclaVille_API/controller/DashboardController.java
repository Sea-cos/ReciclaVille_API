package br.com.futurodev.ReciclaVille_API.controller;

import br.com.futurodev.ReciclaVille_API.model.dtos.DashboardResponse;
import br.com.futurodev.ReciclaVille_API.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<List<DashboardResponse>> getDashboard(){
        List<DashboardResponse> dashboardData = dashboardService.getDashboardData();
        return ResponseEntity.ok(dashboardData);
    }
}
