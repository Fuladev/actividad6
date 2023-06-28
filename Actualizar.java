
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Actualizar extends Contacto {

    public Actualizar(String name, String cnumber) {
        super(name, cnumber);
    }

    public void Update() {

        String name = this.getName();
        String cnumber = this.getCnumber();

        if (!name.isEmpty() && !cnumber.isEmpty()) {
            try {
                File archivo = new File("directorio.txt");
                File archivoTemp = new File("directorio_temp.txt");

                FileReader fileReader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter(archivoTemp);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String line;
                boolean contactoEncontrado = false;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] contacto = line.split(",");

                    if (contacto[0].equals(name)) {
                        bufferedWriter.write(contacto[0] + "," + cnumber);
                        contactoEncontrado = true;
                    } else {
                        bufferedWriter.write(line);
                    }

                    bufferedWriter.newLine();
                }

                bufferedReader.close();
                fileReader.close();
                bufferedWriter.close();
                fileWriter.close();

                if (contactoEncontrado) {
                    archivo.delete();
                    archivoTemp.renameTo(archivo);
                    JOptionPane.showMessageDialog(null, "Contacto actualizado exitosamente.");
                } else {
                    archivoTemp.delete();
                    JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
                }


            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el contacto.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre y un número de teléfono válido.");
        }
    }
}
