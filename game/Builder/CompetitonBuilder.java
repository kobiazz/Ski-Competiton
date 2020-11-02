package game.Builder;

import game.arena.ArenaFactory;
import game.arena.WinterArena;
import game.competition.WinterCompetition;
import game.entities.sportsman.WinterSportsman;
import game.enums.*;

public class CompetitonBuilder implements IcompetitionBuilder {
    public WinterCompetition cmp;
    public WinterArena arena;
    public WinterSportsman ws = new WinterSportsman("Tamir",30, Gender.MALE,3,30, Discipline.FREESTYLE);
    @Override
    public void buildCompetitor() {
        ws.clone();
    }

    @Override
    public void buildArena() {
        arena = (WinterArena) ArenaFactory.getArena("Winter",900, SnowSurface.POWDER, WeatherCondition.SUNNY);
    }

    @Override
    public void buildCompetition() {
        cmp = new WinterCompetition(arena,10,ws.getDiscipline(), League.SENIOR,Gender.MALE);
    }
}
