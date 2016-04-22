package lib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import static lib.Settings.*;
/**
 * Created by root on 4/20/16.
 */
public abstract class GameEngine extends JPanel implements IGameBehavior, MouseListener, KeyListener, MouseMotionListener {
    private boolean isRunning = true;
    private boolean isFirst = true;
    public Scene activeScene;
    private boolean isChangeScene;
    private Scene futureScene;
    public JFrame frame = new JFrame();
    BufferedImage r = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
    Thread t = new Thread(() -> {
        long lastTime = System.nanoTime();
        long currTime = System.nanoTime();
        double tpf = 0;
        while(isRunning){
            if(isFirst){
                isFirst = false;
                init();
            }
            lastTime = System.nanoTime();
            update(tpf);
            BufferedImage b = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_ARGB);
            render((Graphics2D) b.getGraphics());
            repaint();
            r = b.getSubimage(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
            try {
                Thread.sleep(1);
            }catch (InterruptedException e){}
            currTime = System.nanoTime();
            tpf = (currTime - lastTime) / 1000000000f;
            if (isChangeScene) {
                activeScene = futureScene;
                isFirst = true;
                isChangeScene = false;
            }
        }
    });

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, faceEffect));
        g2d.drawImage(r, 0, 0, getWidth(), getHeight(), this);
    }

    public void start(){
        t.start();
    }
    public void stop(){
        boolean isRetry = true;
        isRunning = false;
        while(isRetry){
            try {
                t.join();
                isRetry = false;
            }catch (Exception e){}
        }
    }
    public void changeScene(Scene scene) {
        isChangeScene = true;
        futureScene = scene;
    }
    @Override
    public void render(Graphics2D g2d) {
        activeScene.render(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        activeScene.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        activeScene.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        activeScene.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        activeScene.mouseClicked(e);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        activeScene.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        activeScene.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        activeScene.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        activeScene.mouseExited(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        activeScene.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        activeScene.mouseMoved(e);
    }
    public void close(){
        stop();
        frame.dispose();
        System.exit(0);
    }
}
