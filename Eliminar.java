
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


public class Eliminar extends Contacto{
    
    public Eliminar(String name) {
        super(name);
    }
    
    public void Delete(){
        String name = this.getName();

        if (!name.isEmpty()) {
            try {
                File archivo = new File("directorio.txt");
                File archivoTemp = new File("directorio_temp.txt");

                FileReader fileReader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter(archivoTemp);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String line;
                boolean contactoEliminado = false;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] contacto = line.split(",");

                    if (!contacto[0].equals(name)) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    } else {
                        contactoEliminado = true;
                    }
                }

                bufferedReader.close();
                fileReader.close();
                bufferedWriter.close();
                fileWriter.close();

                archivo.delete();
                archivoTemp.renameTo(archivo);

                if (contactoEliminado) {
                    JOptionPane.showMessageDialog(null, "Contacto eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
                }


            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el contacto.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre válido.");
        }
    }
    
}
