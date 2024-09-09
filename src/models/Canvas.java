package models;

import models.shapes.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Canvas extends JFrame implements Runnable{

    private Point mousePosition;

    private int width, height;

    public Canvas(int _width, int _height) {
        this.width = _width;
        this.height = _height;
        BufferedImage menuBuffer = new BufferedImage(width * 5 / 32, height, BufferedImage.TYPE_INT_ARGB);
        setTitle("Paint");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new Menu(menuBuffer));
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void run() {
        double time = System.currentTimeMillis();
        while(true) {
            mousePosition = getMousePosition();
            if(mousePosition != null) {
                // tracking time and logging every 100 milliseconds
                if(System.currentTimeMillis() - time > 100) {
                    time = System.currentTimeMillis();
                    // System.out.println("x: " + mousePosition.x);
                    // System.out.println("y: " + mousePosition.y);
                }
                // todo: track mouse movement
            }
        }
    }
}