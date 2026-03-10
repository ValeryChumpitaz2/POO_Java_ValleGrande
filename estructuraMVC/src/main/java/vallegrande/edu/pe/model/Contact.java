package vallegrande.edu.pe.model;

import java.util.Objects;

/**
 * Modelo que representa un contacto en la agenda.
 */
public class Contact {



    @Override
    public String toString() {
        return String.format("Contact{id='%s', name='%s', email='%s', phone='%s'}", id, name, email, phone);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}