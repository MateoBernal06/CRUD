import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame frame = new JFrame("Sistema Administrador");

    public static void main(String[] args) {
        frame.setContentPane(new MenuOpciones().panel_menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

