package Act1;

import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacto>();
    }

    public boolean addNewContact(Contacto contacto) {
        if (myContacts.contains(contacto)) {
            return false;
        } else {
            myContacts.add(contacto);
            return true;
        }
    }

    public boolean updateContact(Contacto antiguo, Contacto nuevo) {
        for (Contacto cont : this.myContacts) {
            if (cont.getName().equals(antiguo.getName())) {
                myContacts.set(findContact(antiguo), nuevo);
                return true;
            }
        }
        return false;
    }

    public boolean removeContact(Contacto contacto) {
        if (contacto == null) {
            System.out.println("Error. No existe ese contacto.");
            return false;
        }
        for (Contacto cont : this.myContacts) {
            if (cont.getName() == contacto.getName()) {
                myContacts.remove(findContact(contacto));
                System.out.println("El contacto " + contacto.getName() + " ha sido eliminado.");
                return true;
            }
        }
            return false;
    }

    private int findContact(Contacto contacto) {
        int index = myContacts.indexOf(contacto);
        if (myContacts.contains(contacto)) {
            return index;
        } else {
            return -1;
        }
    }

    private int findContact(String nombre) {
        int index = myContacts.indexOf(nombre);
        for (Contacto cont : this.myContacts) {
            if (cont.getName()==nombre) {
                return index;
            }
        }
        return -1;
    }

    public Contacto queryContact(String nombre) {
        for (Contacto cont : this.myContacts) {
            if (cont == null) {
                return null;
            }
         if (cont.getName().equals(nombre)) {
             return cont;
         }
        }
        return null;
    }

    /*
    Método añadido para comprobar si el número de un contacto ya existe, le paso el teléfono y comprueba el array para ver si ya existe
    o no
     */
    public boolean compNum(String numTel) {
        for (Contacto cont : this.myContacts) {
            if (cont == null) {
                return false;
            }
            if (cont.getPhoneNumber().equals(numTel)) {
                return true;
            }
        }
        return false;
    }

    public void printContacts() {
        int i = 0;
        System.out.println("Lista de contactos:");
        for (Contacto cont : this.myContacts) {
            i++;
            System.out.println(i + ". " + cont.getName() + " -> " + cont.getPhoneNumber());
        }
    }
}
