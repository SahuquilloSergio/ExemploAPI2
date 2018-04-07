package com.sergio.pruebapi2;

import javax.swing.JOptionPane;
import org.eclipse.jgit.api.errors.GitAPIException;

public class Main {

    public static void main(String[] args) throws GitAPIException {

        Metodos M = new Metodos();
            int op = Integer.parseInt(JOptionPane.showInputDialog("***MENU***\n"
                    + "1. Crear Repositorio\n"
                    + "2. Clonar Repositorio\n"
                    + "3. Salir"));
            do{
               
            
            switch(op){
                case 1: M.crearRepositorio();
                        break;
                case 2: M.clonar();
                        break;
                case 3: System.exit(0);
                        break;
            }
            }while(op<3);
    }
    
}
