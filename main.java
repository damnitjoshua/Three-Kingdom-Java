import java.nio.file.Path;
import java.util.List;

public class main {
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();
        System.out.println(cc.decrypt("^hkcpzl$^jhv$^jhv$av$bzl$^aol$^johpu$^zayhalnlt,$(ojpod)$pz$av$johpu$opz$(zwpozlsaahi)$dpao$zayvun$pyvu$johpuz."));

        // persona
        Persona<String> emperor = new Persona("Sun Quan", "Emperor", "Cavalry", 96, 98, 72, 77, 95);
        Persona<String> chiefManagement = new Persona("Zhang Zhao", "Chief of Management", "Archer", 22, 80, 89, 99, 60);
        Persona<String> chiefMilitary = new Persona("Zhou Yu", "Chief of Military", "Cavalry", 80, 86, 97, 80, 90);
        Persona<String>[] generals = new Persona[]{
                new Persona("Xu Sheng", "General", "Archer", 90, 78, 72, 40, 94),
                new Persona("Zhu Ge Jin", "General", "Archer", 63, 61, 88, 82, 71),
                new Persona("Lu Su", "General", "Infantry", 43, 87, 84, 88, 53),
                new Persona("Tai Shi Chi", "General", "Cavalry", 96, 81, 43, 33, 97),
                new Persona("Xiao Qiao", "General", "Infantry", 42, 52, 89, 77, 34),
                new Persona("Da Qiao", "General", "Cavalry", 39, 62, 90, 62, 41),
                new Persona("Zhou Tai", "General", "Infantry", 92, 89, 72, 43, 99),
                new Persona("Gan Ning", "General", "Archer", 98, 92, 45, 23, 97),
                new Persona("Lu Meng", "General", "Cavalry", 70, 77, 93, 83, 88),
                new Persona("Huang Gai", "General", "Infantry", 83, 98, 72, 42, 89)
        };
        emperor.addChild(chiefManagement);
        emperor.addChild(chiefMilitary);

        assignGenerals(generals, chiefManagement, chiefMilitary);

        System.out.println("Characters under Chief of Management:");
        chiefManagement.getChildren().printList();

        System.out.println("Characters under Chief of Military:");
        chiefMilitary.getChildren().printList();


        int[][] matrix = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 1, 1},
                {1, 0, 0, 0}
        };

        BattleshipClusters BC = new BattleshipClusters();

        int numClusters = BC.countBattleshipClusters(matrix);
        System.out.println("Number of clusters: " + numClusters);

        List<int[]> optimalCoordinates = BC.findOptimalCoordinates(matrix);
        System.out.println("Optimal coordinates for fireball throwing:");

        for (int[] coordinate : optimalCoordinates) {
            System.out.println("[" + coordinate[0] + ", " + coordinate[1] + "]");
        }

        PathFinder PF = new PathFinder();

        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 3},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        boolean[][] currentPath = new boolean[maze.length][maze[0].length];

        // Find the path
        PF.findPath(maze, currentPath);

        // Display the maze with the path
        PF.displayMaze(maze, currentPath);
    }

    private static void assignGenerals(Persona<String>[] generals, Persona<String> chiefManagement, Persona<String> chiefMilitary) {
        for (Persona<String> general : generals) {
            if (general.getInt() > general.getStr()) {
                chiefManagement.addChild(general);
            } else {
                chiefMilitary.addChild(general);
            }
        }
    }
}

