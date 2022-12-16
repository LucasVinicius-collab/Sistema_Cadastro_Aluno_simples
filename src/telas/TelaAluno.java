package telas;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import listas.ListaAlunos;
import telas_componentes.*;

public class TelaAluno extends JFrame implements ActionListener,TelaPadrao {

    private final CriarTela telaInicial;
    
    private final int larguraJanela, alturaJanela;
    private int larguraComponente;
    
    private JButton btnCadastrarAlunos;
    private JButton btnListarAlunos;
    private JButton btnSair;
    
    ListaAlunos lista=new ListaAlunos();
    
    public TelaAluno(){
        larguraJanela=400;
        alturaJanela=250;
        
        telaInicial=new CriarTela(TituloJanela.TITULO_JANELA,larguraJanela,alturaJanela);
        telaInicial.criar();
        
        telaInicial.setLayout(null);
        adicionarComponentes();
        telaInicial.centralizar();
        telaInicial.setResizable(false);
        telaInicial.mostrar();
    }
    
    public final void adicionarComponentes(){
        larguraComponente=larguraJanela-20;
        
        JPanel header=header();
        header.setSize(larguraComponente, 30);
        header.setLocation(6,10);
        
        JPanel body=body();
        body.setLocation(6,75);
        
        JPanel footer=footer();
        footer.setLocation(2,160);
        
        telaInicial.add(header);
        telaInicial.add(body);
        telaInicial.add(footer);
    }
    
    public final JPanel header(){
        return new Header("Sistema de Cadastro de Alunos").criar();
    }
    
    public final JPanel body(){

        JPanel body= new JPanel();
        btnCadastrarAlunos=new JButton();
        btnListarAlunos=new JButton();

        body.setLayout(new GridLayout(2,1));
        body.setSize(larguraComponente,80);
        body.setBackground(Color.CYAN);
              
        btnCadastrarAlunos.setText("Cadastrar Aluno");
        btnCadastrarAlunos.addActionListener(this);
              
        btnListarAlunos.setText("Listar alunos");
        btnListarAlunos.addActionListener(this);   
              
        body.add( btnCadastrarAlunos);
              
        body.add(  btnListarAlunos);
             
        return body; 
    }
    
    public final JPanel footer(){
        JPanel footer= new JPanel();
        btnSair=new JButton();
        
        footer.setLayout(new FlowLayout());
        footer.setSize(larguraComponente,100);
        footer.setBackground(null);
              
        btnSair.setText("SAIR");
        btnSair.addActionListener(this);
              
        footer.add( btnSair);
              
        return footer;
    }
    
    public void actionPerformed(ActionEvent evt){
        
        if(evt.getSource()==btnCadastrarAlunos){
            new CadastroAluno();
            telaInicial.dispose();
        }
        
        if(evt.getSource()==btnListarAlunos){

            if(verificArquivo()==true){
                try {
                    lista.imprimirArquivo();
                    
                    }catch (IOException ex) {
                        Logger.getLogger(TelaAluno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return;
                    
            }else{
                int resp=JOptionPane.showConfirmDialog(null,"Arquivo de cadastro não encontrado, deseja Cadastrar?", 
                             TituloJanela.TITULO_JANELA,JOptionPane.YES_NO_OPTION);
                if(resp==0){
                    new CadastroAluno();
                    telaInicial.dispose();
                }
                    
                if(resp==1){
                    telaInicial.dispose();
                    new TelaAluno();
                }
            }         
        }
        if(evt.getSource()==  btnSair)
             System.exit(0);
    }

      private boolean verificArquivo(){
         File arquivo = new File("C:\\Users\\Public\\Documents/Cadastro_Alunos.txt");
         if (!arquivo.exists()){
            return false;
         }else
            return true;
    } 
}