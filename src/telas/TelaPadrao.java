package telas;

import javax.swing.*;

public interface TelaPadrao {
    void adicionarComponentes();
    JPanel header();
    JPanel body();
    JPanel footer();  
}
