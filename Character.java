
public class Character<E> {
    private String name;
    private String rank;
    private String armyType;
    private int Str;
    private int Lead;
    private int Int;
    private int Pol;
    private int Hit;
    private Character<E> prev;
    private Character<E> next;
    private Character<E> parent;
    private CharacterList<E> children;
    
    public Character(String name,String rank, String armyType, int Str, int Lead, int Int, int Pol, int Hit){
        this.name = name;
        this.rank = rank;
        this.armyType = armyType;
        this.Str = Str;
        this.Lead = Lead;
        this.Int = Int;
        this.Pol = Pol;
        this.Hit = Hit;
        this.prev = null;
        this.next = null;
        this.parent = null;
        this.children = new CharacterList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getRank(){
        return rank;
    }
    
    public void setRank(String rank){
        this.rank = rank;
    }
    
    public String getArmyType(){
        return armyType;
    }
    
    public void setArmyType(String armyType){
        this.armyType = armyType;
    }
    
    public int getStr(){
        return Str;
    }
    
    public void setStr(int Str){
        this.Str = Str;
    }
    
    public int getLead(){
        return Lead;
    }
    
    public void setLead(int Lead){
        this.Lead = Lead;
    }
    
    public int getInt(){
        return Int;
    }
    
    public void setInt(int Int){
        this.Int = Int;
    }
    
    public int getPol(){
        return Pol;
    }
    
    public void setPol(int Pol){
        this.Pol = Pol;
    }
    
    public int getHit(){
        return Hit;
    }
    
    public void setHit(int Hit){
        this.Hit = Hit;
    }
    
    public Character<E> getPrev() {
        return prev;
    }

    public void setPrev(Character<E> prev) {
        this.prev = prev;
    }

    public Character<E> getNext() {
        return next;
    }

    public void setNext(Character<E> next) {
        this.next = next;
    }
    
    public Character<E> getParent() {
        return parent;
    }

    public void setParent(Character<E> parent) {
        this.parent = parent;
    }

    public CharacterList<E> getChildren() {
        return children;
    }

    public void addChild(Character<E> child) {
        child.setParent(this);
        this.children.add(child);
    }
    
    public int getAbility(){
        return Str + Lead + Int + Pol + Hit;
    }
    
    
    
}
