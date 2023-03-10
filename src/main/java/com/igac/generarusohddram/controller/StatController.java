package com.igac.generarusohddram.controller;

import com.igac.generarusohddram.models.Estadistica;
import com.igac.generarusohddram.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("stat")
public class StatController {

    @Autowired private StatService statService;

    @GetMapping
    public ResponseEntity<Estadistica> getStats(){
        return ResponseEntity.ok(statService.obtenerRamHdd());
    }
}
