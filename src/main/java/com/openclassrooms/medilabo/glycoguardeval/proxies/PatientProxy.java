package com.openclassrooms.medilabo.glycoguardeval.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.openclassrooms.medilabo.glycoguardeval.beans.Patient;

@FeignClient(name = "microservice-patients", url = "localhost:9111")
public interface PatientProxy {
    
	@GetMapping("/patients/{idPatient}")
    Patient recupererPatient(@PathVariable("idPatient") Long idPatient);
}
