package com.sergio.pruebapi2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
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
    
    public void commit(String ruta, String msn){
        try{
            FileRepositoryBuilder repositoryBuilder=new FileRepositoryBuilder();
            Repository repository=repositoryBuilder.setGitDir(new File(ruta))
                    .readEnvironment()
                    .findGitDir()
                    .setMustExist(true)
                    .build();

            Git git=new Git(repository);
            AddCommand add=git.add();
            add.addFilepattern(ruta).call();
            CommitCommand commit=git.commit();
            commit.setMessage(msn).call();
        }catch(IOException ex){
            System.out.println("Error:"+ex);
        }catch(GitAPIException ex){
            System.out.println("Error:"+ex);
        }
    }
}
