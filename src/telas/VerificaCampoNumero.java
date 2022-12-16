package telas;

import javax.swing.JTextField;

public class VerificaCampoNumero {
    private final JTextField campo;
    
    public VerificaCampoNumero(JTextField campo){
        this.campo=campo;
    }
    
    public boolean verificar(){
        String str=campo.getText();
        char[] chars= str.toCharArray();
        boolean ok=true;
        
        for(int i=0; i<chars.length;i++){
            try{
                Integer.parseInt(String.valueOf(chars[i]));
                
            }catch(NumberFormatException exc){
                ok=false;
                break;
            }
        }
        return ok;
    }
}
