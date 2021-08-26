/*
 * To change this license header, choose License Headers in Project Properties.
 * To   this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queryrunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * QueryRunner takes a list of Queries that are initialized in
 * it's constructor
 * and provides functions that will call the various functions in
 * the QueryJDBC class
 * which will enable MYSQL queries to be executed. It also has
 * functions to provide the
 * returned data from the Queries. Currently the eventHandlers in
 * QueryFrame call these
 * functions in order to run the Queries.
 */
public class QueryRunner {

    public QueryRunner() {
        this.m_jdbcData = new QueryJDBC();
        m_updateAmount = 0;
        m_queryArray = new ArrayList<>();
        m_error = "";
        Scanner scanner = new Scanner(System.in); //creating scanner class
        // object.
        String filename; // holds the name of the file.

        System.out.println("\nWelocme to the budget right application!!!\n");

        this.m_projectTeamApplication="Budget Right"; //Holds the name of the

        System.out.print("Enter the filename: ");
        filename = scanner.nextLine();
        try {
            scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                //String queryText = scanner.nextLine();
                String queryString = "";
                String queryText = "";
                while(!queryString.contains("ENDOFQUERYSTRING"))
                {
                    queryString = scanner.nextLine();
                    if(!queryString.contains("ENDOFQUERYSTRING"))
                        queryText += " " + queryString  ;
                }
                queryText.replace(" ", "");
                String paramLine = scanner.nextLine();
                String likeParamLine = scanner.nextLine();
                String actionQueryValue = scanner.nextLine();
                String paramQueryValue = scanner.nextLine();

                if(paramLine.compareTo("null") == 0){
                    m_queryArray.add(new QueryData(queryText,null,
                            null, checkIsTrue(actionQueryValue),
                            checkIsTrue(paramQueryValue)));
                } else {
                    String[] values = paramLine.split(",");
                    String[] strValues = likeParamLine.split(",");
                    boolean[] boolValues = new boolean[strValues.length];
                    for(int i = 0; i < strValues.length; i++)
                    {
                        boolValues[i] = checkIsTrue(strValues[i]);
                    }

                    m_queryArray.add(new QueryData(queryText,
                            values, boolValues,
                            checkIsTrue(actionQueryValue),
                            checkIsTrue(paramQueryValue)));
                }

            }
            //closing scanner class object.
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    /**
     * checkIsTrue method converts the string to  boolean value
     * @param str The string whose bool value needs to be calculated is
     *            passed as a parameter.
     * @return boolean The decoded boolean value is returned.
     */

    public boolean checkIsTrue(String str)
    {
        if(str.toLowerCase().compareTo("true") == 0)
            return true;
        else
            return false;
    }

    /**
     * GetTotalQueries counts the number of queries.
     * @return int returns the total number of queries.
     */
    public int GetTotalQueries() {
        return m_queryArray.size();
    }

    /**
     * The method checks and returns the total number of parameterized queries.
     * @return int returns the total number of parameterised queries.
     */
    public int GetParameterAmtForQuery(int queryChoice) {
        QueryData e = m_queryArray.get(queryChoice);
        return e.GetParmAmount();
    }

    /**
     * The method will return the parameter values.
     * @param queryChoice needs to be entered.
     * @return String returns the parameter entered.
     */
    public String GetParamText(int queryChoice, int parmnum) {
        QueryData e = m_queryArray.get(queryChoice);
        return e.GetParamText(parmnum);
    }

    /**
     * The method will return the query text.
     * @param queryChoice needs to be entered.
     * @return String returns the query text.
     */
    public String GetQueryText(int queryChoice) {
        QueryData e = m_queryArray.get(queryChoice);
        return e.GetQueryString();
    }

    /**
     * Function will return how many rows were updated as a result
     * of the update query
     * @return Returns how many rows were updated
     */

    public int GetUpdateAmount() {
        return m_updateAmount;
    }

    /**
     * Function will return ALL of the Column Headers from the query
     * @return Returns array of column headers
     */
    public String[] GetQueryHeaders() {
        return m_jdbcData.GetHeaders();
    }

    /**
     * After the query has been run, all of the data has been captured into
     * a multi-dimensional string array which contains all the row's. For each
     * row it also has all the column data. It is in string format
     * @return multi-dimensional array of String data based on the resultset
     * from the query
     */
    public String[][] GetQueryData() {
        return m_jdbcData.GetData();
    }

    /**
     * Function will returns the name of application.
     * @return String which is application name is returned.
     */
    public String GetProjectTeamApplication() {
        return m_projectTeamApplication;
    }

    /**
     * Function will check if the passed query is an action query.
     * @param queryChoice query choice needs to be passed.
     * @return Returns true if it is an action query else returns false.
     */
    public boolean isActionQuery(int queryChoice) {
        QueryData e = m_queryArray.get(queryChoice);
        return e.IsQueryAction();
    }

    /**
     * Function will checks if the query is parameterised or not.
     * @param queryChoice querychoice number needs to be provided.
     * @return Returns true if it a parmeterised query else returns false.
     */
    public boolean isParameterQuery(int queryChoice) {
        QueryData e = m_queryArray.
                get(queryChoice);
        return e.IsQueryParm();
    }


    /**
     * This Function will execute the non action query.
     * @param queryChoice Query choice needs to be entered.
     * @param parms holds the string array of parameters.
     * @return boolean true if successful else returns false.
     */
    public boolean ExecuteQuery(int queryChoice, String[] parms) {
        boolean bOK = true;
        QueryData e = m_queryArray.get(queryChoice);
        bOK = m_jdbcData.ExecuteQuery(e.GetQueryString(), parms,
                e.GetAllLikeParams());
        return bOK;
    }

    /**
     * Function will execute the action queries.
     * @param queryChoice Query choice needs to be entered.
     * @param parms holds the string array of parameters.
     * @return boolean true if successful else returns false.
     */
    public boolean ExecuteUpdate(int queryChoice, String[] parms) {
        boolean bOK = true;
        QueryData e = m_queryArray.get(queryChoice);
        bOK = m_jdbcData.ExecuteUpdate(e.GetQueryString(), parms);
        m_updateAmount = m_jdbcData.GetUpdateCount();
        return bOK;
    }


    /**
     * Function will connect the database connection.
     * @param szHost which is hostname of the DB.
     * @param szUser which is username.
     * @param szPass which holds the password.
     * @param szDatabase which holds the database connection name.
     * @return boolean true if disconnects else returns false.
     */
    public boolean Connect(String szHost, String szUser, String szPass,
                           String szDatabase) {

        boolean bConnect = m_jdbcData.ConnectToDatabase(szHost, szUser,
                szPass, szDatabase);
        if (bConnect == false)
            m_error = m_jdbcData.GetError();
        return bConnect;
    }

    /**
     * Function will disconnect the database connection.
     * @return boolean true if disconnects else returns false.
     */
    public boolean Disconnect() {
        // Disconnect the JDBCData Object
        boolean bConnect = m_jdbcData.CloseDatabase();
        if (bConnect == false)
            m_error = m_jdbcData.GetError();
        return true;
    }

    /**
     * Function will return the error message.
     * @return String returns the error message.
     */
    public String GetError() {
        return m_error;
    }



    private QueryJDBC m_jdbcData; // QueryJDBC class object is created.
    private String m_error;  // which holds the error message.
    private String m_projectTeamApplication; // which holds the application
    // name.
    private ArrayList<QueryData> m_queryArray; //Which holds the arraylist of
    // queries.
    private int m_updateAmount; // used to hold the amount of rows been updated.

    /**
     * The main method calls various other function to function the program
     * as expected.
     * @param args A string containing the command line argument.
     */
    public static void main(String[] args) {
        char input = 'y';//To hold char value entered by user

        //creates scanner object.
        Scanner keyboard = new Scanner(System.in);


        //Creates the QueryRunner class object.
        final QueryRunner queryrunner = new QueryRunner();
        //Runs the GUI application
        if (args.length == 0) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new QueryFrame(queryrunner).setVisible(true);
                }
            });
        } else {
            do {
                //Runs the console application.
                if (args[0].equals("-console")) {
                    boolean test = queryrunner.Connect("mmcpsc502101team09" +
                                    ".cbqedax3b41a.us-east-1.rds.amazonaws.com",
                            "admin",
                            "praniknn", "mm_cpsc502101team09");
                    if (test == true) {
                        System.out.println("" +
                                "\n******Connection is " +
                                "successsful!!!*****\n");
                    } else {
                        System.out.println("\n***** Connection failed....*****\n");
                    }

                    //get the count of total number of queries.
                    int n = queryrunner.GetTotalQueries();

                    //loop to which traversed through all the queries.
                    for (int i = 0; i < n; i++) {
                        String[] myarray = new String[0];
                        System.out.println("\n" + (i + 1) + "). " + "Query: " +
                                "\n\n" +
                                queryrunner.GetQueryText(i) + "\n");
                        //Check if the query is parameterized query.
                        if (queryrunner.isParameterQuery(i)) {
                            System.out.println("This query is " +
                                    "parameterized....\n");
                            //checks how many parameters are included.
                            int amt = queryrunner.GetParameterAmtForQuery(i);
                            //Displays the number of parameters.
                            System.out.println("Number parameters needed " +
                                    "are: "
                                    + amt + "\n");
                            //Create a parameter array of strings for that amount
                            myarray = new String[amt];
                            for (int j = 0; j < amt; j++) {
                                System.out.print(queryrunner.GetParamText(i,
                                        j) + ":");
                                //Prompts user to enter the value of the text.
                                String value = keyboard.nextLine();
                                myarray[j] = value;
                            }
                        }
                        // If it is an Action Query then
                        if (queryrunner.isActionQuery(i)) {
                            //call ExecuteUpdate to run the Query
                            queryrunner.ExecuteUpdate(i, myarray);
                            System.out.println("\n*****Total" +
                                    " " +
                                    "number of rows updated are: " +
                                    queryrunner.GetUpdateAmount() + "*****\n");
                        } else {
                            //call ExecuteQuery
                            if (queryrunner.ExecuteQuery(i
                                    , myarray)) {
                                String[][] dataArray =
                                        queryrunner.GetQueryData();
                                System.out.println("OUTPUT:\n");
                                String[] header = queryrunner.GetQueryHeaders();
                                int[] maxColumnLengthArray =
                                        new int[header.length];
                                for (int col = 0; col < header.length; col++) {
                                    maxColumnLengthArray[col] = header[col].length();
                                    for (int row = 0; row < dataArray.length; row++) {
                                        if (dataArray[row][col] != null && maxColumnLengthArray[col] <
                                                dataArray[row][col].length()) {
                                            maxColumnLengthArray[col] =
                                                    dataArray[row][col].length();
                                        }
                                    }

                                }

                                for (int h = 0; h < header.length; h++) {
                                    System.out.printf
                                            ("%" + -maxColumnLengthArray[h]
                                                    + "s    ", header[h]);
                                }

                                System.out.println();

                                for (int row = 0; row < dataArray.length; row++) {
                                    for (int col = 0; col < dataArray[row].length;
                                         col++) {
                                        System.out.printf("%" +
                                                        -maxColumnLengthArray[col] + "s    ",
                                                dataArray[row][col]);
                                    }
                                    System.out.println();
                                }

                            }

                        }
                    }
                }
                //Asks the user if they want to repeat
                System.out.print("\nWould you like to repeat (y/n)? ");
                input = keyboard.next().charAt(0);
                System.out.println();
            } while(input == 'y');
            //Disconnects from console application.
            boolean discon =  queryrunner.Disconnect();
            if(discon == true)
                System.out.println("Disconnected!!\n");
            else
                System.out.println("Error in disconn ecting....\n");

        }

        System.out.println("\nThanks for using budget right application!!\n");
        //Closing the scanner class object.
        keyboard.close();
    }

}