package lib;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by root on 4/20/16.
 */
public abstract class GameObject implements IGameBehavior, KeyListener, MouseListener, MouseMotionListener {
    public int x,y;
    public int width, height;
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void init() {

    }

    @Override
    public void update(double tpf) {

    }

    @Override
    public void render(Graphics2D g2d) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
