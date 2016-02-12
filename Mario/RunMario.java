package com.epam.junior.program.mario;

import java.util.ArrayList;
import java.util.List;

public class RunMario {

    public static void main(String[] args) {
        MarioGame game = new MarioGame(MarioConstants.DEFAULT_LIVES, MarioConstants.DEFAULT_POINTS,
                MarioConstants.DEFAULT_STAR_PLACE, MarioConstants.MARIO_FORMS.SMALL);
        List<String> story = new ArrayList<String>();
        for(String element : args){
            if(element.length()>1) {
                story.add(element);
            }
        }
        game.runGame(story);
    }

}
