
public class Contacto{
    
    private String name, cnumber;

    public Contacto(String name, String cnumber) {
        this.name = name;
        this.cnumber = cnumber;
    }

    public Contacto(String name) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }
    
    
}
