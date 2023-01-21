import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        GestionContacto gestionContacto = new GestionContacto();
        Scanner sc = new Scanner(System.in);
        int opcion, edad;
        String nombre,email;

        do {
            System.out.println("1. Añadir contacto");
            System.out.println("2. buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar todos contactos");
            System.out.println("5. Salir");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese edad : ");
                    edad = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese el email: ");
                    email = sc.nextLine();
                    GestionContacto.Agregar(nombre, email, edad);
                    break;
                case 2:
                    System.out.println("Ingrse email:");
                    email = sc.nextLine();
                    Contacto contacto = gestionContacto.Buscar(email);
                    if (contacto == null) {
                        System.out.println("El contacto no existe ");
                    } else {
                        System.out.println(contacto.getNombre()+" "+contacto.getEmail());
                    }
                    break;
                case 3:
                    System.out.println("Ingrse email:");
                    email = sc.nextLine();
                    if (gestionContacto.Eliminar(email)) {
                        System.out.println("El contacto fue eliminado");
                    } else {
                        System.out.println("El contacto no se encontro");
                    }
                    break;
                case 4:
                    Contacto [] todos = gestionContacto.recuperarContactos();
                    for (Contacto item : todos) {
                        System.out.println(item.getNombre()+" - "+item.getEmail()+" - "+item.getEdad());
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Escribe una opcion valida");
                    break;
            }
            
        } while (opcion!=5);
    }
}
