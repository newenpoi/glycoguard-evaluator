package com.openclassrooms.medilabo.glycoguardeval.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.openclassrooms.medilabo.glycoguardeval.beans.Note;
import com.openclassrooms.medilabo.glycoguardeval.beans.Patient;
import com.openclassrooms.medilabo.glycoguardeval.beans.RiskLevel;
import com.openclassrooms.medilabo.glycoguardeval.proxies.NoteProxy;
import com.openclassrooms.medilabo.glycoguardeval.proxies.PatientProxy;
import com.openclassrooms.medilabo.glycoguardeval.service.EvaluationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EvaluationController {
	
	private final PatientProxy patientProxy;
	private final NoteProxy noteProxy;
	
	private final EvaluationService service;
	
	@GetMapping("/evaluator/{idPatient}")
	public ResponseEntity<RiskLevel> evaluate(@PathVariable Long idPatient) {
		// On a besoin de la date de naissance du patient (interroger micro service patients).
		Patient p = patientProxy.recupererPatient(idPatient);
		
		// On a besoin des notes du patient (interroger micro service notes).
		List<Note> notes = noteProxy.recupererNotesPatient(idPatient);
		
		// Determinates the risk level from the patient.
		RiskLevel evaluation = service.evaluate(p, notes);
		
		return ResponseEntity.ok(evaluation);
	}
}
