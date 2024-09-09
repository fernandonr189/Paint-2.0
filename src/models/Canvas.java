package models;

import models.shapes.ColorSelector;
import models.shapes.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Canvas extends JFrame{

    private Point mousePosition;

    private int width, height;

    private Color selectedColor = Color.WHITE;

    // Panes

    private Menu menu;
    private ColorSelector colorSelector;

    public Canvas(int _width, int _height) {
        this.width = _width;
        this.height = _height;
        BufferedImage menuBuffer = new BufferedImage(width * 5 / 32, height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage colorSelectorBuffer = new BufferedImage(width * 5 / 32, height / 6, BufferedImage.TYPE_INT_ARGB);
        setTitle("Paint");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Generate Panes
        menu = new Menu(menuBuffer);
        menu.setBounds(0, 0, menu.getWidth(), menu.getHeight());
        colorSelector = new ColorSelector(colorSelectorBuffer);
        colorSelector.setBounds(0, 0, colorSelector.getWidth(), colorSelector.getHeight());

        // Add panes to layeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(width, height));

        layeredPane.add(menu, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(colorSelector, JLayeredPane.PALETTE_LAYER);

        add(layeredPane);

        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}