package Act1;

import java.util.Objects;

public class Contacto {
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public static Contacto createContact(String name, String phoneNumber) {
        Contacto contacto = new Contacto(name, phoneNumber);
        return contacto;
    }

    //Método equals añadido para que no se añadan 2 con el mismo nombre
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(name, contacto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
