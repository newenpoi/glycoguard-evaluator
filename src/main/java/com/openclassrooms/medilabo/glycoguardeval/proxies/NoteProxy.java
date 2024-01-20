package com.openclassrooms.medilabo.glycoguardeval.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.openclassrooms.medilabo.glycoguardeval.beans.Note;

@FeignClient(name = "microservice-notes", url = "localhost:9112")
public interface NoteProxy {
	
	@GetMapping("/notes/{idPatient}")
    List<Note> recupererNotesPatient(@PathVariable("idPatient") Long numPatient);
}
