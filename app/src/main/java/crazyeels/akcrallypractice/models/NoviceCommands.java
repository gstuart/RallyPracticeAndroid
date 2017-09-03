package crazyeels.akcrallypractice.models;

import java.util.Random;

import crazyeels.akcrallypractice.R;

public class NoviceCommands {
    // List of Commands which will randomly displayed
    private Integer [] noviceCommands = {
            R.drawable.sign002,
            R.drawable.sign003,
            R.drawable.sign004,
            R.drawable.sign005,
            R.drawable.sign006,
            R.drawable.sign007,
            R.drawable.sign008,
            R.drawable.sign009,
            R.drawable.sign010,
            R.drawable.sign011,
            R.drawable.sign012,
            R.drawable.sign013,
            R.drawable.sign014,
            R.drawable.sign015,
            R.drawable.sign016,
            R.drawable.sign017,
            R.drawable.sign018,
            R.drawable.sign019,
            R.drawable.sign020,
            R.drawable.sign021,
            R.drawable.sign022,
            R.drawable.sign023,
            R.drawable.sign024,
            R.drawable.sign025,
            R.drawable.sign026,
            R.drawable.sign027,
            R.drawable.sign028,
            R.drawable.sign029,
            R.drawable.sign030,
            R.drawable.sign031,
            R.drawable.sign032,
            R.drawable.sign033,
            R.drawable.sign034,
            R.drawable.sign035,
            R.drawable.sign036,
            R.drawable.sign037,
            R.drawable.sign038,
            R.drawable.sign039,
            R.drawable.sign040,
            R.drawable.sign041,
            R.drawable.sign042
    };

    public Integer getNoviceCommand() {
    // Randomly display a command within the set parameters
        Random randomizer = new Random();
        int randomCommand = randomizer.nextInt(noviceCommands.length);

        return noviceCommands[randomCommand];


    }
}

