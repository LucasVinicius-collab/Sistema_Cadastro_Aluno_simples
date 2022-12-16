package entidade;

import java.text.DecimalFormat;

public class Aluno extends Pessoa  implements Comparable {

    private int n_matricula, idade;
    private char turma;
    private int serie;
    private float nota_1;
    private float nota_2;
    private float nota_3;
    private float media;
    private int n_presente;
    private float p_presente;
    
//Metodo Construtor
    public Aluno(String nome, int idade, int serie, char turma, int n_matricula, float nota_1, float nota_2, float nota_3,int n_presente) {
       super(nome);
       this.idade=idade;
       this.turma=turma;
       this.serie=serie;
       this.n_matricula=n_matricula;
       this.nota_1=nota_1;
       this.nota_2=nota_2;
       this.nota_3=nota_3;
       this.n_presente=n_presente; 
    }

    //Criação dos GET e SETS kda classe
	public void set_n_matricula(int n_matricula) {
            this.n_matricula=n_matricula;
	}

	public int get_n_matricula() {
		return n_matricula;
	}

	public void setTurma(char turma) {
            this.turma=turma;
	}

	public char getTurma() {
		return turma;
	}
        
        public void seIdade(int idade) {
            this.idade=idade;
	}

	public int getIdade() {
		return idade;
	}

	public void setSerie(int serie) {
            this.serie=serie;
	}

	public int getSerie() {
		return serie;
	}

	public void setNota_1(float nota_1) {
            this.nota_1=nota_1;
	}

	public float getNota_1() {
		return nota_1;
	}

	public void setNota_2(float nota_2) {
            this.nota_2=nota_2;
	}

	public float getNota_2() {
		return nota_2;
	}

	public void setNota_3(float nota_3) {
            this.nota_3=nota_3;

	}

	public float getNota_3() {
		return nota_3;
	}
        
        public void setMedia(float media) {
            this.media=media;

	}

	public float getMedia() {
            float nota1, nota2,nota3; //declarando variaveis locais
            
            //chamando o metodo para atribuir valores nas classes locais
            nota1=getNota_1();
            nota2=getNota_2();
            nota3=getNota_3();
       
            this.media=(nota1+nota2+nota3)/3;

	    return media;
	}

	public void setN_presente(int n_presente) {
            this.n_presente=n_presente;
	}

	public int getN_presente() {
		return n_presente;
	}
        
        public void setP_Presente(float p_presente) {
            this. p_presente= p_presente;
	}

	public float getP_presente() {
            float presenca;
            
            //chamando o metodo para atribuir valores nas classes locais
            presenca=getN_presente();
            this.p_presente=(presenca/60)*100;

            return p_presente;
	}

    @Override
	public int compareTo(Object obj ) {
            Aluno aluno=(Aluno)obj;
            int resp= this.getNome().compareTo(aluno.getNome());
            if(resp!=0){
                return resp;
            }else if(this.get_n_matricula()<aluno.get_n_matricula()){
                return -1;
            }else if(this.get_n_matricula()>aluno.get_n_matricula()){
                return 1;
            }else{
                return 0;
            }
       }   

	public boolean equals(Object obj ) {
		return super.equals(obj);
	}
         
	public String toString() {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            
            return "Nome:"+getNome()+"\nNumero de Matricula: "+get_n_matricula()+"\nIdade: "+
                    getIdade()+"\nSerie: "+getSerie()+"\nTurma:"+getTurma()+"\nMedia de Notas: "+df.format(getMedia())+"%"+"\nNumero de presença: "+getN_presente()+
                    "\nPorcentagem de Presença : "+df.format(getP_presente())+"%\n\n";
        }
}