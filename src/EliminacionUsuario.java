import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminacionUsuario {
    private JButton boton_eliminar;
    private JTextField ingreso_trabajador;
    private JButton boton_volver;
    JPanel panel_eliminacion;
    private JLabel mensaje_con;

    String exito=("Trabajor eliminado con exito");
    String fallo=("Trabajador no encontrado");


    public EliminacionUsuario() {
        boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuOpciones.frame_eliminar.dispose();
                Main.frame.setContentPane(new MenuOpciones().panel_menu);
                Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Main.frame.pack();
                Main.frame.setVisible(true);
            }
        });


        boton_eliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String trabajador=ingreso_trabajador.getText();
                try(Connection conexion_2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","122928")){

                    String sql = "DELETE FROM trabajador WHERE nombre_trabajador=?";

                    try(PreparedStatement preparedStatement = conexion_2.prepareStatement(sql)){
                        preparedStatement.setString(1, trabajador);
                        int filasAfectadas=preparedStatement.executeUpdate();

                        if (filasAfectadas>0){
                            mensaje_con.setText(exito);

                        }
                        else {
                            mensaje_con.setText(fallo);
                        }
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
    }


}
