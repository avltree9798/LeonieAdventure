package com.av;

import com.av.gamescene.Title;
import lib.GameEngine;
import lib.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by root on 4/20/16.
 */
public class Game extends GameEngine implements MouseListener, KeyListener, MouseMotionListener{
    private JFrame frame = new JFrame();
    public static int FRAME_WIDTH = 0;
    public static int FRAME_HEIGHT = 0;
    private boolean zoom = true;
    private float spaceCount = 0;
    public Game(){
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(AssetManager.getInstance().logo);
        frame.setTitle("Leonie Adventure");
        activeScene = new Title(this);
        frame.add(this);
        setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        start();
        setFocusable(true);
    }
    @Override
    public void init() {
        activeScene.init();
    }

    @Override
    public void update(double tpf) {
        FRAME_WIDTH = frame.getWidth();
        FRAME_HEIGHT = frame.getHeight();
        activeScene.update(tpf);
        if(zoom)spaceCount += 50*tpf;
        else spaceCount -= 50*tpf;
        if(spaceCount>200)zoom = false;
        if(spaceCount<0)zoom = true;
        String s = "";for(int j=0;j<spaceCount;j++)s+=" ";
        s+= "Leonie Adventure";
        frame.setTitle(s);
        activeScene.update(tpf);
    }

    @Override
    public void render(Graphics2D g2d) {
        activeScene.render(g2d);
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
    public void close(){
        stop();
        frame.dispose();
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
