package Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Participants.Swimmer;
import Participants.superAthlete;

/*
 * Swimming Class
 *
 * This class is Swimming game activities
 *
 * Author:
 */

public class Swimming extends Games implements Sport {

    /**
     * Override method to calculate Swimming score
     *
     * @return score
     */
    @Override
    public String[] scores() {
        String[] score = new String[Games.getAttendAthlete().size()];
        for (int count = 0; count < Games.getAttendAthlete().size(); count++) {
            Random random = new Random();
            score[count] = String.format("%.1f", ((random.nextDouble() * 100.0d) + 100.0d));
        }
        return score;
    }

    /**
     * read data from txt file and select 4-8 athletes to attend swimming
     *
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException {

        ArrayList<String[]> attendSwimmingAthlete = new ArrayList<>();
        attendSwimmingAthlete.addAll(Swimmer.getSwimmer());
        attendSwimmingAthlete.addAll(superAthlete.getSuperathletes());
        super.selectRandomNumberAthlete(attendSwimmingAthlete);


    }

}
