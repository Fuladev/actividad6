import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCrear extends JFrame implements ActionListener {
    
    private Container container;
    private JLabel lblTitle,lblName,lblNumber;
    private JTextField txtName;
    private JFormattedTextField txtNumber;
    private JButton create;
    
    public VentanaCrear(){
        start();
        setTitle("Create");
        setSize(255, 280);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void start(){
        container = getContentPane();
        container.setLayout(null);
        
        lblTitle = new JLabel();
        lblTitle.setText("Crear Contacto");
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
        
        create = new JButton();
        create.setText("Crear contacto");
        create.setBounds(20, 195, 200, 25);
        create.addActionListener(this);
        
        
        container.add(lblTitle);
        container.add(lblName);
        container.add(txtName);
        container.add(lblNumber);
        container.add(txtNumber);
        container.add(create);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Crear nuevo = new Crear(txtName.getText(),txtNumber.getText());
        
        nuevo.CreateContact();
        
    }
    
}
