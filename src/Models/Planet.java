package Models;

import Utils.Defaults;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Planet {
    private String name;
    private BufferedImage texture;
    private int radiusRotation;
    private int radiusPlanet;

    Planet(String name, int radiusRotation, int radiusPlanet) {
        this.name = name;
        this.radiusRotation = radiusRotation;
        this.radiusPlanet = radiusPlanet;
        this.texture = createResizedCopy(getTextureImage(), radiusPlanet * 2, radiusPlanet * 2);
    }

    public String getName() {
        return name;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public int getRadiusRotation() {
        return radiusRotation;
    }

    public int getRadiusPlanet() {
        return radiusPlanet;
    }

    public Rectangle2D.Double getRectName(Graphics2D graphics2D, double x, double y) {
        return new Rectangle2D.Double((float) x - radiusPlanet, (float) y,
                graphics2D.getFontMetrics().stringWidth(name), Defaults.LABEL_FONT.getSize());
    }

    private Image getTextureImage() {
        return new ImageIcon("src\\planets\\" + name.toLowerCase() + ".png").getImage();
    }

    private BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight) {
        BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.dispose();
        return scaledImage;
    }

}
