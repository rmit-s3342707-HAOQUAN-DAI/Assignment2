import Participants.Cyclist;
import Participants.Sprinter;
import Participants.superAthlete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * Cycling Class
 *
 * This class is Cycling game activities
 *
 * Author:
 */

public class Cycling extends Games implements Sport {

    /**
     * Override method to calculate Cycling score
     *
     * @return score
     */
    @Override
    public String[] scores() {
        String[] score = new String[Games.getAttendAthlete().size()];
        for (int count = 0; count < Games.getAttendAthlete().size(); count++) {
            Random random = new Random();
            score[count] = String.format("%.1f", ((random.nextDouble() * 300.0d) + 500.0d));
        }
        return score;
    }

    /**
     * read data from txt file and select 4-8 athletes to attend cycling
     *
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException {
        ArrayList<String[]> attendCyclingAthlete = new ArrayList<>();
        attendCyclingAthlete.addAll(Cyclist.getCyclist());
        attendCyclingAthlete.addAll(Sprinter.getSprinter());
        attendCyclingAthlete.addAll(superAthlete.getSuperathletes());
        super.selectRandomNumberAthlete(attendCyclingAthlete);
    }

}
