package com.epam.junior.program.mario;

import java.util.Arrays;
import java.util.List;

public class RunMario {

    public static void main(String[] args) {
        MarioGame game = new MarioGame(MarioConstants.DEFAULT_LIVES, MarioConstants.DEFAULT_POINTS,
                MarioConstants.DEFAULT_STAR_PLACE, MarioConstants.MARIO_FORMS.SMALL, MarioConstants.MARIO_FORMS.SMALL);
        final List<String> story = Arrays.asList(args);
        game.runGame(story);
    }

}
