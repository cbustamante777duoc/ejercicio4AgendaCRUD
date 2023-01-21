import java.util.Collection;
import java.util.HashMap;

public class GestionContacto {
    
    public static HashMap<String,Contacto> agenda;

    public GestionContacto(){
        agenda = new HashMap<>();
    } 

    /**
     * metodo que agrega un contacto a la agenda
     * @param nombre propiedades del contacto
     * @param email propiedades del contacto
     * @param edad propiedades del contacto
     * @return true si lo agrega sino false (si esta agregado)
     */
    public static boolean Agregar(String nombre,String email,int edad) {

        if (!agenda.containsKey(email)) {
            Contacto contacto = new Contacto(nombre, email, edad);
            agenda.put(email, contacto);
            return true;
        } else {
            return false;
        }
        
    }

    /**
     * metodo que busca por email
     * @param email llave de la clase
     * @return el contacto 
     */
    public Contacto Buscar(String email){
        Contacto contacto = null;
        if (agenda.containsKey(email)) {
           contacto = agenda.get(email);
        }
        return contacto;
    }

    /**
     * Metodo para eliminar un contacto segun el email por parametro
     * @param email llave de la clase
     * @return si lo elimina return true sino false
     */
    public boolean Eliminar(String email){
        if (agenda.containsKey(email)) {
            agenda.remove(email);
            return true;
        } else {
            return false;
        }
    }

    /**
     * metodo que retorna todos los contacto de la agenda
     * @return retorna todos los contactos de la agenda
     */
    public Contacto[] recuperarContactos() {
        
        Contacto[] existentes = new Contacto[agenda.size()];
        int i = 0;
        Collection<Contacto> valores = agenda.values();
        for (Contacto contacto : valores) {
            existentes[i] = contacto;
            i++;
        }

        return existentes;
    }

}
