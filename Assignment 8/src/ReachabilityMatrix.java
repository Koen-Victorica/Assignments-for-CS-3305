import java.util.Scanner;

// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 8
public class ReachabilityMatrix {
    public static void main(String[] args) {// menu
        Methods methods = new Methods();
        int Mn = 0, choice = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Matrix Size:");
        Mn = Integer.parseInt(scan.nextLine());
        while (Mn < 1 || Mn > 5) { //if choice is out of bounds they should re-enter a new choice
            System.out.println("Please choose a number between 1 - 5");
            Mn = Integer.parseInt(scan.nextLine());
        }
        int[][] edges = null;
        System.out.println();
        do {
            System.out.print("------MAIN MENU------\n1. Enter graph data\n2. Print outputs\n3. Exit program\nEnter option number:");
            choice = Integer.parseInt(scan.nextLine());
            while (choice < 1 || choice > 3) { //if choice is out of bounds they should re-enter a new choice
                System.out.println("Please choose a number between 1 - 5");
                choice = Integer.parseInt(scan.nextLine());
            }
            System.out.println();
            switch (choice){
                case 1: // populates the edges
                     edges = new int[Mn][Mn];
                    for (int j = 0; j < Mn; j++) {
                        for (int i = 0; i < Mn; i++) {
                            System.out.println("Enter A" + (j + 1) + "[" + j + "," + i + "]:");
                            edges[j][i] = Integer.parseInt(scan.nextLine());;
                            System.out.println();
                        }
                    }
                    break;
                case 2: //prints all outputs
                    if (edges == null) {
                        System.out.println("Please selecet option 1 before option 2");
                        System.out.println();
                    break;
                    }
                        methods.printInput(edges, Mn);
                        methods.printReachability(edges, Mn);
                        methods.inDegree(edges, Mn);
                        methods.outDegree(edges, Mn);
                        methods.tLoops(edges, Mn);
                        methods.tCycle(edges, Mn);
                        methods.P1(edges, Mn);
                        methods.PN(edges, Mn);
                        methods.P1N(edges, Mn);
                        methods.C1N(edges, Mn);
                        System.out.println();
                        break;
                case 3: //terminates program
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 3);
    }
}
    class Methods {
        public void printInput(int[][] Edges, int num) { // prints A1
            System.out.print("Input Matrix:\n");
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.print(Edges[i][j] + " \t");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }

        public void printReachability(int[][] Edges, int num) { // Finds and prints the Reachability Matrix
            int[][] A1 = Edges, A2 = new int[num][num], A3 = new int[num][num], A4 = new int[num][num], A5 = new int[num][num], K = new int[num][num];
            if (num >= 2) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A2[i][j] += Edges[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 3) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A3[i][j] += A2[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 4) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A4[i][j] += A3[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 5) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A5[i][j] += A4[i][k] * A1[k][j];
                        }
                    }
                }
            }
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    K[i][j] = A1[i][j] + A2[i][j] + A3[i][j] + A4[i][j] + A5[i][j];
                }
            }
            System.out.print("Reachability Matrix:\n");
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.print(K[i][j] + " \t");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }

        public void inDegree(int[][] Edges, int num) { // Finds and prints the sum of In-Degrees per node
            int[] sum = new int[num];
            int temp = 0;
            for (int i = 0; i < num; i++) {
                temp = 0;
                for (int j = 0; j < num; j++) {
                    temp += Edges[j][i];
                }
                sum[i] = temp;
            }
            System.out.print("In-degrees:\n");
            for (int i = 0; i < num; i++) {
                System.out.print("Node " + (i + 1) + " in-degree is " + sum[i]);
                System.out.print("\n");
            }
            System.out.print("\n");
        }

        public void outDegree(int[][] Edges, int num) { // Finds and prints the sum of Out-Degrees per node
            int[] sum = new int[num];
            int temp = 0;
            for (int i = 0; i < num; i++) {
                temp = 0;
                for (int j = 0; j < num; j++) {
                    temp += Edges[i][j];
                }
                sum[i] = temp;
            }
            System.out.print("Out-degrees:\n");
            for (int i = 0; i < num; i++) {
                System.out.print("Node " + (i + 1) + " out-degree is " + sum[i]);
                System.out.print("\n");
            }
            System.out.print("\n");
        }

        public void tLoops(int[][] Edges, int num) { // Finds and prints the total number of self loops
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += Edges[i][i];
            }
            System.out.print("Total number of self-loops: ");
            System.out.print(sum);
            System.out.print("\n");
        }

        public void tCycle(int[][] Edges, int num) { // Finds and prints the total number of cycles at node N
            int sum = 0;
            int[][] A1 = Edges, A2 = new int[num][num], A3 = new int[num][num], A4 = new int[num][num], A5 = new int[num][num];
            if (num >= 2) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A2[i][j] += Edges[i][k] * Edges[k][j];
                        }
                    }
                }
            }
            if (num >= 3) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A3[i][j] += A2[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 4) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A4[i][j] += A3[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 5) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A5[i][j] += A4[i][k] * A1[k][j];
                        }
                    }
                }
            }
            for (int i = 0; i < num; i++) {
                switch (num) {
                    case 1:
                        sum += A1[i][i];
                        break;
                    case 2:
                        sum += A2[i][i];
                        break;
                    case 3:
                        sum += A3[i][i];
                        break;
                    case 4:
                        sum += A4[i][i];
                        break;
                    case 5:
                        sum += A5[i][i];
                        break;
                }
            }
            System.out.print("Total number of cycles of length " + num + " edges: ");
            System.out.print(sum);
            System.out.print("\n");
        }

        public void P1(int[][] Edges, int num) { // Finds and prints the total number of paths of length 1
            int sum = 0;
            for (int j = 0; j < num; j++) {
                for (int i = 0; i < num; i++) {
                    sum += Edges[i][j];
                }
            }
            System.out.print("Total number of paths of length 1 edge: ");
            System.out.print(sum);
            System.out.print("\n");
        }

        public void PN(int[][] Edges, int num) { // Finds and prints the total number of paths of length N
            int sum = 0;
            int[][] A1 = Edges, A2 = new int[num][num], A3 = new int[num][num], A4 = new int[num][num], A5 = new int[num][num];
            if (num >= 2) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A2[i][j] += Edges[i][k] * Edges[k][j];
                        }
                    }
                }
            }
            if (num >= 3) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A3[i][j] += A2[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 4) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A4[i][j] += A3[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 5) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A5[i][j] += A4[i][k] * A1[k][j];
                        }
                    }
                }
            }
            for (int j = 0; j < num; j++) {
                for (int i = 0; i < num; i++) {
                    switch (num) {
                        case 1:
                            sum += A1[i][j];
                            break;
                        case 2:
                            sum += A2[i][j];
                            break;
                        case 3:
                            sum += A3[i][j];
                            break;
                        case 4:
                            sum += A4[i][j];
                            break;
                        case 5:
                            sum += A5[i][j];
                            break;
                    }
                }
            }
                System.out.print("Total number of paths of length " + num + " edges: ");
                System.out.print(sum);
                System.out.print("\n");
            }
        public void P1N(int[][] Edges, int num) { // Finds and prints the total number of paths of length 1 - N
            int sum = 0;
            int[][] A1 = Edges, A2 = new int[num][num], A3 = new int[num][num], A4 = new int[num][num], A5 = new int[num][num];
            if (num >= 2) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A2[i][j] += Edges[i][k] * Edges[k][j];
                        }
                    }
                }
            }
            if (num >= 3) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A3[i][j] += A2[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 4) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A4[i][j] += A3[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 5) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A5[i][j] += A4[i][k] * A1[k][j];
                        }
                    }
                }
            }
            for (int j = 0; j < num; j++) {
                for (int i = 0; i < num; i++) {
                            sum += A1[i][j];
                            sum += A2[i][j];
                            sum += A3[i][j];
                            sum += A4[i][j];
                            sum += A5[i][j];
                }
            }
            System.out.print("Total number of paths of length 1 to " + num + " edges: ");
            System.out.print(sum);
            System.out.print("\n");
        }
        public void C1N(int[][] Edges, int num) { // Finds and prints the total number of Cycles of length 1 - N
            int sum = 0;
            int[][] A1 = Edges, A2 = new int[num][num], A3 = new int[num][num], A4 = new int[num][num], A5 = new int[num][num];
            if (num >= 2) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A2[i][j] += Edges[i][k] * Edges[k][j];
                        }
                    }
                }
            }
            if (num >= 3) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A3[i][j] += A2[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 4) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A4[i][j] += A3[i][k] * A1[k][j];
                        }
                    }
                }
            }
            if (num >= 5) {
                for (int k = 0; k < num; k++) {
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            A5[i][j] += A4[i][k] * A1[k][j];
                        }
                    }
                }
            }
                for (int i = 0; i < num; i++) {
                    sum += A1[i][i];
                    sum += A2[i][i];
                    sum += A3[i][i];
                    sum += A4[i][i];
                    sum += A5[i][i];
                }
            System.out.print("Total number of cycles of length 1 to " + num + " edges: ");
            System.out.print(sum);
            System.out.print("\n");
        }
    }



