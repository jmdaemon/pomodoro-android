package pomodoro;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
//import com.sun.jna.Library.FieldOrder;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.*;

public class Pomodoro {
    /*
    public static native Timer init_timer(int sbreak, int lbreak);
    public static native int to_secs(int mins);

    static {
        //Native.register(Platform.C_LIBRARY_NAME);
        //Native.register(Platform.libpomodoro);
        //Native.register("libpomodoro");
        Native.register("pomodoro");
    }

    public static void main(String[] args) {
        //System.out.println("cos(0)=" + cos(0));
        //System.out.println("sin(0)=" + sin(0));
        int sbreak = to_secs(10);
        int lbreak = to_secs(30);
        Timer timer = init_timer(sbreak, lbreak);
        //System.out.println(timer.shortbreak, timer.longbreak);
        System.out.printf("Shortbreak: %d, Longbreak: %d\n", timer.shortbreak, timer.longbreak);
    }
    */

    public interface PomodoroLib extends Library {
    PomodoroLib INSTANCE = (PomodoroLib)
        //Native.load((Platform.isWindows() ? "msvcrt" : "c"),
                            //CLibrary.class);
        Native.load("pomodoro", PomodoroLib.class);

    //void printf(String format, Object... args);
    //@FieldOrder({"maxlength", "curlength", "fillchar", "emptychar", "leftmargin", "rightmargin", "cur", "end"})
    //public static class ProgressBar extends Structure {
        //NativeLong maxlength;
        //NativeLong curlength;

        //byte fillchar;
        //byte emptychar;
        //byte leftmargin;
        //byte rightmargin;

        //long cur;
        //long end;
    //}

    //@FieldOrder({ "shortbreak", "longbreak", "interval_count", "pb", "workintervals" })
    @FieldOrder({ "shortbreak", "longbreak", "interval_count", "workintervals" })
    public static class Timer extends Structure {
          public int shortbreak;
          public int longbreak;
          public int interval_count;
          //ProgressBar pb;
          public int[] workintervals = new int[4];
    }

    public Timer init_timer(int sbreak, int lbreak);
    public int to_secs(int mins);
    }

    public static void main(String[] args) {
        PomodoroLib lib = PomodoroLib.INSTANCE;
        //System.out.println("cos(0)=" + cos(0));
        //System.out.println("sin(0)=" + sin(0));
        int sbreak = lib.to_secs(10);
        int lbreak = lib.to_secs(30);
        PomodoroLib.Timer timer;
        //Timer timer = PomodoroLib.INSTANCE.init_timer(sbreak, lbreak);
        //PomodoroLib.Timer timer = lib.init_timer(sbreak, lbreak);
        timer = lib.init_timer(sbreak, lbreak);
        //System.out.println(timer.shortbreak, timer.longbreak);
        System.out.printf("Shortbreak: %d, Longbreak: %d\n", timer.shortbreak, timer.longbreak);
    }
}
