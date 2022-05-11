package iVisible;

import java.awt.Graphics;

public interface iVisible{
    public boolean clicked(int x, int y);
    public void paint (Graphics g, boolean focused);  
}