package telas;

import java.awt.*;
import javax.swing.*;

public class CriarTela extends JFrame {
    String tituloJanela;
    int largura,altura;
    
    public CriarTela(String tituloJanela, int largura, int altura){
        this.tituloJanela=tituloJanela;
        this.largura=largura;
        this.altura=altura;
    }
    public void criar(){
        setTitle(tituloJanela);
        setSize(largura, altura);
        
        getContentPane().setBackground(Color.WHITE);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void centralizar(){
        
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension janela=getSize();
  
        if(janela.height>screen.height)
        setSize(janela.width, screen.height);
  
        if(janela.width>screen.width)
        setSize(janela.width, screen.width);
    
        setLocation((screen.width-janela.width)/2,(screen.height-janela.height)/2);
    
    }
    
    public void mostrar(){
        setVisible(true);
    } 
}
