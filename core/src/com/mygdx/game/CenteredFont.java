package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class CenteredFont extends BitmapFont {
    public void drawCentered(Batch batch, CharSequence str, int x, int y){
        GlyphLayout glyphLayout = new GlyphLayout();
        String item = "Example";
        glyphLayout.setText(this,item);
        float w = glyphLayout.width;

        int destX = x;//-(int)w/2;

        super.draw(batch, str, destX, y);
    }
}
