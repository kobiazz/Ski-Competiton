package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;

import javax.swing.*;

public class ArenaFactory implements IArena{
    private static WinterArena winterArena;

    public static IArena getArena(String arena_type, double length, SnowSurface surface, WeatherCondition condition) {
        if (arena_type.equals("Winter"))
            winterArena =  new WinterArena(length,surface,condition);
        else if (arena_type.equals("Summer"))
            JOptionPane.showMessageDialog(null,"There is no SUMMER ARENA Man");

        return winterArena;
    }


    @Override
    public double getFriction() {
        return 0;
    }

    @Override
    public boolean isFinished(IMobileEntity mobileEntity) {
        return false;
    }

    @Override
    public double getLength() {
        return 0;
    }
}
