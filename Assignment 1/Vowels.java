import java.util.Scanner;
// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 1
public class Vowels {
     // The main method displays the menu and allows you to choose your option
        public static void main(String[] args) {
            boolean end = false;
            Scanner scan = new Scanner(System.in);
            String word = null;
            int choice, vowels = 0;
            do{
                System.out.println("---------MAIN MENU---------\n" +
                        "1. Read input string\n" +
                        "2. Compute number of vowels\n" +
                        "3. Exit program\n\n" +
                        "Enter option number: ");
                choice = Integer.parseInt(scan.nextLine());
                System.out.println();
                switch(choice){
                    case 1: // case 1 takes in an input string and stores it
                    System.out.println("Enter input string: ");
                    word = scan.nextLine();
                        System.out.println();
                    break;
                    case 2: // case 2 calls the countVowels method passing in the stored word
                        vowels = countVowels(word);
                        System.out.println("You entered string: " + word + "\nNumber of vowels: " + vowels);
                    break;
                    case 3: // case 3 ends the do while loop
                        end = true;
                    break;
                    default: // default lets you know that you did not input a valid option
                        end = false;
                        System.out.println("Please enter a valid input\n");
                        break;
                }
            } while (end == false);
        }
        // countVowels counts the vowels in a passed in word through recursion
        public static int countVowels(String s1) {
            if (s1.length() <= 1){
                // if the string is 1 letter or less check to see if the char is a vowel if so return 1
                if (s1.toLowerCase().charAt(0) == 'a'||s1.toLowerCase().charAt(0) == 'e'||s1.toLowerCase().charAt(0) == 'i'||s1.toLowerCase().charAt(0) == 'o'||s1.toLowerCase().charAt(0) == 'u'){
                    return 1;
                }
                return 0;
            }
            // if the first letter is a vowel, call the method with the frist letter taken off and add 1
            if (s1.toLowerCase().charAt(0) == 'a'||s1.toLowerCase().charAt(0) == 'e'||s1.toLowerCase().charAt(0) == 'i'||s1.toLowerCase().charAt(0) == 'o'||s1.toLowerCase().charAt(0) == 'u'){
                return countVowels(s1.substring(1)) + 1;
            }
            // if the first letter is not a vowel, call the method with the frist letter taken off
            else return countVowels(s1.substring(1));
        }
}