package com.sergio.pruebapi2;

import javax.swing.JOptionPane;
import org.eclipse.jgit.api.errors.GitAPIException;

public class Main {

    public static void main(String[] args) throws GitAPIException {

        Metodos M = new Metodos();
            int op = Integer.parseInt(JOptionPane.showInputDialog("***MENU***\n"
                    + "1. Crear Repositorio\n"
                    + "2. Clonar Repositorio\n"
                    + "3. Commit"
                    + "4. Push"));
            do{
               
            
            switch(op){
                case 1: String nombre=JOptionPane.showInputDialog("Nombre del Repositorio");
                        M.crearRepositorio(nombre);
                        break;
                case 2: M.clonar();
                        break;
                case 3: String ruta = JOptionPane.showInputDialog("Ruta");
                        String msn = JOptionPane.showInputDialog("Mensaje");
                        M.commit(ruta, msn);
                        break;
                case 4: String ruta2 = JOptionPane.showInputDialog("Ruta");
                        String msn2 = JOptionPane.showInputDialog("Mensaje");
                        String nombre2 = JOptionPane.showInputDialog("Nombre");
                        String msn3 = JOptionPane.showInputDialog("Mensaje");
                        M.pushear(msn2, ruta2, nombre2, msn3);
            }
            }while(op<3);
    }
    
}
