package com.mycompany.sistema.de.cadastro.de.usuario;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CadastroUsuarios {
    public static void main(String[] args) {
        try {
            
            int numeroUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Quantos usuários deseja cadastrar?"));

            
            String[] nomes = new String[numeroUsuarios];
            int[] idades = new int[numeroUsuarios];
            String[] emails = new String[numeroUsuarios];

            
            for (int i = 0; i < numeroUsuarios; i++) {
                nomes[i] = JOptionPane.showInputDialog("Digite o nome do usuário " + (i + 1) + ":");
                idades[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do usuário " + (i + 1) + ":"));
                emails[i] = JOptionPane.showInputDialog("Digite o e-mail do usuário " + (i + 1) + ":");
            }

            
            StringBuilder resumoUsuarios = new StringBuilder("Lista de Usuários Cadastrados:\n");
            for (int i = 0; i < numeroUsuarios; i++) {
                resumoUsuarios.append("Usuário ").append(i + 1).append(":\n")
                              .append("Nome: ").append(nomes[i]).append("\n")
                              .append("Idade: ").append(idades[i]).append("\n")
                              .append("E-mail: ").append(emails[i]).append("\n\n");
            }

            
            JOptionPane.showMessageDialog(null, resumoUsuarios.toString(), "Usuários Cadastrados", JOptionPane.INFORMATION_MESSAGE);

            
            try (FileWriter fileWriter = new FileWriter("usuarios_cadastrados.txt");
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(resumoUsuarios.toString());
            }

            JOptionPane.showMessageDialog(null, "Usuários salvos com sucesso em 'usuarios_cadastrados.txt'!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os usuários: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro de entrada: por favor, insira números válidos para a idade e a quantidade.");
        }
    }
}

