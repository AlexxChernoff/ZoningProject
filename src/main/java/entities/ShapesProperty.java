package entities;

import javafx.scene.paint.Color;

public class ShapesProperty {

    private String fillColor;
    private double fillColorOpacity;
    private String strokeColor;
    private double strokeColorOpacity;
    private int strokeWeight;
    private FillPattern fillPattern;

    public ShapesProperty(Color fillColor, double fillColorOpacity, Color strokeColor, double strokeColorOpacity, int strokeWeight) {
        this.fillColor = convertColor(fillColor);
        this.fillColorOpacity = fillColorOpacity;
        this.strokeColor = convertColor(strokeColor);
        this.strokeColorOpacity = strokeColorOpacity;
        this.strokeWeight = strokeWeight;
    }

    public Color getFillColor() {
        return Color.web(fillColor);
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = convertColor(fillColor);
    }

    public double getFillColorOpacity() {
        return fillColorOpacity;
    }

    public void setFillColorOpacity(double fillColorOpacity) {
        this.fillColorOpacity = fillColorOpacity;
    }

    public Color getStrokeColor() {
        return Color.web(strokeColor);
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = convertColor(strokeColor);
    }

    public double getStrokeColorOpacity() {
        return strokeColorOpacity;
    }

    private String convertColor(Color color) {
        return String.format( "#%02x%02x%02x",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    public void setStrokeColorOpacity(double strokeColorOpacity) {
        this.strokeColorOpacity = strokeColorOpacity;
    }

    public int getStrokeWeight() {
        return strokeWeight;
    }

    public void setStrokeWeight(int strokeWeight) {
        this.strokeWeight = strokeWeight;
    }

    public FillPattern getFillPattern() {
        return fillPattern;
    }

    public void setFillPattern(FillPattern fillPattern) {
        this.fillPattern = fillPattern;
    }

    @Override
    public String toString() {
        return "{" +
                "\"fillColor\":\"" + fillColor + "\"" +
                ", \"fillColorOpacity\":" + fillColorOpacity +
                ", \"strokeColor\":\"" + strokeColor + "\"" +
                ", \"strokeColorOpacity\":" + strokeColorOpacity +
                ", \"strokeWeight\":" + strokeWeight +
                ", \"fillPattern\":" + fillPattern +
                '}';
    }
}
