/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smodel;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author alexa
 */
public class Line extends Shape {
    private double x2;
    private double y2;
    
    /**
     * 
     * @param x2
     * @param y2 
     */
    public Line(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;
        
    }
    
    public Line(){
        this(50.0, 50.0);
    }
    
    /**
     * @return x2-coordinate of end of line
     */
    public double getX2() {
        return x2;
    }

    /**
     * @return y2-coordinate of of end of the line
     */
    public double getY2() {
        return y2;
    }

    /**
     * Sets the new x2 coordinate of the end of the line
     *
     * @param newX2
     */
    public void setX2(double newX2) {
        x2 = newX2;
    }

    /**
     * Sets the new y2 coordinate of the of end of the line
     *
     * @param newY2
     */
    public void setY2(double newY2) {
        y2 = newY2;
    }
    
    @Override
    public void paint(GraphicsContext gc){
        
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(this.getX(), this.getY(), this.x2, this.y2);
    }
    
    /**
     * Constrains the shape inside the given area/box, by bouncing it off att
     * the edges. The shape is considered a point in this implementation which
     * causes erratic behaviour at the left and bottom edges. Subtypes must
     * override this method to correct this behaviour.
     *
     * @param boxX upper left corner of the "box"
     * @param boxY upper left corner of the "box"
     * @param boxWidth
     * @param boxHeight
     */
    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        double newDx=this.getDx();
        double newDy=this.getDy();
        // If outside the box - calculate new dx and dy
        
        if (x2-50 < boxX) {
            newDx = Math.abs(this.getDx());
        } else if (x2 > boxWidth) {
            newDx = -Math.abs(this.getDx());
        }
        if (y2-50 < boxY) {
            newDy = Math.abs(this.getDy());
        } else if (y2 > boxHeight) {
            newDy = -Math.abs(this.getDy());
        }
        this.setVelocity(newDx, newDy);
    }
    
    @Override
    public String toString() {
        String info
                = this.getClass().getName() + ": x=" + x2 + ", y=" + y2
                + ", color=" + this.getColor();
        return info;
    }
    
}
