import models.Canvas;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Canvas canvas =  new Canvas(800, 600);
        new Thread(canvas).start();
    }
}