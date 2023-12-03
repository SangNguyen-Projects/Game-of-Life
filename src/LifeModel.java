import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LifeModel {

    private Cell[][] world;

    // default constructor creates a 10-by-10 world of dead Cells
    public LifeModel() {
        world = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                world[i][j] = new Cell(false);
            }
        }
        // don't forget to replace all those nulls with actual Cell refs!
        // TO DO

    }

    // creates an initial  world, numRows by numCols, of dead Cells
    public LifeModel(int numRows, int numCols) {
        world = new Cell[numRows][numCols];
        //TO DO
    }

    /* creates initial world from fileName (assumed to be in folder "data"
    The first entry in fileName will be the number of desired rows,
    and the second must be the number of desired columns.
    The rest of the file contains one or more pairs of ints r c,
    and the constructor sets the Cells at those locations to be alive.
     */
    public LifeModel(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File("data/" + fileName));
        int count = 0;
        while (input.hasNext()) {
            world = new Cell[input.nextInt()][input.nextInt()];
        }
    }
    // TO DO
}

    // returns a pretty string representation of the world
    public String toString() {
        String s = "";
        // TO DO
        return s;
    }

    // a main for testing as you develop the class:
    public static void main(String[] args) throws FileNotFoundException {
        LifeModel model = new LifeModel("glider.dat");
        System.out.println(model);

    }

    /*
    methods needed in the model class
    toString(), of course, for pretty printing in the console
    worldState() returns a defensive copy of the world grid
    nextGen() computes the next generation according to the rules of Conway's GoL.
       Careful!  You cannot change a cell's status before you have applied the rules to EVERY cell
       (ie, use a second grid temporarily to store the next gen, then assign the 2nd grid to the field when done.
    nextGen() definitely needs help or it will be too complex.  How about...
    countNeighbors(int r, int c) returns the number of living neighbors of the Cell at (r,c)
    TEST EACH METHOD!!
     */
}
