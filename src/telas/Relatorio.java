package telas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import telas_componentes.*;

public class Relatorio extends JFrame implements ActionListener, TelaPadrao{

    private final CriarTela tela;
    private final int larguraJanela, alturaJanela;
    private int larguraComponente;
    private final String texto;
    private JButton btnTerminar;             
                 
        public Relatorio(String texto){
            
            this.texto=texto;
            
            larguraJanela=600;
            alturaJanela=470;
            
            tela=new CriarTela(TituloJanela.TITULO_JANELA,larguraJanela, alturaJanela);
            tela.criar();
            tela.setLayout(null);
            adicionarComponentes();
            tela.centralizar();
            tela.setResizable(false);
            tela.mostrar();
        }
        
        public final void adicionarComponentes(){
            larguraComponente=larguraJanela-20;
            
            JPanel header=header();
            header.setSize(larguraComponente,30);
            header.setLocation(6,10);
            
            JPanel body=body();
            body.setLocation(6,50);
            
            JPanel footer=footer();
            footer.setLocation(2,390);
            
            tela.add(header);
            tela.add(body);
            tela.add(footer);
            
        }
        public JPanel header(){
            return new Header("Relatorio do Cadastro de Alunos").criar();
        }
        public JPanel body(){
            JPanel body=new JPanel();
            JTextArea textArea=new JTextArea(18,50);
            JScrollPane scrollPane=new JScrollPane(textArea);
            
            body.setLayout(new FlowLayout());
            body.setBackground(null);
            body.setSize(larguraComponente,330);
            
            textArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            textArea.setText(texto);
            textArea.setEditable(false);
            
            body.add(scrollPane);
            
            return body;
        }
        
        public JPanel footer(){
            
            JPanel footer=new JPanel();
            btnTerminar=new JButton();
        
            footer.setLayout(new FlowLayout());
            footer.setBackground(null);
            footer.setSize(larguraComponente,100);
            
            btnTerminar.setText("terminar");
            btnTerminar.addActionListener(this);
            
            footer.add(btnTerminar);
            
            return footer;
        }
       
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource()==btnTerminar){
            new TelaAluno();
            tela.dispose();
        }
    }
}
