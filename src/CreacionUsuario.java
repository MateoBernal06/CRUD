
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreacionUsuario {
    JPanel panel_creacion;
    private JTextField ingreso_nombre;
    private JTextField ingreso_puesto;
    private JTextField ingreso_oficina;
    private JTextField ingreso_tiempo;
    private JButton CREARButton;
    private JButton boton_volver;
    private JLabel mensaje_con;

    String nombre;
    String puesto;
    String oficina;
    int tiempo;
    String exito=("Insercion exitosa");
    String fallo=("Insercion fallida");


    public CreacionUsuario() {
        CREARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre=ingreso_nombre.getText();
                puesto=ingreso_puesto.getText();
                tiempo=Integer.parseInt(ingreso_tiempo.getText());
                oficina=ingreso_oficina.getText();


                try(Connection conexion_2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","122928")){

                    String sql="INSERT INTO trabajador(nombre_trabajador, puesto, tiempo, oficina)values(?,?,?,?)";

                    try(PreparedStatement preparedStatement = conexion_2.prepareStatement(sql)){
                        preparedStatement.setString(1, nombre);
                        preparedStatement.setString(2,puesto);
                        preparedStatement.setInt(3,tiempo);
                        preparedStatement.setString(4, oficina);
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
        boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuOpciones.frame_ingreso.dispose();
                Main.frame.setContentPane(new MenuOpciones().panel_menu);
                Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Main.frame.pack();
                Main.frame.setVisible(true);
            }
        });
    }
}
