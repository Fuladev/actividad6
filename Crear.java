
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Crear extends Contacto {

    public Crear(String name, String cnumber) {
        super(name, cnumber);
    }

    public void CreateContact() {
        String name = this.getName();
        String cnumber = this.getCnumber();

        System.out.println(name + cnumber);

        if (!name.isEmpty() && !cnumber.isEmpty()) {
            try {
                if (!existe()) {
                    FileWriter fileWriter = new FileWriter("directorio.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(name + "," + cnumber);
                    bufferedWriter.newLine();

                    bufferedWriter.close();
                    fileWriter.close();

                    JOptionPane.showMessageDialog(null, "Contacto agregado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario con este nombre.");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el archivo.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre y un número de teléfono válido.");
        }
    }

    private boolean existe() {
        try {
            FileReader fileReader = new FileReader("directorio.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            boolean contactoEncontrado = false;

            while ((line = bufferedReader.readLine()) != null) {
                String[] contacto = line.split(",");

                if (contacto[0].equals(this.getName())) {

                    contactoEncontrado = true;

                    return contactoEncontrado;

                }
            }

            bufferedReader.close();
            fileReader.close();

            return contactoEncontrado;

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
            ex.printStackTrace();
        }
        return false;
    }

}
