
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Buscar extends Contacto {

    public Buscar(String name, String cnumber) {
        super(name, cnumber);
    }

    public Buscar(String name) {
        super(name);
    }

    public String Buscar() {
        String name = this.getName();

        if (!name.isEmpty()) {
            try {
                FileReader fileReader = new FileReader("directorio.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                boolean contactoEncontrado = false;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] contacto = line.split(",");

                    if (contacto[0].equals(name)) {

                        contactoEncontrado = true;
                        
                        System.out.println(contacto[1]);

                        return contacto[1];

                    }
                }

                bufferedReader.close();
                fileReader.close();

                if (!contactoEncontrado) {
                    JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre válido.");
        }
        return null;
    }
}
