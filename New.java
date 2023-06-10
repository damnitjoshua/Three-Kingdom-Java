
public class New {
    public static void main(String[] args) {
        Character<String> emperor = new Character("Sun Quan", "Emperor", "Cavalry", 96, 98, 72, 77, 95);
        Character<String> chiefManagement = new Character("Zhang Zhao", "Chief of Management", "Archer", 22, 80, 89, 99, 60);
        Character<String> chiefMilitary = new Character("Zhou Yu", "Chief of Military", "Cavalry", 80, 86, 97, 80, 90);
        Character<String>[] generals = new Character[]{
        new Character("Xu Sheng", "General", "Archer", 90, 78, 72, 40, 94),
        new Character("Zhu Ge Jin", "General", "Archer", 63, 61, 88, 82, 71),
        new Character("Lu Su", "General", "Infantry", 43, 87, 84, 88, 53),
        new Character("Tai Shi Chi", "General", "Cavalry", 96, 81, 43, 33, 97),
        new Character("Xiao Qiao", "General", "Infantry", 42, 52, 89, 77, 34),
        new Character("Da Qiao", "General", "Cavalry", 39, 62, 90, 62, 41),
        new Character("Zhou Tai", "General", "Infantry", 92, 89, 72, 43, 99),
        new Character("Gan Ning", "General", "Archer", 98, 92, 45, 23, 97),
        new Character("Lu Meng", "General", "Cavalry", 70, 77, 93, 83, 88),
        new Character("Huang Gai", "General", "Infantry", 83, 98, 72, 42, 89)
        };
        emperor.addChild(chiefManagement);
        emperor.addChild(chiefMilitary);
        
        assignGenerals(generals, chiefManagement, chiefMilitary);

        /*System.out.println("Characters under Chief of Management:");
        chiefManagement.getChildren().printList();

        System.out.println("Characters under Chief of Military:");
        chiefMilitary.getChildren().printList();*/
    }
    private static void assignGenerals(Character<String>[] generals, Character<String> chiefManagement, Character<String> chiefMilitary) {
        for (Character<String> general : generals) {
            if (general.getInt() > general.getStr()) {
                chiefManagement.addChild(general);
            } else {
                chiefMilitary.addChild(general);
            }
        }
    }
    
}
