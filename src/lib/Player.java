package lib;

import com.av.AssetManager;

import java.awt.*;

/**
 * Created by root on 4/21/16.
 */
public abstract class Player extends GameObject{
    public boolean left, right, up, down;
    public int movement = 1;
    public Image me;
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void init() {
        movement=5;
    }

    @Override
    public void update(double tpf) {
        if(left)
            x-=movement;
        if(right)
            x+=movement;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawImage(me,x,y,width,height,null);
    }
}
