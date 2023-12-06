package Scrutineer;

import Scrutineer.DB.DancerDAO;
import Scrutineer.Participants.Dancer;
import Scrutineer.Utils.DataSetGeneric;


public class Main {

    public static void main(String[] args) {
        // Get all dancers from the database
        DancerDAO dancerDAO = new DancerDAO();
        DataSetGeneric<Dancer> dancers = dancerDAO.findAll();
        printDancers(dancers);


    }

    private static void printDancers(DataSetGeneric<Dancer> dancers) {
        for (Dancer dancer : dancers) {
            System.out.println(dancer.toString());
        }
    }
}
