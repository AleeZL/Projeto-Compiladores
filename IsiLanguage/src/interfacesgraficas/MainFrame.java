package interfacesgraficas;

import exceptions.IsiException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.IsiLangLexer;
import parser.IsiLangParser;


public class MainFrame extends javax.swing.JFrame {
    private IsiLangLexer    lexer;
    private IsiLangParser   parser;
    private String          code;
    
    
    public MainFrame() throws IOException {
        initComponents();
        
        IsiLanguageInput.setText(CharStreams.fromFileName("input.isi").toString());
        
        //IsiLanguageInput.setText(inicio);
    }
    
    public void init() throws IOException {
        setVisible(true);

        
    }
    
    public void compile(String program) {
        
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
            
            if (ComboBoxLanguage.getSelectedIndex() == 0) {
                parser.generateCode();
            } else {
                parser.generateC();
            }
            
            parser.verificaUsage();
            
            this.code = parser.getGeneratedCode();
            
            CompiledCode.setText(this.code);
            
            
        } catch (IsiException ex) {
            CompiledCode.setText("Semantic error - "+ex.getMessage());
            System.err.println("Semantic error - "+ex.getMessage());
            
        } catch (Exception ex) {
            CompiledCode.setText("Error "+ex.getMessage());
            System.err.println("Error "+ex.getMessage());
            
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
        ComboBoxLanguage = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1300, 900));
        setMinimumSize(new java.awt.Dimension(1300, 900));
        setResizable(false);
        setSize(new java.awt.Dimension(1300, 900));

        GreenBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/GreenBackground.png"))); // NOI18N

        UFABCLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/UFABC_Logo.png"))); // NOI18N

        Titulo.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 0));
        Titulo.setText("IsiLanguage Compiler");

        jLayeredPane1.setLayer(GreenBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(UFABCLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UFABCLogo)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GreenBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UFABCLogo))
                .addGap(11, 11, 11))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GreenBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, Short.MAX_VALUE))
        );

        IsiLanguageInput.setBackground(new java.awt.Color(51, 51, 51));
        IsiLanguageInput.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "input.isi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        IsiLanguageInput.setForeground(new java.awt.Color(255, 255, 255));
        IsiLanguageInput.setCaretColor(new java.awt.Color(255, 255, 255));
        IsiLanguageInput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        IsiLanguageInput.setDragEnabled(true);
        IsiLanguageInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IsiLanguageInputKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(IsiLanguageInput);

        CompiledCode.setEditable(false);
        CompiledCode.setBackground(new java.awt.Color(51, 51, 51));
        CompiledCode.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MainClass.java ou output.c", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        CompiledCode.setEditorKit(null);
        CompiledCode.setForeground(new java.awt.Color(0, 255, 0));
        CompiledCode.setToolTipText("");
        CompiledCode.setCaretColor(new java.awt.Color(255, 255, 255));
        CompiledCode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(CompiledCode);

        jButton1.setText("COMPILE");
        jButton1.setToolTipText("Clique para compilar o .isi em .java.");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ComboBoxLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java", "C" }));
        ComboBoxLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxLanguageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Linguagem de destino");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IsiLanguageInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IsiLanguageInputKeyReleased
        //IsiLanguageInput.setContentType("text/html");
        
        IsiLanguageInput.getText();
        
        
        
        
        
    }//GEN-LAST:event_IsiLanguageInputKeyReleased

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        compile(IsiLanguageInput.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboBoxLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxLanguageActionPerformed
       
    }//GEN-LAST:event_ComboBoxLanguageActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxLanguage;
    private javax.swing.JEditorPane CompiledCode;
    private javax.swing.JLabel GreenBackground;
    private javax.swing.JEditorPane IsiLanguageInput;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel UFABCLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
