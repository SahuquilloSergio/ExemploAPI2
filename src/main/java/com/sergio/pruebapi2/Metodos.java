package com.sergio.pruebapi2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class Metodos {
    public void clonar(){
        try {
            Git.cloneRepository()
                    .setURI("https://github.com/eclipse/jgit.git")
                    .setDirectory(new File("C:\\Users\\serxa\\OneDrive\\Documentos\\NetBeansProjects\\ClonadoAPI"))
                    .call();
        } catch (GitAPIException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: "+ex);
        }
    }
    
    public void crearRepositorio(){
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        try {
            Repository repository = builder.setGitDir(new File("C:\\Users\\serxa\\OneDrive\\Documentos\\NetBeansProjects\\ClonadoAPI.git"))
                    .readEnvironment()
                    .findGitDir()
                    .setMustExist(true)
                    .build();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
