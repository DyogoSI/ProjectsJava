/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package classes;

/**
 *
 * @author dyogo
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Aplicativo extends javax.swing.JFrame {
private Stack<Recorde> pilhaPrincipal = new Stack<>();
    private Stack<Recorde> pilhaAuxiliar = new Stack<>();
    private JTextArea pilhaPrincipalTextArea;
    private JTextArea pilhaAuxiliarTextArea;

    /**
     * Creates new form Aplicativo
     */
    public Aplicativo() {
         setTitle("Pilhas em Java com Interface Gráfica");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);

       
        
         JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(120, 40, 100, 25);
        btnRemover.setBackground(Color.RED);
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!pilhaPrincipal.isEmpty()) {
                    pilhaAuxiliar.push(pilhaPrincipal.pop());
                    atualizarTextAreas();
                }
            }
        });
        panel.add(btnRemover);

  JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(230, 40, 100, 25);
        btnLimpar.setBackground(Color.GREEN);
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pilhaPrincipal.clear();
                pilhaAuxiliar.clear();
                atualizarTextAreas();
            }
        });
        panel.add(btnLimpar);

          JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 50, 20);
        panel.add(lblNome);

        JTextField txtNome = new JTextField();
        
        txtNome.setBounds(70, 10, 150, 30);
       
        panel.add(txtNome);

        JLabel lblData = new JLabel("Data:");
        
        lblData.setBounds(230, 10, 50, 20);
        panel.add(lblData);

        JTextField txtData = new JTextField();
        txtData.setColumns(5);  
        
        txtData.setBounds(290, 10, 150, 30);
        panel.add(txtData);

        JLabel lblTempo = new JLabel("Tempo:");
        lblTempo.setBounds(450, 10, 50, 20);
        panel.add(lblTempo);

        JTextField txtTempo = new JTextField();
        txtTempo.setColumns(5);
        txtTempo.setBounds(510, 10, 150, 30);
        panel.add(txtTempo);

               JButton btnAdicionar = new JButton("Adicionar");
       btnAdicionar.setBounds(10, 40, 100, 25);
        btnAdicionar.setBackground(Color.BLUE);
       btnAdicionar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        String data = txtData.getText();
        String tempoStr = txtTempo.getText();

        
        if (!tempoStr.isEmpty()) {
            try {
                int tempo = Integer.parseInt(tempoStr);

                
                if (!pilhaPrincipal.isEmpty()) {
                   
                    int tempoTopo = Integer.parseInt(pilhaPrincipal.peek().getTempo());

                    
                    if (tempo >= tempoTopo) {
                        Recorde novoRecorde = new Recorde(nome, data, tempoStr);
                        pilhaPrincipal.push(novoRecorde);
                        atualizarTextAreas();
                    } else {
                        // Exibe uma mensagem de erro se o tempo for menor que o tempo do registro anterior
                        JOptionPane.showMessageDialog(panel, "Tempo deve ser maior ou igual ao tempo do registro anterior: " + tempoTopo);
                    }
                } else {
                    
                    Recorde novoRecorde = new Recorde(nome, data, tempoStr);
                    pilhaPrincipal.push(novoRecorde);
                    atualizarTextAreas();
                }
            } catch (NumberFormatException ex) {
                // Exibe uma mensagem de erro se o valor inserido não for um número válido
                JOptionPane.showMessageDialog(panel, "Por favor, insira um tempo válido (número inteiro)");
            }
        } else {
            
            JOptionPane.showMessageDialog(panel, "Por favor, insira um tempo válido");
        }
    }
});
panel.add(btnAdicionar);





        pilhaPrincipalTextArea = new JTextArea();
        pilhaPrincipalTextArea.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(pilhaPrincipalTextArea);
        scrollPane1.setBounds(10, 70, 350, 300);
        panel.add(scrollPane1);

        pilhaAuxiliarTextArea = new JTextArea();
        pilhaAuxiliarTextArea.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(pilhaAuxiliarTextArea);
        scrollPane2.setBounds(370, 70, 350, 300);
        panel.add(scrollPane2);

        add(panel);
        setVisible(true);
    }
          private void atualizarTextAreas() {
          pilhaPrincipalTextArea.setText("Pilha Principal:\n");
        for (Recorde recorde : pilhaPrincipal) {
            pilhaPrincipalTextArea.append(recorde.toString() + "\n");
        }

        pilhaAuxiliarTextArea.setText("Pilha Auxiliar:\n");
        for (Recorde recorde : pilhaAuxiliar) {
            pilhaAuxiliarTextArea.append(recorde.toString() + "\n");
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setText("NOME");

        jLabel2.setText("DATA");

        jLabel3.setText("TEMPO");

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setText("ADICIONAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("REMOVER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 255, 0));
        jButton3.setText("LIMPAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(135, 135, 135)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(334, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1163, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Aplicativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicativo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
