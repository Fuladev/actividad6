import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaEliminar extends JFrame implements ActionListener {

    private Container container;
    private JLabel lblTitle, lblName;
    private JTextField txtName;
    private JButton btnDelete;

    public VentanaEliminar() {
        start();
        setTitle("Delete");
        setSize(255, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        container = getContentPane();
        container.setLayout(null);

        lblTitle = new JLabel();
        lblTitle.setText("Eliminar Contacto");
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setBounds(0, 20, 250, 25);

        lblName = new JLabel();
        lblName.setText("Nombre de contacto");
        lblName.setBounds(20, 55, 200, 25);
        txtName = new JTextField();
        txtName.setBounds(20, 80, 200, 25);

        btnDelete = new JButton();
        btnDelete.setText("Eliminar");
        btnDelete.setBounds(20, 125, 200, 25);
        btnDelete.addActionListener(this);


        container.add(lblTitle);
        container.add(lblName);
        container.add(txtName);
        container.add(btnDelete);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Eliminar obj = new Eliminar(txtName.getText());

        obj.Delete();

    }

}