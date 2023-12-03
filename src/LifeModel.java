
public class LifeModel {
    public Cell[][] world;

    // default constructor creates a 10-by-10 world of dead Cells
    public LifeModel() {
        world = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                world[i][j] = new Cell();
            }
        }
        // don't forget to replace all those nulls with actual Cell refs!
        // TO DO

    }

    // creates an initial  world, numRows by numCols, of dead Cells
    public LifeModel(int numRows, int numCols) {
        world = new Cell[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                world[i][j] = new Cell();
            }
        }
        //TO DO
    }

    public Cell[][] worldCopy(){
        return world;
    }

    public LifeModel nextGen(){
        LifeModel newWorld = new LifeModel();
        Cell[][] worldCopy = worldCopy();

        for(int r = 0; r < world.length; r++){
            for(int c = 0; c < world[0].length; c++) {
                if (world[r][c].isAlive()) {
                    if (countNeighbors(r, c) < 2 || countNeighbors(r, c) > 3) {
                        worldCopy[r][c].setAlive(false);
                    }
                }else if (countNeighbors(r, c) == 3) {
                    worldCopy[r][c].setAlive(true);
                }
            }
        }
        newWorld.world = worldCopy;
        return newWorld;
    }

    public int countNeighbors(int r, int c){
        int count = 0;
        for(int row = r - 1; row <=r + 1; row++){
            if(row < 0 || row >= world.length){
                continue;
            }
            for(int col = c - 1; col <= c + 1; col++) {
                if (col < 0 || col >= world[0].length || (row == r && col == c)) {
                    continue;
                }
                if (world[row][col].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

}