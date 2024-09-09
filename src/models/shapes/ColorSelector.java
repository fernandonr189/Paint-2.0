package models.shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorSelector extends JPanel {

    private final BufferedImage bufferedImage;
    private final int width, height;

    public ColorSelector(BufferedImage _bufferedImage) {
        this.bufferedImage = _bufferedImage;
        this.width = _bufferedImage.getWidth();
        this.height = _bufferedImage.getHeight();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, this);
    }
}
