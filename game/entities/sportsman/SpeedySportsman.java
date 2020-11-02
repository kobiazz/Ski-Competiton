package game.entities.sportsman;

public class SpeedySportsman extends WSDecorator {
    private double acceleration;

    public SpeedySportsman(IWinterSportsman ws, double acceleration) {
        super(ws);
        this.acceleration += acceleration;

    }

    @Override
    public double getAcceleration() {
        return acceleration;
    }
}
