import java.util.Scanner;
// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 7
public class hashFunctions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299, 5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412, 5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589, 5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871, 5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
        int[][] table = null;
        int choice = 0;
        Functions Hashfun = new Functions();
        do { //displays the menu
            table = new int[50][2];
            System.out.println("\n-----MAIN MENU--------------------------------------\n1. Run HF1 (Division method with Linear Probing)\n2. Run HF2 (Division method with Quadratic Probing)\n3. Run HF3 (Division method with Double Hashing)\n4. Run HF4 (Student Designed HF)\n5. Exit program\n\nEnter option number:");
            choice = Integer.parseInt(scan.nextLine()); // user input of choice
            while (choice < 1 || choice > 5) { //if choice is out of bounds they should re-enter a new choice
                System.out.println("Please choose a number between 1 - 5");
                choice = Integer.parseInt(scan.nextLine());
            }
            System.out.println();
            switch (choice) {
                case 1: // Division method with Linear Probing
                    Hashfun.HF1(table, keys);
                    System.out.print("Hash table resulted from HF1:\n\nIndex \tKey \tprobes\n------------------------\n");
                    for (int i = 0; i < 50; i++) {
                        System.out.println("  " + i + " \t" + table[i][0] + " \t" + table[i][1]);
                    }
                    System.out.print("------------------------\n\nSum of probe values = " + Hashfun.sumProbes(table) + " probes.\n");
                    break;
                case 2: // Division method with Quadratic Probing
                    Hashfun.HF2(table, keys);
                    System.out.print("Hash table resulted from HF2:\n\nIndex \tKey \tprobes\n------------------------\n");
                    for (int i = 0; i < 50; i++) {
                        System.out.println("  " + i + " \t" + table[i][0] + " \t" + table[i][1]);
                    }
                    System.out.print("------------------------\n\nSum of probe values = " + Hashfun.sumProbes(table) + " probes.\n");
                    break;
                case 3: //
                    Hashfun.HF3(table, keys);
                    System.out.print("Hash table resulted from HF3:\n\nIndex \tKey \tprobes\n------------------------\n");
                    for (int i = 0; i < 50; i++) {
                        System.out.println("  " + i + " \t" + table[i][0] + " \t" + table[i][1]);
                    }
                    System.out.print("------------------------\n\nSum of probe values = " + Hashfun.sumProbes(table) + " probes.\n");
                    break;
                case 4: //
                    Hashfun.HF4(table, keys);
                    System.out.print("Hash table resulted from HF4:\n\nIndex \tKey \tprobes\n------------------------\n");
                    for (int i = 0; i < 50; i++) {
                        System.out.println("  " + i + " \t" + table[i][0] + " \t" + table[i][1]);
                    }
                    System.out.print("------------------------\n\nSum of probe values = " + Hashfun.sumProbes(table) + " probes.\n");
                    break;
                case 5: //terminates program
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 5);
    }
}
class Functions{ // all hashing functions
    public boolean check(int[][] table,int data){ // checks to see if the key has been placed
        for(int i = 0; i < 50; i ++){
            if (table[i][0] == data){
                return true;
            }
        }
        return false;
    }
    public void HF1(int[][] table, int[] keys){ // Division method with Linear Probing
        int x, num;
        for (int data: keys) {
            num = data;
            if (table[(data % 50)][0] == 0){
                table[data % 50][0] = data;
            }
            else {
                x = 1;
                while (check(table,num) == false){
                    if (table[((data + x) % 50)][0] == 0){
                        table[((data + x) % 50)][0] = data;
                    }
                    table[((data + x) % 50)][1] += 1;
                    x++;
                }
            }
        }
    }
    public void HF2(int[][] table, int[] keys){ // Division method with Quadratic Probing
        int x=1, num;
        for (int data: keys) {
            num = data;
            if (table[data % 50][0] == 0){
                table[data % 50][0] = data;
            }
            else {
                while (check(table,num) == false){
                    if (table[((data + x^2) % 50)][0] == 0){
                        table[((data + x^2) % 50)][0] = data;
                    }
                    table[((data + x^2) % 50)][1] += 1;
                    x++;
                }
            }
        }
    }
    public void HF3(int[][] table, int[] keys){ // Division method with Double Hashing
        int H2;
        for (int data: keys) {
            if (table[data % 50][0] == 0){
                table[data % 50][0] = data;
            }
            else {
                H2 = (30 - data) % 25;
                for (int j = 1; j < 51; j++) {
                    if (table[Math.abs(((data + (j * H2)) % 50))][0] == 0) {
                        table[Math.abs(((data + (j * H2)) % 50))][0] = data;
                        table[Math.abs(((data + (j * H2)) % 50))][1] += 1;
                        break;
                    }
                    table[Math.abs(((data + (j * H2)) % 50))][1] += 1;
                }
                if (check(table,data) == false){
                    for (int j = 1; j < 51; j++) {
                        table[Math.abs(((data + (j * H2)) % 50))][1] -= 1;
                    }
                    System.out.println("Unable to hash key " + data + " to the table\n");
                }
            }
        }
    }
    public void HF4(int[][] table, int[] keys) { // Multiplication method with Quadratic Probing
        for (int data : keys) {
            /*
            using the Multiplication method for hashing
             */
            if (table[(int) (50 * (data*.003 % 1))][0] == 0) {
                table[(int) (50 * (data*.003 % 1))][0] = data;
            }
            else{
                /*
                My collision Resolution technique involves quadratic probing
                I probe in both the positive and negative direction to search for a valid empty index
                If it takes more than 4 attempts than that key is unable to be hashed
                With the given keys this method doesn't hash 3 keys and probes 74 times
                 */
                for (int j = 1; j < 5; j++){
                    if (((int) (50 * (data*.003 % 1)) + j^2) < 50) {
                        if (table[(int) (50 * (data * .003 % 1)) + j^2][0] == 0) {
                            table[(int) (50 * (data * .003 % 1)) + j^2][0] = data;
                            table[(int) (50 * (data * .003 % 1)) + j^2][1] += 1;
                            break;
                        }
                        table[(int) (50 * (data * .003 % 1)) + j^2][1] += 1;
                    }
                    if (((int) (50 * (data*.003 % 1)) - j^2) > -1) {
                        if (table[(int) (50 * (data * .003 % 1)) - j^2][0] == 0) {
                            table[(int) (50 * (data * .003 % 1)) - j^2][0] = data;
                            table[(int) (50 * (data * .003 % 1)) - j^2][1] += 1;
                            break;
                        }
                        table[(int) (50 * (data * .003 % 1)) - j^2][1] += 1;
                    }
                    }
                }

                if (check(table,data) == false){
                    for (int j = 1; j < 5; j++) {
                        if (((int) (50 * (data*.003 % 1)) + j^2) < 50) {
                            table[(int) (50 * (data * .003 % 1)) + j^2][1] -= 1;
                        }
                        if (((int) (50 * (data*.003 % 1)) - j^2) > -1) {
                            table[(int) (50 * (data * .003 % 1)) - j^2][1] -= 1;
                        }
                    }
                    System.out.println("Unable to hash key " + data + " to the table\n");
                }
        }
        }
    public int sumProbes(int[][] table){ // sums all the probes
        int sum = 0;
        for (int i = 0; i < 50; i++){
            sum += table[i][1];
        }
        return sum;
    }
}

