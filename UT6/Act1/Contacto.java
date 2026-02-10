package Act1;

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
}
