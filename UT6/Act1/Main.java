package Act1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);
        TelefonoMovil miTelefono = new TelefonoMovil("111223344");
        Contacto contacto1 = Contacto.createContact("Fede", "123456789");
        miTelefono.addNewContact(contacto1);
        String numTel;
        String nombre;
        Contacto contacto;
        int opcion = -1;
        do {
            try {
                System.out.println("Menú del teléfono móvil:");
                System.out.println("0. Salir.");
                System.out.println("1. Imprimir contactos.");
                System.out.println("2. Agregar nuevo contacto.");
                System.out.println("3. Actualizar contacto.");
                System.out.println("4. Eliminar contacto.");
                System.out.println("5. Buscar contacto.");
                System.out.println("6. Imprimir menú de nuevo.");
                System.out.println();
                opcion = scan.nextInt();
                if (opcion < 0 || opcion > 6) {
                    throw new InputMismatchException();
                }

                switch (opcion) {
                    case 0:
                        break;

                    case 1:
                        miTelefono.printContacts();
                        System.out.println();
                        break;

                    case 2:
                        scan.nextLine();
                        System.out.println("Introduce el nombre del contacto a añadir:");
                        nombre = scan.nextLine();
                        System.out.println("Introduce el número de teléfono del contacto a añadir:");
                        numTel = scan.nextLine();
                        contacto = Contacto.createContact(nombre, numTel);

                        /*
                        Implemento el método creado para ver si existe o no el teléfono. Si no existe, lo crea y muestra el nombre y
                        teléfono y si no, muestra un mensaje de error
                         */
                        if (!miTelefono.compNum(numTel) && !miTelefono.compNom(nombre)) {
                            System.out.println("Contacto " + nombre + " añadid2o con número de teléfono " + numTel + ".");
                            miTelefono.addNewContact(contacto);
                            System.out.println();
                        }
                         else {
                            System.out.println("Error. El nombre o el número de teléfono ya está asignado.");
                            System.out.println();
                        }
                        break;

                    case 3:
                        scan.nextLine();
                        System.out.println("Introduce el nombre del contacto a actualizar:");
                        nombre = scan.nextLine();
                        Contacto contAnt = miTelefono.queryContact(nombre);
                        if (contAnt == null) {
                            System.out.println("No existe ese contacto en la lista.");
                            System.out.println();
                        } else {
                            System.out.println("Introduce el nuevo número de teléfono a actualizar:");
                            numTel = scan.nextLine();
                            contacto1 = Contacto.createContact(nombre, numTel);
                            miTelefono.updateContact(contAnt, contacto1);
                            System.out.println();
                        }
                        break;

                    case 4:
                        scan.nextLine();
                        System.out.println("Introduce el nombre del contacto a borrar:");
                        nombre = scan.nextLine();
                        miTelefono.removeContact(miTelefono.queryContact(nombre));
                        System.out.println();
                        break;

                    case 5:
                        scan.nextLine();
                        System.out.println("Introduce el nombre del contacto a buscar:");
                        nombre = scan.nextLine();
                        Contacto cont = miTelefono.queryContact(nombre);
                        if (cont == null) {
                            System.out.println("No existe ese contacto en la lista.");
                            System.out.println();
                        } else {
                            System.out.println("Nombre: " + cont.getName() +
                                    "\nTeléfono: " + cont.getPhoneNumber());
                            System.out.println();
                        }
                        break;

                    case 6:
                        System.out.println();
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Opción inválida introducida.");
                System.out.println();
        }

        } while (opcion != 0);
    }
}