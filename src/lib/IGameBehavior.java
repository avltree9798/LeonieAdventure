package lib;

import java.awt.*;

/**
 * Created by root on 4/20/16.
 */
public interface IGameBehavior {
    public void init();
    public void update(double tpf);
    public void render(Graphics2D g2d);
}
