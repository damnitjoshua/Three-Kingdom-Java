package assignmentv2;

import java.util.LinkedList;

public class sortingMethod {
    
    //sort strength by selection
    public static LinkedList<TreeNode> sortStrength(LinkedList<TreeNode> list) {
        int n = list.size();
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            TreeNode minNode = list.get(i);
            
            for (int j = i + 1; j < n; j++) {
                TreeNode currentNode = list.get(j);
                if (currentNode.getGeneral().getStrength() < minNode.getGeneral().getStrength()) {
                    minIndex = j;
                    minNode = currentNode;
                }
            }
            
            if (minIndex != i) {
                list.set(minIndex, list.get(i));
                list.set(i, minNode);
            }
        }
        
        return list;
    }
    
    // Sorts intelligence by insertion
    public static LinkedList<TreeNode> sortIntelligence(LinkedList<TreeNode> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            TreeNode keyNode = list.get(i);
            int keyIntelligence = keyNode.getGeneral().getIntelligence();
            int j = i - 1;

            while (j >= 0 && list.get(j).getGeneral().getIntelligence() > keyIntelligence) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }

            list.set(j + 1, keyNode);
        }

        return list;
    }
    
    //sort leadership by bubble
    public static LinkedList<TreeNode> sortLeadership(LinkedList<TreeNode> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                TreeNode currentNode = list.get(j);
                TreeNode nextNode = list.get(j + 1);

                if (currentNode.getGeneral().getLeadership() > nextNode.getGeneral().getLeadership()) {
                    list.set(j, nextNode);
                    list.set(j + 1, currentNode);
                }
            }
        }

        return list;
    }
    
    //sort politic by gnome 
    public static LinkedList<TreeNode> sortPolitic(LinkedList<TreeNode> list) {
        int n = list.size();
        int index = 0;

        while (index < n) {
            if (index == 0) {
                index++;
            }

            if (list.get(index).getGeneral().getPolitic() >= list.get(index - 1).getGeneral().getPolitic()) {
                index++;
            } else {
                TreeNode temp = list.get(index);
                list.set(index, list.get(index - 1));
                list.set(index - 1, temp);
                index--;
            }
        }

        return list;
    }
    
    //sort hitpoint by merge 
    public static LinkedList<TreeNode> sortHitPoint(LinkedList<TreeNode> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        LinkedList<TreeNode> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<TreeNode> right = new LinkedList<>(list.subList(mid, list.size()));

        left = sortHitPoint(left);
        right = sortHitPoint(right);

        return merge(left, right);
    }

    private static LinkedList<TreeNode> merge(LinkedList<TreeNode> left, LinkedList<TreeNode> right) {
        LinkedList<TreeNode> merged = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode leftNode = left.getFirst();
            TreeNode rightNode = right.getFirst();

            if (leftNode.getGeneral().getHitPoint() <= rightNode.getGeneral().getHitPoint()) {
                merged.addLast(leftNode);
                left.removeFirst();
            } else {
                merged.addLast(rightNode);
                right.removeFirst();
            }
        }

        // Add remaining elements from the left list
        while (!left.isEmpty()) {
            merged.addLast(left.getFirst());
            left.removeFirst();
        }

        // Add remaining elements from the right list
        while (!right.isEmpty()) {
            merged.addLast(right.getFirst());
            right.removeFirst();
        }

        return merged;
    }

    
}
