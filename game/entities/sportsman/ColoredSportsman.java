package game.entities.sportsman;

import gui.ArenaPanel;

public class ColoredSportsman extends WSDecorator {

    private String color;

    public ColoredSportsman(IWinterSportsman ws, String color) {
        super(ws);
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }
}
