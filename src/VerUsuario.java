import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VerUsuario {
    JPanel panel_ver;
    private JTextField ingreso_id;
    private JButton boton_ver;
    private JTextPane lugar_datos;
    private JButton boton_volver;
    private JTextArea ver_datos;

    String fallo=("Trabajador no encontrado");


    public VerUsuario() {
        boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuOpciones.frame_ver.dispose();
                Main.frame.setContentPane(new MenuOpciones().panel_menu);
                Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Main.frame.pack();
                Main.frame.setVisible(true);
            }
        });

        boton_ver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_trabajador=Integer.parseInt(ingreso_id.getText());
                String dbURL="jdbc:mysql://localhost:3306/crud";
                String dbUserName="root";
                String dbpassword="122928";

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(dbURL,dbUserName,dbpassword);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet= statement.executeQuery("SELECT * FROM trabajador WHERE id="+id_trabajador);

                    if (resultSet.next()){
                        int id_ingresado = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre_trabajador");
                        String puesto = resultSet.getString("puesto");
                        int tiempo = resultSet.getInt("tiempo");
                        String oficina=resultSet.getString("oficina");

                        ver_datos.append(
                                "\nNombre del empleado: "+nombre+
                                "\nID: "+id_ingresado+
                                "\nPuesto: "+puesto+
                                "\nTiempo: "+tiempo+
                                "\nOficina: "+oficina+"\n"
                        );
                    }
                    else{
                        ver_datos.append("\nUsuario no encontrado\n");
                    }

                    resultSet.close();
                    statement.close();
                    connection.close();

                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });
    }
}
