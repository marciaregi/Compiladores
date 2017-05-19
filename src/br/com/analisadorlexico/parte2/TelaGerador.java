/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.analisadorlexico.parte2;
/**
* alteração
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author wendel
 */
public class TelaGerador extends javax.swing.JFrame {

    /**
     * Creates new form TelaGerador
     */
    JFileChooser file;
    String textoFonte = "";

    public TelaGerador() {
        initComponents();
        txtSaida.setEditable(false);
        btnAnalisar.setEnabled(false);
        btnGerar.setEnabled(true);
        txtEntrada.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        btnAnalisar = new javax.swing.JButton();
        btnGerar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSaida = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Gerador léxico");

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        jScrollPane1.setViewportView(txtEntrada);

        btnAnalisar.setText("Analisar");
        btnAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarActionPerformed(evt);
            }
        });

        btnGerar.setText("Gerar Analisador Léxico");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Saída");

        txtSaida.setColumns(20);
        txtSaida.setRows(5);
        jScrollPane2.setViewportView(txtSaida);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Entrada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAnalisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(btnGerar)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalisar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void executar() throws Exception {
        int cont = 0;

        String expr;
        //jText = textArea1;

        AnalisadorLexico lexical = new AnalisadorLexico(new StringReader(textoFonte));
        String resultado = "";

          while (true) {
            Token token = lexical.yylex();
            if (token == null) {
                System.out.println(resultado);
                txtSaida.setText(resultado);

                return;
            }
            switch (token) {

                case OPERADOR_ARITMETICO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Aritmético> " + lexical.lexeme + "\n";
                    break;

                case OPERADOR_LOGICO:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Lógico> " + lexical.lexeme + "\n";
                    break;

                case ATRIBUICAO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Atribuição> " + lexical.lexeme + "\n";
                    break;
                case FIM_COMANDO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Fim_comando> " + lexical.lexeme + "\n";
                    break;
                case OPERADOR_RELACIONAL:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Relacional> " + lexical.lexeme + "\n";
                    break;

                case COMENTARIO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Comentario> " + lexical.lexeme + "\n";
                    break;

                case LINHA:
                    cont++;
                    break;

                case ERROR:
                    //cont ++;                    
                    resultado = resultado + "Erro na linha " + cont + ": Símbolo não reconhecido"+lexical.lexeme.toString()+ "\n";
                    break;

                case ID:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<ID> " + lexical.lexeme + "\n";
                    break;

                case NUMEROS_REIAS:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Numeros_reais> " + lexical.lexeme + "\n";
                    break;
                case TEXTO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Texto> " + lexical.lexeme + "\n";
                    break;
                case THEN:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Então> " + lexical.lexeme + "\n";
                    break;
                case WHILE:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Laço> " + lexical.lexeme + "\n";
                    break;
                case FOR:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Laço> " + lexical.lexeme + "\n";
                    break;
                case IF:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Condicional> " + lexical.lexeme + "\n";
                    break;
                case NUMEROS_NATURAIS:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Numero> " + lexical.lexeme + "\n";
                    break;
                case EXPOENTE:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<Expoente>" + lexical.lexeme + "\n";
                    break;
                case INICIO_BLOCO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Inicio_algoritmo>" + lexical.lexeme + "\n";
                    break;
                 case BRANCO:
                    //cont ++;
                    //resultado = resultado + "Linha: " + cont + "<Fim_algoritmo>" + lexical.lexeme + "\n";
                    break;
                case FIM_BLOCO:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<Fim_algoritmo>" + lexical.lexeme + "\n";
                    break;
                case FIM_LINHA:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<Fim_linha>" + lexical.lexeme + "\n";
                    break;
                default:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<" + lexical.lexeme + ">" + cont++;
                    break;
            }
        }

    }

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        file = new JFileChooser();
        JFileChooser arquivoFonteCaminho = null;
        txtEntrada.setEnabled(false);
        txtEntrada.setText("");
        txtSaida.setText("");
        textoFonte="";
        //jflex.Main.generate(file.getSelectedFile());
        int op = JOptionPane.showConfirmDialog(rootPane, "Gostaria de informar um arquivo?");
        switch (op) {
            case 0:
                arquivoFonteCaminho = new JFileChooser();
                arquivoFonteCaminho.setFileSelectionMode(JFileChooser.FILES_ONLY);
                arquivoFonteCaminho.setFileFilter(new FileNameExtensionFilter("prl", "prl"));
                int i = arquivoFonteCaminho.showSaveDialog(null);
                textoFonte = retornaArquivoLido(arquivoFonteCaminho.getSelectedFile());
                break;

            case 1:

                txtEntrada.setEnabled(true);

                break;
        }
        btnAnalisar.setEnabled(true);

    }//GEN-LAST:event_btnGerarActionPerformed

    private void btnAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarActionPerformed
        if (txtEntrada.isEnabled()) {
            textoFonte = txtEntrada.getText();
        }
        System.out.println(textoFonte);

        try {
            executar();
        } catch (Exception ex) {
            Logger.getLogger(TelaGerador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalisarActionPerformed

    private String retornaArquivoLido(File caminho) {
        String texto = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            for (String i = br.readLine(); i != null; i = br.readLine()) {
                texto += i;
            }

            return texto;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaGerador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnGerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextArea txtSaida;
    // End of variables declaration//GEN-END:variables
}
