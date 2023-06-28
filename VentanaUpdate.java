
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RyZen 5 Pro
 */
public class VentanaUpdate extends JFrame implements ActionListener {

    private Container container;
    private JLabel lblTitle, lblName, lblNumber;
    private JTextField txtName;
    private JFormattedTextField txtNumber;
    private JButton  btnUpdate;

    public VentanaUpdate() {
        start();
        setTitle("Update");
        setSize(255, 280);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        container = getContentPane();
        container.setLayout(null);

        lblTitle = new JLabel();
        lblTitle.setText("Actualizar Contacto");
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setBounds(0, 20, 250, 25);

        lblName = new JLabel();
        lblName.setText("Nombre de contacto");
        lblName.setBounds(20, 55, 200, 25);
        txtName = new JTextField();
        txtName.setBounds(20, 80, 200, 25);

        lblNumber = new JLabel();
        lblNumber.setText("Número de contacto");
        lblNumber.setBounds(20, 125, 200, 25);
        txtNumber = new JFormattedTextField();
        txtNumber.setBounds(20, 150, 200, 25);
        txtNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btnUpdate = new JButton();
        btnUpdate.setText("Actualizar");
        btnUpdate.setBounds(20, 195, 200, 25);
        btnUpdate.addActionListener(this);

        container.add(lblTitle);
        container.add(lblName);
        container.add(txtName);
        container.add(lblNumber);
        container.add(txtNumber);
        container.add(btnUpdate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Actualizar obj = new Actualizar(txtName.getText(), txtNumber.getText());

        obj.Update();
    }
}
