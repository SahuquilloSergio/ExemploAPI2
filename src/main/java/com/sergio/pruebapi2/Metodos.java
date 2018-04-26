package com.sergio.pruebapi2;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;

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
    
    public void crearRepositorio(String nombre){
//        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        try {
            String nu = JOptionPane.showInputDialog("Nombre de usuario");
            String password = JOptionPane.showInputDialog("Contraseña");
            GitHub github=GitHub.connectUsingPassword(nu, password);
            GHCreateRepositoryBuilder builder;
            builder=github.createRepository(nombre);
            builder.create();
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    public void inicializarRepositorio(String ruta){
        InitCommand repositorio=new InitCommand();
        try{
            repositorio.setDirectory(new File(ruta)).call();
        }catch(GitAPIException ex){
            System.out.println("Error:"+ex);
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
    
    public void pushear(String url, String repositorio,String contrasena,String usuario){
        try{
            FileRepositoryBuilder repositoryBuilder=new FileRepositoryBuilder();
            Repository repository=repositoryBuilder.setGitDir(new File(repositorio))
                    .readEnvironment()
                    .findGitDir()
                    .setMustExist(true)
                    .build();
            
            Git git=new Git(repository);

            RemoteAddCommand remoteAddCommand=git.remoteAdd();
            remoteAddCommand.setName("origin");
            remoteAddCommand.setUri(new URIish(url));
            remoteAddCommand.call();
            
            PushCommand pushCommand=git.push();
            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(usuario, contrasena));
            pushCommand.call();
            
        }catch(IOException ex){
            System.out.println("Error: "+ex);
        }catch(URISyntaxException ex){
            System.out.println("Error: "+ex);
        }catch(GitAPIException ex){
            System.out.println("Error: "+ex);
        }
    }
    }

