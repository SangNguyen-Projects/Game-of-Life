/*
    The view is responsible for interaction with the user (via the console) as well as
    control of the model.
    Create a menu of choices:
    1. new game
    2. next generation
    3. next 100 generations
    4. quit

*/

public class LiveConsoleView {
    private LifeModel model;

}

/*
Methods needed in the class:
run() displays the world via the model's toString.
    It uses a "game loop" to repeatedly call displayMenu() and execute methods based on the user's choice.

displayMenu() does just that ;)

newGame() asks the user for the name of the file, for example "glider.dat", and it replaces the current model
    by creating a new one with the input file name.

nextGeneration() commands the model to compute the next gen, then calls model's toString to display the result

next100Generations() must call nextGeneration 100 times, waiting one second between each call.
    Use Thread.sleep(1000) to sleep for 1000 milliseconds.
 */
