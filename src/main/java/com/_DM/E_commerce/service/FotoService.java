package com._DM.E_commerce.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FotoService {

    @Value("${imagens.dir")
    private String imagensDir;

    public String salvarFoto(MultipartFile foto) throws IOException {
        String originalNome = foto.getOriginalFilename();
        String extensao = originalNome.substring(originalNome.lastIndexOf("."));
        String novoNome = UUID.randomUUID() + extensao;

        Path diretorio = Path.of(imagensDir);
        Files.createDirectories(diretorio);

        Path pathUrl = diretorio.resolve(novoNome);
        Files.copy(foto.getInputStream(), pathUrl);

        return imagensDir + "/" + novoNome;
    }
}
