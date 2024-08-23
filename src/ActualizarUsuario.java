
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ActualizarUsuario {
    private JTextField ingreso_nombre;
    private JButton boton_buscar;
    private JLabel mensaje_con;
    private JTextField nuevo_puesto;
    private JTextField nuevo_tiempo;
    private JTextField nuevo_oficina;
    private JButton boton_actualizar;
    private JButton boton_volver;
    JPanel panel_ac;
    private JTextField nueva_oficina;

    public ActualizarUsuario() {
        boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuOpciones.frame_actualizar.dispose();
                Main.frame.setContentPane(new MenuOpciones().panel_menu);
                Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Main.frame.pack();
                Main.frame.setVisible(true);
            }
        });

        boton_actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String trabajador= ingreso_nombre.getText();
                String puesto_a=nuevo_puesto.getText();
                String oficina_a=nueva_oficina.getText();
                int tiempo_a=Integer.parseInt(nuevo_tiempo.getText());


                try(Connection conexion_2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","122928")){

                    String sql="UPDATE trabajador SET puesto=?, tiempo=?, oficina=? WHERE nombre_trabajador=?";

                    try(PreparedStatement preparedStatement = conexion_2.prepareStatement(sql)){
                        preparedStatement.setString(1, puesto_a);
                        preparedStatement.setInt(2,tiempo_a);
                        preparedStatement.setString(3, oficina_a);
                        preparedStatement.setString(4, trabajador);
                        int filasAfectadas=preparedStatement.executeUpdate();


                        if (filasAfectadas>0){
                            mensaje_con.setText("Datos actualizados exitosamente");

                        }
                        else {
                            mensaje_con.setText("ERROR, No se pudo encontrar al trabajador");
                        }
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }

            }

        });
    }
}
