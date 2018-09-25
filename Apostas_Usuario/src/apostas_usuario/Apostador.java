/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apostas_usuario;

import Usuarios.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Danie
 */
public abstract class Apostador extends Usuario implements Aposta_Interface{
    Apostador a;
    public Apostador(int idApostador, int matricula, String nome, String cpf, String telefone, String endereco) {
        super(matricula, nome, cpf, telefone, endereco);
    }
    public void cadastrarApostador(){
        
        }
      
    public Apostador(){
        
    }

    
    
}
