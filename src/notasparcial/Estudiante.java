
package notasparcial;

/*
 * @author Edwin Mendez
 */
public class Estudiante {
  
private String Nombre;    
private int Nota;    

    public Estudiante(String Nombre, int Nota) {
        this.Nombre = Nombre;
        this.Nota = Nota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int Nota) {
        this.Nota = Nota;
    }
    
    
}
