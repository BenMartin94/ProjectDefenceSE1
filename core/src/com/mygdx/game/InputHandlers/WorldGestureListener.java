package com.mygdx.game.InputHandlers;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Utils.GestureData;

import java.util.Observable;

public class WorldGestureListener extends Observable implements GestureDetector.GestureListener {
    private boolean panning;
    private boolean zoom;
    private boolean pinch;
    private GestureData gestureData;

    public WorldGestureListener(){
        panning = false;
        zoom = false;
        pinch = false;
        gestureData = new GestureData();
    }


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        gestureData.clearData();
        gestureData.gestureType = "touchDown";
        gestureData.add(x);
        gestureData.add(y);
        setChanged();
        notifyObservers();
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        gestureData.clearData();
        gestureData.gestureType = "pan";
        gestureData.add(x);
        gestureData.add(y);
        gestureData.add(deltaX);
        gestureData.add(deltaY);
        setChanged();
        notifyObservers();
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        gestureData.clearData();
        gestureData.gestureType = "zoom";
        gestureData.add(initialDistance);
        gestureData.add(distance);
        setChanged();
        notifyObservers();
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        gestureData.clearData();
        gestureData.gestureType = "pinch";
        gestureData.add(initialPointer1.x);
        gestureData.add(initialPointer1.y);
        gestureData.add(initialPointer2.x);
        gestureData.add(initialPointer2.y);
        gestureData.add(pointer1.x);
        gestureData.add(pointer1.y);
        gestureData.add(pointer2.x);
        gestureData.add(pointer1.y);
        setChanged();
        notifyObservers();
        return false;
    }

    @Override
    public void pinchStop() {

    }

    public GestureData getData(){
        return gestureData;
    }
}
