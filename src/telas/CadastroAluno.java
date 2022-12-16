package telas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entidade.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listas.*;
import telas_componentes.*;

public class CadastroAluno extends JFrame implements ActionListener, TelaPadrao  {
    
    private String nome;
    private char turma;
    private int idade=0,serie=0,n_matricula, presente=0;
    private float nota1=0,nota2=0, nota3=0; 
        
    private final CriarTela tela;
    
    private final int larguraJanela, alturaJanela;
    private int larguraComponente;
    
    //Declarando Campos de Texto
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtSerie;
    private JTextField txtTurma;
    private JTextField txtN_matricula;
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtNota3;
    private JTextField txtPresente;
    
     //Declarando Campos de Botão
    private JButton btnCadastrar;
    private JButton btnVoltar;
       
    private final ListaAlunos lista;
       
    public CadastroAluno(){
        //Definindo o tamanho da janela
        larguraJanela=550;
        alturaJanela=400;
           
        tela=new CriarTela(TituloJanela.TITULO_JANELA,larguraJanela,alturaJanela);
        tela.criar();
        tela.setLayout(null);
        adicionarComponentes();
        tela.centralizar();
        tela.setResizable(false);
        lista=new ListaAlunos();
        tela.mostrar();
    }
       
    public final void adicionarComponentes(){
        
        //Definindo as estruturas que serão que serão expostos na janela
        larguraComponente=larguraJanela-20;
           
        JPanel header=header();
        header.setSize(larguraComponente, 30);
        header.setLocation(6,40);
           
        JPanel body=body();
        body.setLocation(140,100);
           
        JPanel footer=footer();
        footer.setLocation(2,310);
           
        tela.add(header);
        tela.add(body);
        tela.add(footer);
    }
       
    public final JPanel header(){
           return new Header("Cadastrar Aluno").criar();
    }
       
    public final JPanel body(){
        JPanel body=new JPanel();
        JLabel lblNome= new JLabel();
        JLabel lblIdade=new JLabel();
        JLabel lblSerie=new JLabel();
        JLabel lblTurma=new JLabel();
        JLabel lblN_matricula=new JLabel();
        JLabel lblN_Nota1=new JLabel();
        JLabel lblN_Nota2=new JLabel();
        JLabel lblN_Nota3=new JLabel();
        JLabel lblN_Presente=new JLabel();
           
        //limitando o numero de letras ou numeros nas Label
        txtNome= new SomenteLetras(30);
        txtIdade=new SomenteNumeros(2);
        txtSerie=new SomenteNumeros(2);
        txtTurma = new SomenteLetras(1);
        txtN_matricula=new SomenteNumeros(10);
        txtNota1=new SomenteNumeros(4);
        txtNota2=new SomenteNumeros(4);
        txtNota3=new SomenteNumeros(4);
        txtPresente=new SomenteNumeros(2);
       
        body.setLayout(new GridLayout(9,4,8,2));
        body.setSize(300,200);
        body.setBackground(null);
        
        //Colocando nome nas labels
        lblNome.setText("Nome");
        lblIdade.setText("Idade");
        lblSerie.setText("Serie");
        lblTurma.setText("Turma");
        lblN_matricula.setText("Nº da Matricula");
        lblN_Nota1.setText("Nota 1");
        lblN_Nota2.setText("Nota 2");
        lblN_Nota3.setText("Nota 3");
        lblN_Presente.setText("Quantidade de Presença");
                   
        //adicionando os as LAbels
        body.add(lblNome);
        body.add(txtNome);
          
        body.add(lblIdade);
        body.add(txtIdade);
        
        body.add(lblN_matricula);
        body.add(txtN_matricula);
            
        body.add(lblSerie);
        body.add(txtSerie);
            
        body.add(lblTurma);
        body.add(txtTurma);
        
        body.add(lblN_Nota1);
        body.add(txtNota1);
        
        body.add(lblN_Nota2);
        body.add(txtNota2);
        
        body.add(lblN_Nota3);
        body.add(txtNota3);
        
        body.add(lblN_Presente);
        body.add(txtPresente);
            
        return body;
    }
       
    public final JPanel footer(){
           
        JPanel footer=new JPanel();
        btnCadastrar=new JButton();
        btnVoltar=new JButton();
           
        footer.setLayout(new FlowLayout());
        footer.setSize(larguraComponente,100);
        footer.setBackground(null);
           
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(this);
           
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this);
           
        footer.add(btnCadastrar);
        footer.add(btnVoltar);
           
        return footer;
       }
       
    @Override
    public void actionPerformed(ActionEvent evt){
        
        if(evt.getSource()==btnVoltar){
            new TelaAluno();
            tela.dispose();
            
        }  else if(evt.getSource()==btnCadastrar){

           if(CamposVazios()){
                JOptionPane.showMessageDialog(null,"Por gentileza, preencha todos os campos vazios.");
                return ;
            }
           
             //Adiconando dados nos campos digitados 
             adicionarDados(); 
             
             //Adicionando Aluno
             if(verificaCampos()==true){
                lista.adicionarAluno(new Aluno(nome,idade,serie,turma,n_matricula,nota1,nota2,nota3,presente));

                int resp=JOptionPane.showConfirmDialog(null,"Funcionario Cadastrado.\nDeseja continuar cadastrando?", TituloJanela.TITULO_JANELA,JOptionPane.YES_NO_OPTION);
              
                if(resp==0){
                    tela.dispose();
                    new CadastroAluno(); 
                }
            
                 if(resp==1){
                    try {
                        lista.imprimirArquivo();
                    } catch (IOException ex) {
                        Logger.getLogger(CadastroAluno.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    tela.dispose();
                    return; 
                }
            }
        }
    } 
    
    private void adicionarDados(){
            nome=txtNome.getText();
            idade=Integer.parseInt(txtIdade.getText());
            serie=Integer.parseInt(txtSerie.getText());
            turma= txtTurma.getText().charAt(0);
            n_matricula=Integer.parseInt(txtN_matricula.getText());
            nota1 =Float.parseFloat(txtNota1.getText());
            nota2 =Float.parseFloat(txtNota2.getText());
            nota3 =Float.parseFloat(txtNota3.getText());
            presente=Integer.parseInt(txtPresente.getText());   
    }
    
    private boolean verificaCampos(){
        VerificaCampoNumero verificarMatricula=new VerificaCampoNumero(txtN_matricula);
        VerificaCampoNumero verificarSerie=new VerificaCampoNumero(txtSerie);
        VerificaCampoNumero verificarIdade=new VerificaCampoNumero(txtIdade);
            
        if(!verificarMatricula.verificar()){
            JOptionPane.showMessageDialog(null,"Dados incorretos, por geltileza, preencha o campo da matricula somente com numeros.");
            txtN_matricula.setText("");
            return false;
        }
        
          if(!verificarSerie.verificar()||serie>12){
            JOptionPane.showMessageDialog(null,"Dados incorretos, por geltileza, preencha o campo da Serie somente com numeros de 1 até 12.");
            txtSerie.setText("");
            return false;
        }
             
         if(!verificarIdade.verificar()){
            txtIdade.setText("");
            JOptionPane.showMessageDialog(null,"Dados incorretos, por geltileza, preencha o campo Idade com valores inteiros.");
            return false;
        }
             
        if(nota1>10.0){
            txtNota1.setText("");
            JOptionPane.showMessageDialog(null,"Dados incorretos, por geltileza, preencha o campo Nota 1 com valores de 0 a 10");
            return false;
        }
            
         if(nota2>10.0){
            txtNota2.setText("");
            JOptionPane.showMessageDialog(null,"Dados incorretos, por geltileza, preencha o campo Nota 2 com valores de 0 a 10");
            return false;
        }
             
         if(nota3>10.0){
            txtNota3.setText("");
            JOptionPane.showMessageDialog(null,"Dados incorretos, por geltileza, preencha o campo Nota 3 com valores de 0 a 10");
            return false;
        }
              
        if(presente>60){
            txtPresente.setText("");
            JOptionPane.showMessageDialog(null,"Dados incorretos, por geltileza, preencha o campo do Nº de Presença com valores de 0 á 60.");
            return false;
        } 
        return true;
    }
       
    private boolean CamposVazios(){
        return txtNome.getText().isEmpty()||
                txtIdade.getText().isEmpty()||
                txtSerie.getText().isEmpty()||
                txtTurma.getText().isEmpty()||
                txtN_matricula.getText().isEmpty()||
                txtNota1.getText().isEmpty()||
                txtNota2.getText().isEmpty()||
                txtNota3.getText().isEmpty()||
                txtPresente.getText().isEmpty();
    }    
}