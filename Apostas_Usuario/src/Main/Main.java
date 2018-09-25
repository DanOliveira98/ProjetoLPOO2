/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Usuarios.*;
import apostas_usuario.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    int ind = 0;

    public static void main(String args[]) {
        int esc1 = 0;
        int esc2 = 0;
        int esc = 0;
        Usuario u = null;
        Apostador a = null;
        ArrayList<Usuario> admins = new ArrayList<Usuario>();
        ArrayList<Usuario> aps = new ArrayList<Usuario>();
        //looping pro menu

        do {
            try {
                esc = Integer.parseInt(JOptionPane.showInputDialog("1- Cadastrar Usuario\n 2- Buscar Usuario\n 3- Deletar Usuario\n 4- Alterar Usuario\n 5- Sair"));
                switch (esc) {
                    //cadastro de usuario
                    case 1:
                        int contcad;
                        do {
                            try {
                                contcad = 0;
                                int es = Integer.parseInt(JOptionPane.showInputDialog("Qual tipo de Usuario você deseja Cadastrar\n 1- Administradores da Banca\n 2- Apostadores\n 3- Voltar ao Menu"));
                                switch (es) {
                                    //Cadastrar Administradores
                                    case 1:
                                        int contcadAdm;
                                        do {
                                            try {
                                                contcadAdm = 0;
                                                esc1 = Integer.parseInt(JOptionPane.showInputDialog("Informe qual tipo de Administrador que você quer Gerar o Cadastro\n 1- Adm\n 2- Supervisor\n 3- Cambista\n 4-Voltar ao Menu"));
                                            } catch (NumberFormatException e) {
                                                contcadAdm = 1;
                                                System.err.println(e);
                                                JOptionPane.showMessageDialog(null, "Por favor, informe um valor numerico");
                                            }
                                        } while (contcadAdm != 0);
                                        switch (esc1) {
                                            //cadastro adm
                                            case 1:
                                                u = new Adm();
                                                admins.add(u.gerarCadastro());
                                                break;
                                            //cadastro supervisor
                                            case 2:
                                                u = new Supervisor();
                                                admins.add(u.gerarCadastro());
                                                break;
                                            //cadastro Cambista
                                            case 3:
                                                u = new Cambista();
                                                admins.add(u.gerarCadastro());
                                                break;
                                            case 4:
                                                JOptionPane.showMessageDialog(null, "Voltando ao Menu...");
                                                break;
                                            default:
                                                JOptionPane.showMessageDialog(null, "Informe uma Opção Valida");
                                                break;
                                        }

                                        break;
                                    //cadastrar apostador
                                    case 2:
                                        do {
                                            do {
                                                try {
                                                    contcad = 0;
                                                    esc2 = Integer.parseInt(JOptionPane.showInputDialog("Qual tipo de Apostador você deseja cadastrar\n 1- Apostador Credenciado\n 2- Apostador Novo\n 3 - Voltar ao menu"));
                                                } catch (NumberFormatException e) {
                                                    contcad = 1;
                                                    JOptionPane.showMessageDialog(null, "Por favor, informe um valor numerico");
                                                }
                                            } while (contcad != 0);
                                            switch (esc2) {
                                                case 1:
                                                    a = new Apostador_credenciado();
                                                    aps.add(a.gerarCadastro());
                                                    break;
                                                case 2:
                                                    a = new ApNovo();
                                                    aps.add(u.gerarCadastro());
                                                    break;
                                                case 3:
                                                    JOptionPane.showMessageDialog(null, "Voltando ao Menu...");
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Informe uma Opção Valida");
                                                    break;
                                            }
                                            break;

                                        } while (esc2 != 3);
                                    case 3:
                                        JOptionPane.showMessageDialog(null, "Voltando ao Menu...");
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Informe uma opção valida!");
                                }
                            } catch (NumberFormatException e) {
                                contcad = 1;
                                JOptionPane.showMessageDialog(null, "Por favor, informe um valor numerico");
                            }
                        } while (contcad != 0);
                        break;
                    //Buscar Usuario
                    case 2:
                        int testbsc;//controlador do looping da exceção
                        do {
                            do {
                                try {
                                    testbsc = 0;
                                    esc2 = Integer.parseInt(JOptionPane.showInputDialog("informe qual tipo de Usuario é\n 1- Administrador\n 2- Apostador\n 3- Voltar ao Menu "));
                                    switch (esc2) {
                                        case 1:
                                            String n = JOptionPane.showInputDialog("Informe o nome do Usuario que você deseja Pesquisar");
                                            for (int i = 0; i < admins.size(); i++) {
                                                if (admins.get(i).getNome().equals(n)) {
                                                    JOptionPane.showMessageDialog(null, u.imprimirCadastro());
                                                }
                                            }
                                            break;
                                        case 2:
                                            n = JOptionPane.showInputDialog("Informe o nome do Usuario que você deseja Pesquisar");
                                            for (int i = 0; i < aps.size(); i++) {
                                                if (aps.get(i).getNome().equals(n)) {
                                                    JOptionPane.showMessageDialog(null, a.imprimirApostador());
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Administrador não cadastrado");
                                                }
                                            }
                                            break;
                                        case 3:
                                            JOptionPane.showMessageDialog(null, "Voltando ao Menu...");
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Informe uma Opção Valida");
                                            break;

                                    }
                                } catch (NumberFormatException e) {
                                    testbsc = 1;
                                    JOptionPane.showMessageDialog(null, "Informe um valor numerico");
                                }
                            } while (testbsc != 0);
                            break;
                        } while (esc2 != 3);
                        break;
                    //deletar usuario
                    case 3:
                        String n = JOptionPane.showInputDialog("Informe Qual o nome do Usuario que você deseja deletar");
                        do {
                            try {
                                esc2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o que o Usuario que você quer deletar é\n 1- Administrador\n 2- Apostador\n 3- Voltar ao Menu"));
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Informe uma opção valida!");
                            }
                            int contdell;
                            switch (esc2) {
                                //deletar administrador

                                case 1:
                                    for (int i = 0; i < admins.size(); i++) {
                                        if (admins.get(i).getNome().equals(n)) {
                                            JOptionPane.showMessageDialog(null, u.imprimirCadastro());

                                            do {
                                                contdell = 0;
                                                try {
                                                    esc1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Tem Certeza que deseja Deletar?\n 1-Sim 2- Não"));
                                                } catch (NumberFormatException e) {
                                                    contdell = 1;
                                                    JOptionPane.showMessageDialog(null, "Informe uma opção valida!");
                                                }
                                            } while (contdell != 0);
                                            switch (esc1) {
                                                case 1:
                                                    admins.remove(i);
                                                    JOptionPane.showMessageDialog(null, "Usuario Deletado com sucesso");
                                                    break;
                                                case 2:
                                                    JOptionPane.showMessageDialog(null, "Operação Encerrada!!");
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Operação Cancelar por opção escolhida ser Incorreta!");
                                                    break;
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Administrador não cadastrado");
                                        }

                                    }

                                    break;
                                //deletar apostador
                                case 2:
                                    int contdelap;
                                    for (int i = 0; i < admins.size(); i++) {
                                        if (aps.get(i).getNome().equals(n)) {
                                            JOptionPane.showMessageDialog(null, a.imprimirApostador());
                                            do {
                                                try {
                                                    contdelap = 0;
                                                    esc1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Tem Certeza que deseja Deletar?"));
                                                } catch (NumberFormatException e) {
                                                    contdelap = 1;
                                                    JOptionPane.showMessageDialog(null, "Informe uma opção valida!\n 1- SIM\n 2- NÃO");
                                                }
                                            } while (contdelap != 0);
                                            switch (esc1) {
                                                case 1:
                                                    aps.remove(i);
                                                    JOptionPane.showMessageDialog(null, "Usuario Deletado com sucesso");
                                                case 2:
                                                    JOptionPane.showMessageDialog(null, "Operação Encerrada!!");
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Operação Cancelar por opção escolhida ser Incorreta!");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Administrador não cadastrado");
                                        }

                                    }
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(null, "Voltando..");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Informe Uma Opção valida!");
                                    break;
                            }
                            break;
                        } while (esc2 != 3);
                    //Alterar Cadastro
                    case 4:
                        int testAlt;
                        do {
                            try {
                                testAlt = 0;
                                esc2 = Integer.parseInt(JOptionPane.showInputDialog("Informe que tipo de Usuario você quer deletar é\n 1- Administrador\n 2- Apostador"));
                            } catch (NumberFormatException e) {
                                testAlt = 1;
                                JOptionPane.showMessageDialog(null, "Informe uma opção valida!");
                            }
                        } while (testAlt != 0);
                        switch (esc2) {
                            //alterar administrador
                            case 1:
                                n = JOptionPane.showInputDialog("Informe o nome do Usuario Administrador que você deseja Alterar os Dados");
                                for (int i = 0; i < admins.size(); i++) {
                                    if (admins.get(i).getNome().equals(n)) {
                                        JOptionPane.showMessageDialog(null, u.imprimirCadastro());
                                        u.alterarCadastro();
                                        JOptionPane.showMessageDialog(null, u.imprimirCadastro());
                                    }
                                }
                                break;
                            case 2:
                                n = JOptionPane.showInputDialog("Informe o nome do Usuario Administrador que você deseja Alterar os Dados");
                                for (int i = 0; i < admins.size(); i++) {
                                    if (admins.get(i).getNome().equals(n)) {
                                        JOptionPane.showMessageDialog(null, a.imprimirApostador());
                                        a.alterarCadastro();
                                        JOptionPane.showMessageDialog(null, a.imprimirApostador());
                                    }
                                }
                                break;
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Obrigado Por Usar Nosso sistema!");
                        JOptionPane.showMessageDialog(null, "Saindo...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Informe uma Opção Valida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "INFORME UM VALOR NUMERICO");
            }
        } while (esc != 5);
    }

}
