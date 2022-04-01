package pomodoro;

import com.sun.jna.*;

public class Pomodoro {
    public static native Timer init_timer(int sbreak, int lbreak);
    public static native int to_secs(int mins);

    static {
        //Native.register(Platform.C_LIBRARY_NAME);
        //Native.register(Platform.libpomodoro);
        Native.register("libpomodoro");
    }

    public static void main(String[] args) {
        //System.out.println("cos(0)=" + cos(0));
        //System.out.println("sin(0)=" + sin(0));
        Timer timer = init_timer(to_secs(10), to_secs(30));
        //System.out.println(timer.shortbreak, timer.longbreak);
        System.out.printf("Shortbreak: %d, Longbreak: %d\n", timer.shortbreak, timer.longbreak);
    }
}
