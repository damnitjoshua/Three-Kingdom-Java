
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class PersonaList<E> {
    private Persona<E> head;
    private Persona<E> tail;
    private int size;

    public PersonaList() {
        size = 0;
        this.head = null;
        this.tail = null;

    }

    public void add(Persona<E> Persona) {
        if (head == null) {
            head = Persona;
            tail = Persona;
        } else {
            Persona.setPrev(tail);
            tail.setNext(Persona);
            tail = Persona;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Persona<E> current = head;
        while (current != null) {
            System.out.println("Name: " + current.getName());
            System.out.println("Rank: " + current.getRank());
            System.out.println("Type: " + current.getArmyType());
            System.out.println("Strength: " + current.getStr());
            System.out.println("Leadership: " + current.getLead());
            System.out.println("Intelligence: " + current.getInt());
            System.out.println("Politic: " + current.getPol());
            System.out.println("Hit Points: " + current.getHit());
            System.out.println("-----------------------");
            current = current.getNext();
        }
    }

}