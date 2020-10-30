package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int number_of_tickets;
    private static int ticket_rows;
    private static int ticket_cols;
    private static int FILL_MAX_COLS;

    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of tickets to generate : ");
            number_of_tickets = sc.nextInt();

            System.out.print("Enter rows in each ticket : ");
            ticket_rows = sc.nextInt();

            System.out.print("Enter column in each ticket : ");
            ticket_cols = sc.nextInt();

            System.out.print("Enter Maximum column in each ticket : ");
            FILL_MAX_COLS = sc.nextInt();

            if(number_of_tickets<=0 || ticket_rows<=0 || ticket_cols<=0 || FILL_MAX_COLS<=0 ){
                System.out.println("Error : only positive integers allowed!");
                throw new Exception("only positive Numbers allowed!");
            }
            if (ticket_cols < FILL_MAX_COLS) {
                System.out.print("Maximum COLS in a Ticket cannot be greater than columns in ticket!");
                throw new Exception("Maximum COLS in a Ticket cannot be greater than columns in ticket!");
            }
        }catch(InputMismatchException ime){
            System.out.print("Error : Only Numbers Allowed!");
        }catch(Exception e){}

        TicketGenerator ticketGenerator = new TicketGenerator(number_of_tickets,ticket_rows,ticket_cols,FILL_MAX_COLS);

        for (int[][] ticket : ticketGenerator.getTickets()) {

            System.out.println("---------------------------------");
            for (int[] row : ticket) {
                for (int elem : row) {
                    System.out.printf("%4d", elem);
                }
                System.out.println();
            }
        }
    }
}
