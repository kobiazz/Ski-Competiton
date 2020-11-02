package game.entities.sportsman;

import game.arena.IArena;
import utilities.Point;

import java.util.Observer;

public abstract class WSDecorator implements IWinterSportsman {
    protected IWinterSportsman ws;

    public WSDecorator(IWinterSportsman ws){
        this.ws = ws;
    }

    @Override
    public void initRace() {
        ws.initRace();
    }

    @Override
    public void initRace(Point p, Point f, IArena arena) {
        ws.initRace(p,f,arena);
    }

    @Override
    public void addObserver(Observer o) {
        ws.addObserver(o);
    }

    @Override
    public void move(double friction) {
        ws.move(friction);
    }

    @Override
    public Point getLocation() {
        return ws.getLocation();
    }

    @Override
    public double getSpeed() {
        return ws.getSpeed();
    }

    @Override
    public double getMaxSpeed() {
        return ws.getMaxSpeed();
    }

    @Override
    public double getAcceleration() {
        return ws.getAcceleration();
    }

    @Override
    public void run() {
        ws.run();
    }

    @Override
    public String getColor() {
        return ws.getColor();
    }
}
