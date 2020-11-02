package game.entities.sportsman;

import game.arena.IArena;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class WinterSportsman extends Sportsman implements IWinterSportsman {
    private final Discipline discipline;
    private Point finish;
    private IArena arena;
    private double accelerationExtra;
    private double distancePassed;
    private static final double DISTANCE_TO_UPDATE = 10;
    private String color;
    private WinterSportsman ws = null;

    private int count = 1;

    public WinterSportsman(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline) {
        super(name, age, gender, acceleration, maxSpeed);
        this.discipline = discipline;
        this.accelerationExtra = 0.0;
        this.color = "blue";
    }

    @Override
    public void initRace() {
        this.setLocation(new Point(0, this.getLocation().getY()));
    }

    @Override
    public void initRace(Point p, Point f, IArena arena) {
        this.setLocation(p);
        this.finish = f;
        this.arena = arena;
        this.distancePassed = 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getName();
    }

    //region Getters & setters
    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public double getAcceleration() {
        return super.getAcceleration() + League.calcAccelerationBonus(this.getAge());
    }


    private boolean competitionInProgress() {
        boolean res = getLocation().getX() < finish.getX();
        Point p = getLocation();
        if (!res) setLocation(new Point(finish.getX(), p.getY()));
        return res;
    }


    @Override
    public void run() {
        while (competitionInProgress()) {
            move(arena.getFriction());
            distancePassed += getLocation().getX() - distancePassed;
            if (distancePassed > DISTANCE_TO_UPDATE * count) {
                setChanged();
                notifyObservers("updateDistance");
                distancePassed -= DISTANCE_TO_UPDATE;
                count++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        setChanged();
        notifyObservers("finish");
    }


    public void setAccelerationExtra(double accelerationExtra) {
        this.accelerationExtra = accelerationExtra;
    }

    public double getAccelerationExtra() {
        return accelerationExtra;
    }

    @Override
    public String getColor() {
        return color;
    }

    public WinterSportsman clone() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = null;
        try {
            c = cl.loadClass("game.entities.sportsman." + "Ski" + "er");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor con = null;
        try {
            con = c.getConstructor(String.class, double.class, Gender.class, double.class, double.class, Discipline.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            ws = (WinterSportsman) con.newInstance(getName(), getAge(), getGender(), getAcceleration(), getMaxSpeed(),getDiscipline());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return ws;
    }
}