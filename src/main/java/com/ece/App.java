package main.java.com.ece;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {

        People people = new People();

        System.out.println("Enter q for exit : ");
        String input = "";

        Scanner scanIn = new Scanner(System.in);
        while (!input.equals("q")) {
            System.out.println("Enter a first name : ");
            String firstName = scanIn.nextLine();
            if(firstName.equals("q")) break;

            System.out.println("Enter a last name : ");
            String lastName = scanIn.nextLine();
            if(lastName.equals("q")) break;

            System.out.println("Enter an age : ");
            String age = scanIn.nextLine();
            if(age.equals("q")) break;

            System.out.println("Enter an email : ");
            String email = scanIn.nextLine();
            if(email.equals("q")) break;

            System.out.println("Enter a sex : ");
            String sex = scanIn.nextLine();
            if(sex.equals("q")) break;

            System.out.println("Enter a bff name : ");
            String bff = scanIn.nextLine();
            if(bff.equals("q")) break;

            System.out.println("Enter a friends name separate by comma (jean,dupont...) : ");
            String friendsStr = scanIn.nextLine();
            List<String> friends = Arrays.asList("".split(","));

            people.add(firstName, lastName, age, email, sex, bff, friends);
        }

        scanIn.close();
    }


}
