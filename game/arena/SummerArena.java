package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import utilities.ValidationUtils;


    public class SummerArena extends WinterArena implements IArena {

        private double length;
        private SnowSurface surface;
        private WeatherCondition condition;


        /**
         * Ctor for a generic arena
         * @param length the length of the arena
         * @param surface the snow surface of the arena
         * @param condition the weather condition in the arena
         */
        public SummerArena(double length, SnowSurface surface, WeatherCondition condition) {
            super(length,surface,condition);
        }

        @Override
        public double getFriction(){
            return surface.getFriction();
        }

        @Override
        public boolean isFinished(IMobileEntity mobileEntity) {
            ValidationUtils.assertNotNull(mobileEntity);
            return mobileEntity.getLocation().getX() >= length;
        }

        public double getLength() {
            return length;
        }

    }



