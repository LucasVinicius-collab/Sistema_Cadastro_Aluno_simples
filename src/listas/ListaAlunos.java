package listas;

import java.util.ArrayList;
import java.util.Iterator;
import entidade.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import telas.Relatorio;

public class ListaAlunos {
    
    ArrayList alunos=new ArrayList(); 
    
    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);//adicionando os dados de um aluno
        
        File arquivo = new File("C:\\Users\\Public\\Documents/Cadastro_Alunos.txt");//definindo o caminho do arquivo onde será usado.

        //testando se o arquivo já existe
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
         
            //caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();

            //escrevendo no arquivo
            FileWriter fw = new FileWriter(arquivo, true);
            Iterator iter=alunos.iterator();
            if(iter.hasNext()==true){
                String str = "---Imprimindo de Alunos---\n";
                while(iter.hasNext()){
                    fw.write(str+="\n"+iter.next());   
                }
	    fw.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();      
        }
    }
    
    public void imprimirArquivo() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Public\\Documents/Cadastro_Alunos.txt"))) {
            
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
            String fileAsString = sb.toString();
            new Relatorio(fileAsString);
        } 
    }
}