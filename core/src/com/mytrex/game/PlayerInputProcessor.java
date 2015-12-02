package com.mytrex.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class PlayerInputProcessor implements InputProcessor
{
    private GameWorld world;

    public PlayerInputProcessor(GameWorld world)
    {
        this.world = world;
    }

    @Override
    public boolean keyDown(int keycode)
    {
        if (Input.Keys.LEFT == keycode) {
            world.getPlayer().setLeftMove(true);
            world.getPlayer().setIsLeft(true);
        }
        if (Input.Keys.RIGHT == keycode) {
            world.getPlayer().setRightMove(true);
            world.getPlayer().setIsLeft(false);
        }
        if (Input.Keys.UP == keycode && (world.isPlayerGrounded()))
        {
            world.getPlayer().setJump(true);
            world.getPlayer().getBody().applyLinearImpulse(0f, 100f, 0.5f, 0.5f, false);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if (Input.Keys.LEFT == keycode) world.getPlayer().setLeftMove(false);
        if (Input.Keys.RIGHT == keycode) world.getPlayer().setRightMove(false);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
