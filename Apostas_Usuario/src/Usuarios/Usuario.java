package Usuarios;
public abstract class Usuario extends Usuario_chefe implements Usuario_Interface {
    Usuario u = null;
    
  
    public Usuario gerarCadastro() {
        return u;
    }

    public Usuario() {
        
    }

    public Usuario(int matricula, String nome, String cpf, String telefone, String endereco) {
        super(matricula, nome, cpf, telefone, endereco);
    }


    public String imprimirCadastro() {
       return "";
    }
    

}
