

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

public class Cycling extends Games{



    /**
     * read data from txt file and select 4-8 athletes to attend cycling
     *
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException {
        ArrayList<String[]> attendCyclingAthlete = new ArrayList<>();
        attendCyclingAthlete.addAll(Cyclist.getCyclist());
        super.selectRandomNumberAthlete(attendCyclingAthlete);
    }

}
