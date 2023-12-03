import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LifeGUIView {
    private DrawingPanel panel;
    private LifeModel model;

    int usedCornerX;
    int usedCornerY;
    public LifeGUIView() {
        panel = new DrawingPanel(1601, 980);
        model = new LifeModel(16, 32);

        usedCornerX = 0;
        usedCornerY = 0;
    }

    public void drawLayout() {
        Graphics g = panel.getGraphics();
        for (int i = 0; i < 17; i++) {
            g.drawLine(0, i * 50 + 75, 1600, i * 50 + 75);
        }
        for (int i = 0; i < 33; i++) {
            g.drawLine(i * 50, 75, i * 50, 875);
        }

        g.setColor(Color.BLUE);
        g.fillRect(0, 876, 1601, 104);
        g.fillRect(0, 0, 1601, 75);

        g.setColor(Color.CYAN);
        g.fillRect(5, 5, 1591, 65);
        g.fillRect(5, 881, 1591, 94);

        g.setColor(Color.GRAY);
        g.fillRect(346, 886, 259, 83);

        g.setColor(Color.BLUE);
        g.fillRect(694, 876, 212, 104);

        g.setColor(Color.GREEN);
        g.fillRect(950, 890, 151, 75);

        g.setColor(Color.RED);
        g.fillRect(700, 876, 201, 104);

        Font myFont = new Font("Courier New", Font.BOLD, 75);
        g.setFont(myFont);
        g.drawString("GAME OF LIFE", 550, 60);

        g.setColor(Color.BLACK);
        g.fillRect(350, 890, 251, 75);

        Font companyFont = new Font("Times New Roman", Font.ITALIC, 13);
        g.setFont(companyFont);
        g.drawString("@ Sang Nguyen Industries", 1450, 16);

        Font creatorFont = new Font("Times New Roman", Font.ITALIC, 40);
        g.setFont(creatorFont);
        g.drawString("John Conway's", 280, 40);

        g.drawLine(280, 42, 520, 42);

        g.drawRect(950, 890, 150, 74);

        Font myFont2 = new Font("Courier New", Font.BOLD, 45);
        g.setFont(myFont2);

        g.drawString("CLEAR", 955, 940);

        g.setColor(Color.WHITE);
        g.drawString("RANDOMIZE", 355, 940);

        //I had extra time so I hard-coded the 'NEXT GEN' to how I like it ;)
        g.drawLine(737, 879, 737, 925);
        g.drawLine(737, 879, 749, 879);
        g.drawLine(749, 879, 749, 925);
        g.drawLine(749, 925, 761, 925);
        g.drawLine(761, 925, 761, 879);

        g.drawLine(771, 879, 771, 925);
        g.drawLine(771, 879, 795, 879);
        g.drawLine(771, 902, 791, 902);
        g.drawLine(771, 925, 795, 925);

        g.drawLine(805, 879, 829, 925);
        g.drawLine(805, 925, 829, 879);

        g.drawLine(839, 879, 863, 879);
        g.drawLine(851, 879, 851, 925);

        g.drawLine(754, 930, 754, 976);
        g.drawLine(754, 930, 778, 930);
        g.drawLine(754, 976, 778, 976);
        g.drawLine(778, 976, 778, 953);
        g.drawLine(778, 953, 766, 953);

        g.drawLine(788, 930, 788, 976);
        g.drawLine(788, 930, 812, 930);
        g.drawLine(788, 953, 808, 953);
        g.drawLine(788, 976, 812, 976);

        g.drawLine(822, 976, 822, 930);
        g.drawLine(822, 930, 834, 930);
        g.drawLine(834, 930, 834, 976);
        g.drawLine(834, 976, 846, 976);
        g.drawLine(846, 976, 846, 930);
    }

    public void GUINextGen() {
        model = model.nextGen();

        Graphics g = panel.getGraphics();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 32; j++) {
                if (model.world[i][j].isAlive()) {
                    g.setColor(Color.ORANGE);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * 50 + 1, i * 50 + 76, 49, 49);
            }
        }
    }

    public void clear() {
        Graphics g = panel.getGraphics();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 32; j++) {
                if ((model.world[i][j].isAlive())) {
                    g.setColor(Color.WHITE);
                    g.fillRect(j * 50 + 1, i * 50 + 76, 49, 49);
                    model.world[i][j].setAlive(false);
                }
            }
        }
    }

    public void randomize() {
        Graphics g = panel.getGraphics();
        Random r = new Random();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 32; j++) {
                model.world[i][j].setAlive(r.nextBoolean());
                if (model.world[i][j].isAlive()) {
                    g.setColor(Color.ORANGE);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * 50 + 1, i * 50 + 76, 49, 49);
            }
        }
    }

    public void processClick(DrawingPanel panel, int x, int y) {
        int cornerX = x - (x % 50);
        int cornerY = y - ((y + 25) % 50);

        Graphics g = panel.getGraphics();

        if (x > 699 && x < 901 && y > 875 && y < 980) {
            GUINextGen();
        } else if (x > 949 && x < 1101 && y > 889 && y < 965) {
            clear();
        } else if (x > 349 && x < 601 && y > 889 && y < 965) {
            randomize();
        } else if (y < 875 && y > 74 && x < 1600 && model.world[cornerY / 50 - 1][cornerX / 50].isAlive()) {
            g.setColor(Color.WHITE);
            g.fillRect(cornerX + 1, cornerY + 1, 49, 49);
            model.world[cornerY / 50 - 1][cornerX / 50].setAlive(false);
        } else if (y < 875 && y > 74 && x < 1600) {
            g.setColor(Color.ORANGE);
            g.fillRect(cornerX + 1, cornerY + 1, 49, 49);
            model.world[cornerY / 50 - 1][cornerX / 50].setAlive(true);
        }
    }

    public void processDrag(DrawingPanel panel, int x, int y) {
        int cornerX = x - (x % 50);
        int cornerY = y - ((y + 25) % 50);

        Graphics g = panel.getGraphics();
        if (x < this.usedCornerX || x > this.usedCornerX + 49 || y < this.usedCornerY || y > this.usedCornerY + 49) {
            if (y < 875 && y > 74 && x < 1600 && model.world[cornerY / 50 - 1][cornerX / 50].isAlive()) {
                g.setColor(Color.WHITE);
                g.fillRect(cornerX + 1, cornerY + 1, 49, 49);
                model.world[cornerY / 50 - 1][cornerX / 50].setAlive(false);
                this.usedCornerX = cornerX;
                this.usedCornerY = cornerY;
            } else if (y < 875 && y > 74 && x < 1600) {
                g.setColor(Color.ORANGE);
                g.fillRect(cornerX + 1, cornerY + 1, 49, 49);
                model.world[cornerY / 50 - 1][cornerX / 50].setAlive(true);
                this.usedCornerX = cornerX;
                this.usedCornerY = cornerY;
            }
        }
    }


    public void run() {
        drawLayout();
        JOptionPane.showMessageDialog(null, "Welcome to John Conway's Game of Life!");
        panel.onMouseClick((x, y) -> processClick(panel, x, y));
        panel.onMouseDrag((x, y) -> processDrag(panel, x, y));
    }

    public static void main(String[] args) {
        LifeGUIView app = new LifeGUIView();
        app.run();

    }
}