package models.shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Menu extends JPanel {
    private final BufferedImage bufferedImage;
    private final int width, height;
    private Color selectedColor = Color.WHITE;

    private enum Option {
        LINE,
        CIRCLE,
        SQUARE,
        LINE_COLOR,
        LINE_TYPE,
        ERASE,
    }

    public Menu(BufferedImage _bufferedImage) {
        this.bufferedImage = _bufferedImage;
        this.width = _bufferedImage.getWidth();
        this.height = _bufferedImage.getHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = this.bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawMenu(graphics2D);

        g.drawImage(bufferedImage, 0, 0, this);
    }

    private void drawMenu(Graphics2D g2d) {
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, width - 1, height - 1);

        // Draw options
        int optionHeight = height / 6;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        int i = 0;
        g2d.setStroke(new BasicStroke(5));
        for(Option option: Option.values()) {
            int startingHeight = i * optionHeight + 1;
            int endingHeight = (i + 1) * optionHeight;
            g2d.drawRect(1, startingHeight, width - 3, endingHeight);

            switch (option) {
                case Option.LINE:
                    g2d.drawLine(30, endingHeight - 45, 95, startingHeight + 15);
                    g2d.drawString("LINEA", 42, endingHeight - 15);
                    break;
                case Option.CIRCLE:
                    g2d.drawOval(30, startingHeight + 15, 65, (endingHeight - startingHeight) / 2);
                    g2d.drawString("CIRCULO", 32, endingHeight - 15);
                    break;
                case Option.SQUARE:
                    g2d.drawRect(15, startingHeight + 15, 95, (endingHeight - startingHeight) / 2);
                    g2d.drawString("CUADRILATERO", 17, endingHeight - 15);
                    break;
                case Option.LINE_COLOR:
                    g2d.setColor(selectedColor);
                    g2d.fillRect(15, startingHeight + 15, 95, (endingHeight - startingHeight) / 2);
                    g2d.drawString("COLOR", 42, endingHeight - 15);
                    g2d.setColor(Color.BLACK);
                    break;
                case Option.LINE_TYPE:
                    BasicStroke dotted = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0);
                    g2d.setStroke(dotted);
                    g2d.drawLine(30, endingHeight - 45, 95, startingHeight + 15);
                    g2d.setColor(Color.BLACK);
                    g2d.drawString("LINEA", 42, endingHeight - 15);
                    g2d.setStroke(new BasicStroke(5));
                    break;
                case Option.ERASE:
                    g2d.setColor(Color.RED);
                    g2d.drawLine(30, endingHeight - 45, 95, startingHeight + 15);
                    g2d.drawLine(30, startingHeight + 15, 95, endingHeight - 45);
                    g2d.setColor(Color.BLACK);
                    g2d.drawString("ELIMINAR", 38, endingHeight - 15);
                    break;
            }
            i++;
        }
    }

}
