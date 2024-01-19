package com.openclassrooms.medilabo.glycoguardeval.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.medilabo.glycoguardeval.beans.Note;
import com.openclassrooms.medilabo.glycoguardeval.beans.Patient;

@FeignClient(name = "microservice-gateway", url = "localhost:9103")
public interface GatewayProxy {
    
	@GetMapping("/patients/{id}")
    Patient recupererPatient(@PathVariable("id") Long idPatient);
    
	@GetMapping("/notes/{id}")
    List<Note> recupererNotesPatient(@RequestParam("id") Long numPatient);
}
