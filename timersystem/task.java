import java.util.Scanner;

class TimerRunnable implements Runnable {
    private int totalSeconds;

    public TimerRunnable(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    @Override
    public void run() {
        try {
            while (totalSeconds >= 0) {
                int minutes = totalSeconds / 60;
                int seconds = totalSeconds % 60;

                System.out.printf("Қалған уақыт: %02d:%02d\n", minutes, seconds);

                Thread.sleep(1000);
                totalSeconds--;
            }
            System.out.println("⏰ Таймер аяқталды!");
        } catch (InterruptedException e) {
            System.out.println("Қате пайда болды");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Минут енгізіңіз: ");
        int minutes = sc.nextInt();

        int totalSeconds = minutes * 60;

        Thread timer = new Thread(new TimerRunnable(totalSeconds));
        timer.start();
    }
}