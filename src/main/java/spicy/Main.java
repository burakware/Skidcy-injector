package spicy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    //spicy: removed this method but skidcy;;;;;;;;;;;;;;
    public static void main(final String[] args) {
        final StringBuilder sb = new StringBuilder();
        try {
            final Scanner sc = new Scanner(new File(String.valueOf(System.getProperty("user.home")) + "/Desktop/Spicy", "sopid.txt"));
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            System.out.println(sb.toString());
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final File file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        Util.attach(sb.toString(), file);
        }
    }
}
