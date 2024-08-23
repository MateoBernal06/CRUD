
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuOpciones {
    JPanel panel_menu;
    private JButton boton_ver;
    private JButton boton_eliminar;
    private JButton boton_salir;
    private JButton boton_ingresar;
    private JButton boton_actualizar;
    public static JFrame frame_ingreso = new JFrame("Ingreso Trabajador");
    public static JFrame frame_eliminar = new JFrame("Eliminar Trabajador");
    public static JFrame frame_ver = new JFrame("Verificar Trabajador");
    public static JFrame frame_actualizar = new JFrame("Actualizar Trabajador");

    public MenuOpciones() {

        boton_salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInternalMessageDialog(null, "Adios, espero verte pronto");
                Main.frame.dispose();
            }
        });

        boton_ingresar.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.dispose();
                frame_ingreso.setContentPane(new CreacionUsuario().panel_creacion);
                frame_ingreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame_ingreso.pack();
                frame_ingreso.setVisible(true);
            }
        });

        boton_eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.dispose();
                frame_eliminar.setContentPane(new EliminacionUsuario().panel_eliminacion);
                frame_eliminar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame_eliminar.pack();
                frame_eliminar.setVisible(true);
            }
        });

        boton_ver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.dispose();
                frame_ver.setContentPane(new VerUsuario().panel_ver);
                frame_ver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame_ver.pack();
                frame_ver.setVisible(true);
            }
        });

        boton_actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.dispose();
                frame_actualizar.setContentPane(new ActualizarUsuario().panel_ac);
                frame_actualizar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame_actualizar.pack();
                frame_actualizar.setVisible(true);
            }
        });
    }
}



