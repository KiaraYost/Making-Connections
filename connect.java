import java.util.*;

public class connect{
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        try {
            int numComputers = stdin.nextInt();
            int numTasks = stdin.nextInt();
            int task;
            int comp1;
            int comp2;

            //parents start as leaf nodes
            Pair[] parents = new Pair[numComputers+1];
            for(int i = 1; i <= numComputers; i++) {
                parents[i] = new Pair(i, 0, 1);
            }

            for(int i = 0; i < numTasks; i++) {
                task = stdin.nextInt();

                //pair of computers is being connected
                if(task == 1) {
                    comp1 = stdin.nextInt();
                    comp2 = stdin.nextInt();
                    union(parents, comp1, comp2);
                }
                //query
                else findConnectivity(parents, numComputers);
            }

        } catch (InputMismatchException e) {
            System.out.println("ERROR: Please enter integers only.");
        }
    }

    //returns the root node of the tree storing ID
    static int find(Pair[] parents, int ID) {
        //go up tree until there's no parent
        while(ID != parents[ID].getID()) {
            ID = parents[ID].getID();
        }
        return ID;
    }

    static void union(Pair[] parents, int comp1, int comp2) {
        int root1 = find(parents, comp1);
        int root2 = find(parents, comp2);

        //no union needed
        if(root1 == root2) return;

        //attach tree 2 to tree 1 and increase size of tree 1
        if(parents[root1].getHeight() > parents[root2].getHeight()) {
            parents[root2].setID(root1);
            parents[root1].incSize(parents[root2].getSize());
        }
        //attach tree 1 to tree 2 and increase size of tree 2
        else if(parents[root1].getHeight() < parents[root2].getHeight()) {
            parents[root1].setID(root2);
            parents[root2].incSize(parents[root1].getSize());
        }
        //attach tree 2 to tree 1, adjust height and size
        else {
            parents[root2].setID(root1);
            parents[root1].incSize(parents[root2].getSize());
            parents[root1].incHeight();
        }
    }

    static void findConnectivity(Pair[] parents, int numComputers) {
        int numGroups = 0;
        long sumSizesSqrd = 0;

        for(int i = 1; i <= numComputers; i++) {
            //if i is root node
            if(i == find(parents, i)) {
                numGroups++;
                sumSizesSqrd += Math.pow(parents[i].getSize(), 2);
            }
        }

        long gcd = gcd(sumSizesSqrd, numGroups);

        System.out.println(sumSizesSqrd/gcd + "/" + numGroups/gcd);
    } 

    static long gcd(long a, long b) {
        if(b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }
}

class Pair {
    private int ID;
    private int height;
    private int size;

    public Pair(int myNum, int myHeight, int mySize) {
        ID = myNum;
        height = myHeight;
        size = mySize;
    }

    public int getHeight() {
        return height;
    }

    public int getID() {
        return ID;
    }

    public void incHeight() {
        height ++;
    }

    public int getSize() {
        return size;
    }

    public void incSize(int otherSize) {
        size += otherSize;
    }

    public void setID(int newID) {
        ID = newID;
    }
}