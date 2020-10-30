package game;

import java.util.*;

public class TicketGenerator {

    private List< int[][] > tickets;
    private static final int minInt = 1;
    private static final int maxInt = 10;

    public TicketGenerator(int number_of_tickets, int ticket_rows, int ticket_cols, int FILL_MAX_COLS) {
        this.tickets = new ArrayList<>();
        for (int n = 0; n < number_of_tickets ; n++) {
            int[][] ticket = createTicket(ticket_rows,ticket_cols,FILL_MAX_COLS);
            tickets.add(ticket);
        }
    }

    private int[][] createTicket(int ticket_rows, int ticket_cols,int FILL_MAX_COLS){
        int[][] ticket = new int[ticket_rows][ticket_cols];

        for (int i = 0; i < ticket_rows; i++) {
            fillRandomCols(ticket, ticket_cols, i ,FILL_MAX_COLS);
        }

        for (int col = 0; col < ticket_cols; col++) {
            applyRowRules(ticket_rows, ticket, col);

            //Fill only 2 rows
            List<Integer> list = new ArrayList<>();
            for (int row = 0; row < ticket_rows; row++) {
                list.add(ticket[row][col]);
            }
            if(!list.contains(0)){
                ticket[Util.random(0,2)][col] = 0;
            }
        }
        return ticket;
    }

    private void applyRowRules(int ticket_rows, int[][] ticket, int col) {

        for (int row = 0; row < ticket_rows; row++) {
            if(row==0){
                if(ticket[row][col]!= 0 && ticket[row][col] == ticket[row+1][col]){
                    getDifferentValue(ticket, col, row, row + 1);
                }
            }else if(row== ticket_rows - 1){
                if(ticket[row][col]!=0 && ticket[row][col] == ticket[0][col]){
                    getDifferentValue(ticket, col, row, row);
                }
            }else if(ticket[row][col]!= 0 &&  ticket[row][col] == ticket[row+1][col]){
                getDifferentValue(ticket, col, row, row);
            }
        }
    }

    private void getDifferentValue(int[][] ticket, int col, int row, int i) {
        int value = ticket[row][col];
        if (Math.abs(value) % 10 < 9) {
            ticket[i][col] = value + 1;
        } else {
            ticket[i][col] = value - 1;
        }
    }

    private void fillRandomCols(int[][] ticket, int ticket_cols, int row, int FILL_MAX_COLS) {
        List<Integer> listOfRandomCols = Util.random(0,ticket_cols,FILL_MAX_COLS);
        for (int col = 0; col < FILL_MAX_COLS  ; col++) {
            for (int i: listOfRandomCols) {
                if (i == 0) {
                    ticket[row][i] = Util.random(minInt, maxInt);
                } else {
                    ticket[row][i] =  Util.random(maxInt * i + minInt, maxInt * (i + 1));
                }
            }
        }
    }

    public List<int[][]> getTickets() {
        return tickets;
    }
}
