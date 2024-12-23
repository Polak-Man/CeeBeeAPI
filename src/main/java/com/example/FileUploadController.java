package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping
    public ResponseEntity<String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("textInput") String textInput,
            @RequestParam(value = "showPseudo", required = false) Boolean showPseudo,
            @RequestParam(value = "selectedNames", required = false) List<String> selectedNames,
            @RequestParam(value = "durationSec", required = false) Integer durationSec,
            @RequestParam(value = "durationMs", required = false) Integer durationMs) {

        // Logique de traitement des données
        StringBuilder response = new StringBuilder("Fichier téléchargé avec succès : " + file.getOriginalFilename() + "\n");
        response.append("Texte : ").append(textInput).append("\n");
        response.append("Afficher Pseudo : ").append(showPseudo).append("\n");
        response.append("Noms sélectionnés : ").append(selectedNames).append("\n");
        response.append("Durée (sec) : ").append(durationSec).append("\n");
        response.append("Durée (ms) : ").append(durationMs).append("\n");

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }
}