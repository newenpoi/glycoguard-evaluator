package com.openclassrooms.medilabo.glycoguardeval.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.medilabo.glycoguardeval.beans.Gender;
import com.openclassrooms.medilabo.glycoguardeval.beans.Note;
import com.openclassrooms.medilabo.glycoguardeval.beans.Patient;
import com.openclassrooms.medilabo.glycoguardeval.beans.RiskLevel;
import com.openclassrooms.medilabo.glycoguardeval.beans.Terminology;
import com.openclassrooms.medilabo.glycoguardeval.service.EvaluationService;
import com.openclassrooms.medilabo.glycoguardeval.utils.CustomDateUtils;

@Service
public class EvaluationServiceImpl implements EvaluationService {

	@Override
	public RiskLevel evaluate(Patient p, List<Note> notes) {
		// Récupérer l'âge du patient.
		int dob = CustomDateUtils.calculateAge(p.getDob());
		Gender sex = p.getGender();
		
		// Le nombre de terminologies trouvées pour ce patient.
		int matches = 0;
		
		// Pour chaque notes vérifier la présence des termes déclencheurs (terminologie).
		for (Note note : notes) {
			// Pour chaque terminologie.
			for (Terminology terminology : Terminology.values()) {
				// Si la note contient une des terminologies.
				if (note.getNote().contains(terminology.getTerm())) matches++;
			}
		}
		
		// Si aucun match on peut directement renvoyer le rapport d'évaluation.
		if (matches == 0) return RiskLevel.NONE;
		
		// À partir de là on s'occupe des critères de l'âge et du sexe.
		
		
		return null;
	}

}
