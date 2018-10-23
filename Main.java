import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean notOk = true;
        Scanner in = new Scanner(System.in);

        System.out.print("Welcome to AirtelTigo, create a secret pin(4): ");

        //loop though until the user enters a valid secret pin
        while(notOk) {
            int scpin = in.nextInt();
            if (scpin > 999 && scpin <= 9999 && scpin != 0000) {
                if (scpin == 1234 || scpin == 0000 || scpin == 1111) {
                    System.out.println("Enter a more secure pin");
                    continue;
                } else {
                notOk = false;
                Intro intro = new Intro(scpin);
                intro.msg();
                }
            } else {
                System.out.println("Enter a valid digit number");
                continue;
            }
        }

    }
}