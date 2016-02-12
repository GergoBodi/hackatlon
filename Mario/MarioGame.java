package com.epam.junior.program.mario;

import java.util.List;

import com.epam.junior.program.mario.MarioConstants.MARIO_FORMS;

/**
 * Main class which runs the mario program.
 *
 * @author Gergo_Bodi
 *
 */
public class MarioGame {
    /**
     * The actual lives of Mario.
     */
    private int currentLives;
    /**
     * The actual points of Mario. Every 100 coin grants Mario an extra life.
     */
    private int currentPoints;
    /**
     * The place where the 'Star' string is located in the input.
     */
    private int starPlace;
    /**
     * Indicates Mario's state. (small, big, star, etc.)
     */
    private MARIO_FORMS currentForm;
    /**
     * If Mario is in Star form, this variable contains the form changes.
     */
    private MARIO_FORMS tempForm;

    /**
     * Constructor.
     *
     * @param lives
     * @param currentPoints
     * @param starPlace
     * @param currentForm
     * @param tempForm
     */
    public MarioGame(int lives, int currentPoints, int starPlace, MARIO_FORMS currentForm, MARIO_FORMS tempForm) {
        this.currentLives = lives;
        this.currentPoints = currentPoints;
        this.starPlace = starPlace;
        this.currentForm = currentForm;
        this.tempForm = tempForm;
    }

    public void runGame(final List<String> storyboard) {

        for (int i = 0; i < storyboard.size(); i++) {
            // If the star expired then the form has to be set to SMALL.
            if (i == getStarPlace()) {
                if (getTempForm() == MARIO_FORMS.SMALL) {
                    setCurrentForm(MARIO_FORMS.SMALL);
                } else {
                    setCurrentForm(getTempForm());
                }
            }

            handleStoryboardElement(storyboard.get(i), i);

            // If at the end Mario has more than zero lives and did not reach Bowser or Peach the game is draw.
            if (getCurrentLives() > 0 && i == storyboard.size() - 1) {
                System.out.println(MarioConstants.GAME_OVER_DRAW);
            }
        }
    }

    /**
     * Changes the state of the game based on the received storyboard element.
     *
     * @param storyboardElement
     *            the actual storyboard element
     * @param index
     *            index used for the iteration
     */
    private void handleStoryboardElement(final String storyboardElement, final int index) {
        if (storyboardElement.matches("[0-9]+")) {
            setCurrentPoints(currentPoints + Integer.parseInt(storyboardElement));
            if (getCurrentPoints() >= 100) {
                setCurrentLives(getCurrentLives() + (getCurrentPoints() / 100));
                setCurrentPoints(currentPoints % 100);
            }
        } else {
            switch (storyboardElement) {
                case MarioConstants.MUSHROOM:
                    ifMarioInStarForm(MARIO_FORMS.BIG);
                    break;
                case MarioConstants.UP1:
                    setCurrentLives(currentLives + 1);
                    break;
                case MarioConstants.STAR:
                    setCurrentForm(MARIO_FORMS.STAR);
                    setStarPlace(index + 3);
                    break;
                case MarioConstants.PRINCESS:
                case MarioConstants.BOWSER:
                    winnerState();
                    break;
                case MarioConstants.GOOMBA:
                case MarioConstants.KOOPA:
                case MarioConstants.PIRANHA:
                    enemyAttacks();
                    break;
                default:
                    System.out.println(MarioConstants.INCORRECT + index);
                    break;
            }
        }
    }

    /**
     * When input is an enemy then Mario loses a life according to his form. If he has not got more lives the game over.
     */
    private void enemyAttacks() {
        if (getCurrentForm() == MARIO_FORMS.STAR) {
        } else if (getCurrentForm() == MARIO_FORMS.BIG) {
            setCurrentForm(MARIO_FORMS.SMALL);
        } else {
            setCurrentLives(currentLives - 1);
        }
        if (getCurrentLives() == 0) {
            System.out.println(MarioConstants.GAME_OVER_LOSE);
            System.exit(0);
        }
    }

    /**
     * When the input is Princess or Bowser and Mario has got more than zero lives, Mario wins.
     */
    private void winnerState() {
        System.out.println(MarioConstants.GAME_OVER_WIN);
        System.exit(0);
    }

    /**
     * If Mario is in Star Form and a new form comes the temporary form will set that form.
     */
    private void ifMarioInStarForm(MARIO_FORMS comingForm) {
        if (getCurrentForm() == MARIO_FORMS.STAR) {
            setTempForm(comingForm);
        } else {
            setCurrentForm(MARIO_FORMS.BIG);
        }
    }

    public int getCurrentLives() {
        return currentLives;
    }

    public void setCurrentLives(int currentLives) {
        this.currentLives = currentLives;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public int getStarPlace() {
        return starPlace;
    }

    public void setStarPlace(int starPlace) {
        this.starPlace = starPlace;
    }

    public MARIO_FORMS getCurrentForm() {
        return currentForm;
    }

    public void setCurrentForm(MARIO_FORMS currentForm) {
        this.currentForm = currentForm;
    }

    public MARIO_FORMS getTempForm() {
        return tempForm;
    }

    public void setTempForm(MARIO_FORMS tempForm) {
        this.tempForm = tempForm;
    }

}
