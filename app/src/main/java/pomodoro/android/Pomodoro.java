package pomodoro.android;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.*;

public class Pomodoro {
    public interface PomodoroLib extends Library {
        PomodoroLib INSTANCE = (PomodoroLib)
            Native.load("pomodoro", PomodoroLib.class);

        @FieldOrder({ "shortbreak", "longbreak", "interval_count", "workintervals" })
        public static class Timer extends Structure {
              public int shortbreak;
              public int longbreak;
              public int interval_count;
              public int[] workintervals = new int[4];
        }

        public Timer init_timer(int sbreak, int lbreak);
        public int to_secs(int mins);
    }

    public static void main(String[] args) {
        PomodoroLib lib = PomodoroLib.INSTANCE;
        int sbreak = lib.to_secs(10);
        int lbreak = lib.to_secs(30);
        PomodoroLib.Timer timer;
        timer = lib.init_timer(sbreak, lbreak);
        System.out.printf("Shortbreak: %d, Longbreak: %d\n", timer.shortbreak, timer.longbreak);
    }
}
