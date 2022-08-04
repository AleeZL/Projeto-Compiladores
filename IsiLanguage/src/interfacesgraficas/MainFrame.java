package interfacesgraficas;

import exceptions.IsiException;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicTextUI;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import main.IsiLanguage;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.IsiLangLexer;
import parser.IsiLangParser;


public class MainFrame extends javax.swing.JFrame {
    private String inicio = "<html>";
    private IsiLangLexer    lexer;
    private IsiLangParser   parser;
    
    
    public MainFrame() throws IOException {
        initComponents();
        
        IsiLanguageInput.setText(CharStreams.fromFileName("input.isi").toString());
        //IsiLanguageInput.setContentType("text/html");
        //IsiLanguageInput.setText(inicio);
    }
    
    public void init() throws IOException {
        setVisible(true);

        
    }
    
    public void compile(String program) throws IOException {
        
        try {
            //Lê o texto do painel.isi, que serve de entrada para o analisador léxico.
            FileWriter fr = new FileWriter(new File ("input.isi"));
            fr.write(program);
            fr.close();

            lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));

            //Gera o fluxo de tokens, que será utilizado no parser.
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            //Criação do parser a partir do tokenStream
            parser = new IsiLangParser(tokenStream);

            parser.prog();

            System.out.println("Sucesso!");

            parser.exibeComandos();

            parser.generateCode();

            CompiledCode.setText(parser.getGeneratedCode());
        } catch (IsiException ex) {
            System.err.println("Semantic error - "+ex.getMessage());
            CompiledCode.setText("Semantic error - "+ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Error "+ex.getMessage());
            CompiledCode.setText("Error "+ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        GreenBackground = new javax.swing.JLabel();
        UFABCLogo = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IsiLanguageInput = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        CompiledCode = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1300, 900));
        setMinimumSize(new java.awt.Dimension(1300, 900));
        setResizable(false);
        setSize(new java.awt.Dimension(1300, 900));

        GreenBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/GreenBackground.png"))); // NOI18N

        UFABCLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/UFABC_Logo.png"))); // NOI18N

        Titulo.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 0));
        Titulo.setText("ISILANGUAGE COMPILER");

        jLayeredPane1.setLayer(GreenBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(UFABCLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 723, Short.MAX_VALUE)
                .addComponent(UFABCLogo)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GreenBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(UFABCLogo))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Titulo)))
                .addGap(11, 11, 11))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GreenBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, Short.MAX_VALUE))
        );

        IsiLanguageInput.setBackground(new java.awt.Color(51, 51, 51));
        IsiLanguageInput.setForeground(new java.awt.Color(0, 255, 0));
        IsiLanguageInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IsiLanguageInputKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(IsiLanguageInput);

        CompiledCode.setEditable(false);
        CompiledCode.setBackground(new java.awt.Color(51, 51, 51));
        CompiledCode.setForeground(new java.awt.Color(0, 255, 0));
        jScrollPane2.setViewportView(CompiledCode);

        jButton1.setText("COMPILE");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IsiLanguageInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IsiLanguageInputKeyReleased

        if (IsiLanguageInput.getText().contains("\ntexto ")){
            IsiLanguageInput.setText(inicio + IsiLanguageInput.getText().replace("\ntexto ", "<span style=\"color:red\">" + "\ntexto " + "</span>"));
        }
    }//GEN-LAST:event_IsiLanguageInputKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            compile(IsiLanguageInput.getText());
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane CompiledCode;
    private javax.swing.JLabel GreenBackground;
    private javax.swing.JEditorPane IsiLanguageInput;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel UFABCLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
