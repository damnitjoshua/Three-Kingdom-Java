
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class CharacterList<E> {
    private Character<E> head;
    private Character<E> tail;
    private int size;
    
    public CharacterList() {
        size = 0;
        this.head = null;
        this.tail = null;
        
    }
    
    public void add(Character<E> character) {
        if (head == null) {
            head = character;
            tail = character;
        } else {
            character.setPrev(tail);
            tail.setNext(character);
            tail = character;
        }
        size++;
    }
    
    public int getSize() {
        return size;
    }
    
    public void printList() {
        Character<E> current = head;
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