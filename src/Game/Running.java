package Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Participants.superAthlete;

/*
 * Running Class
 *
 * This class is Running game activities
 *
 * Author:
 */
public class Running extends Games implements Sport {

    /**
     * Override method to calculate running score
     *
     * @return score
     */
    @Override
    public String[] scores() {
        String[] score = new String[Games.getAttendAthlete().size()];
        for (int count = 0; count < Games.getAttendAthlete().size(); count++) {
            Random random = new Random();
            score[count] = String.format("%.2f", ((random.nextDouble() * 10.0d) + 10.0d));
        }
        return score;
    }

    /**
     * read data from txt file and select 4-8 athletes to attend running
     *
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException {

        ArrayList<String[]> attendRunningAthlete = new ArrayList<>();
        attendRunningAthlete.addAll(superAthlete.getSuperathletes());
        super.selectRandomNumberAthlete(attendRunningAthlete);
    }

}
