
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaMain extends JFrame implements ActionListener {

    private Container container;
    private JLabel lblTitle;
    private JButton btnCreate, btnUpdate, btnDelete, btnSearch;

    public VentanaMain() {
        start();
        setTitle("Directorio");
        setSize(485, 170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void start() {
        container = getContentPane();
        container.setLayout(null);
        
        lblTitle = new JLabel();
        lblTitle.setText("Directorio");
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setBounds(0, 20, 480, 23);
        
        btnCreate = new JButton();
        btnCreate.setText("Crear");
        btnCreate.setBounds(20, 60, 100, 23);
        btnCreate.addActionListener(this);

        btnUpdate = new JButton();
        btnUpdate.setText("Actualizar");
        btnUpdate.setBounds(240, 60, 100, 23);
        btnUpdate.addActionListener(this);

        btnDelete = new JButton();
        btnDelete.setText("Eliminar");
        btnDelete.setBounds(350, 60, 100, 23);
        btnDelete.addActionListener(this);

        btnSearch = new JButton();
        btnSearch.setText("Buscar");
        btnSearch.setBounds(130, 60, 100, 23);
        btnSearch.addActionListener(this);

        container.add(btnCreate);
        container.add(btnUpdate);
        container.add(btnDelete);
        container.add(btnSearch);
        container.add(lblTitle);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == btnCreate) {
            VentanaCrear crear = new VentanaCrear();
            crear.setVisible(true);
        }
        
        if (evento.getSource() == btnSearch) {
            VentanaBuscar buscar = new VentanaBuscar();
            buscar.setVisible(true);
        }
        
        
        if (evento.getSource() == btnUpdate) {
            VentanaUpdate act = new VentanaUpdate();
            act.setVisible(true);
        }
        
        if (evento.getSource() == btnDelete) {
            VentanaEliminar del = new VentanaEliminar();
            del.setVisible(true);
        }

         
    }
}
