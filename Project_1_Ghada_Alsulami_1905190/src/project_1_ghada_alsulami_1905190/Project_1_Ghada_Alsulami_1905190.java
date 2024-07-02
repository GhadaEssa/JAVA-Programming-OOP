package project_1_ghada_alsulami_1905190;

import java.io.*;
import java.util.*;

public class Project_1_Ghada_Alsulami_1905190 {

    public static void main(String[] args) throws Exception {

        /*
         Student Name: Ghada Essa Alsulami 
         ID:1905190 
         Section Number:14313
         */
        // Create a file object to prepare reading the file input
        File inputFile = new File("input.txt");

        //  Scanner for reading data from input file
        //Check the input file if exist.
        if (!(inputFile.exists())) {
            System.out.println("The file " + inputFile.getName() + " doesn't exist.");
            System.exit(0);
        }

        Scanner input = new Scanner(inputFile);
        // 1D Array for regions
        String[] regions = new String[input.nextInt()];

        // 2D Array for cities
        String[][] cities = new String[regions.length][];
        for (int i = 0; i < regions.length; i++) {
            cities[i] = new String[input.nextInt()];
        }
        // 3D Array for years, and populations,and waterUsage
        String[][][] years = new String[regions.length][][];//[3]
        int[][][] populations = new int[regions.length][][];
        int[][][] waterUsage = new int[regions.length][][];
        int[][][] PerCapitaDailyUsageArray = new int[regions.length][][];
        for (int i = 0; i < regions.length; i++) {
            years[i] = new String[cities[i].length][];//[0][3]
            populations[i] = new int[cities[i].length][];
            waterUsage[i] = new int[cities[i].length][];
            PerCapitaDailyUsageArray[i] = new int[cities[i].length][];
        }

        //Create a file object to prepare writing a file.   
        File outputFile = new File("output.txt");
        //Create a PrintWriter object to write to the file
        PrintWriter output = new PrintWriter(outputFile);
        output.println("    ================================================================================================\n"
                + "    ||                                Saudi Arabia Water Resource Usage                           ||\n"
                + "    ================================================================================================\n");

        output.println("- Number of Regions: " + regions.length);
        output.println();

        String comand;
        do {

            comand = input.next();

            if (comand.equalsIgnoreCase("add_regions")) {
                add_regions(input, regions, output);
            } else if (comand.equalsIgnoreCase("add_cities")) {
                add_cities(input, regions, cities, output);
            } else if (comand.equalsIgnoreCase("add_populations")) {
                add_population(input, regions, cities, years,
                        populations, waterUsage, output);
            } else if (comand.equalsIgnoreCase("print_result")) {
                print_result(input, regions, cities, years,
                        populations, waterUsage, PerCapitaDailyUsageArray, output);
            } else if (comand.equalsIgnoreCase("find_lowest_usage")) {
                find_lowest_usage(input, regions, cities, years,
                        populations, waterUsage, PerCapitaDailyUsageArray, output);
            } else if (comand.equalsIgnoreCase("find_higest_usage")) {
                find_higest_usage(input, regions, cities, years,
                        populations, waterUsage, PerCapitaDailyUsageArray, output);

            } else if (comand.equalsIgnoreCase("about_developer")) {
                about_developer(output);
            }

        } while (!comand.equalsIgnoreCase("exit"));

        Date date = new Date();
        output.print("Thank You! :)\nReport generated on " + date.toString());

        output.flush();

        output.close();

        input.close();

    }//main

    //_________________________The regions method___________________________________________________
    public static void add_regions(Scanner input, String[] regions, PrintWriter output) {

        output.println("[Command] add_regions");

        for (int i = 0; i < regions.length; i++) {
            regions[i] = input.next();
            output.print("	+ " + regions[i]);
        }
        output.println();
    }

    //_________________________The cities method___________________________________________________
    public static void add_cities(Scanner input, String[] regions, String[][] cities, PrintWriter output) {

        output.println();
        output.println("[Command] add_cities");

        int index = getIndexOfRegions(input, regions);// function to get the index of the region

        output.println("	-> City: " + regions[index]);

        for (int i = 0; i < cities[index].length; i++) {
            cities[index][i] = input.next();
            output.print("	+ " + cities[index][i]);
        }
        output.println();
    }

//________________The Data (Population,years,waterUsage) method_______________________________________
    public static void add_population(Scanner input, String[] regions, String[][] cities, String[][][] years,
            int[][][] populations, int[][][] waterUsage, PrintWriter output) {

        output.println();
        output.println("[Command] add_population");

        int indexOfRegions = getIndexOfRegions(input, regions);
        int indexOfCities = getIndexOfCities(input, cities, indexOfRegions);

        output.println("	-> Region: " + regions[indexOfRegions]);
        output.println("	-> City: " + cities[indexOfRegions][indexOfCities]);

        int columns = input.nextInt();

        years[indexOfRegions][indexOfCities] = new String[columns];
        populations[indexOfRegions][indexOfCities] = new int[columns];
        waterUsage[indexOfRegions][indexOfCities] = new int[columns];

        output.println("    ------------------------------------------------------------------------");
        output.println("	Year      	Population		Annual Water Usage (cb.m)");

        for (int j = 0; j < columns; j++) {
            years[indexOfRegions][indexOfCities][j] = input.next();
            populations[indexOfRegions][indexOfCities][j] = input.nextInt();
            waterUsage[indexOfRegions][indexOfCities][j] = input.nextInt();

            output.print("	" + years[indexOfRegions][indexOfCities][j] + " \t\t");
            output.printf("%,1d", populations[indexOfRegions][indexOfCities][j]);
            output.print(" \t\t");
            output.printf("%,d", waterUsage[indexOfRegions][indexOfCities][j]);
            output.println();
        }

        output.println("    ------------------------------------------------------------------------");

    }

    //________________The  method of print results _______________________________________
    public static void print_result(Scanner input, String[] regions, String[][] cities, String[][][] years,
            int[][][] populations, int[][][] waterUsage, int[][][] PerCapitaDailyUsageArray, PrintWriter output) {

        output.println();
        output.println("[Command] print_result");

        int indexOfRegions = getIndexOfRegions(input, regions);
        int indexOfCities = getIndexOfCities(input, cities, indexOfRegions);

        output.println("	-> Region: " + regions[indexOfRegions]);
        output.println("	-> City: " + cities[indexOfRegions][indexOfCities]);

        output.println("    ---------------------------------------------------------------------------------------------------------------\n"
                + "	Year      	Population	Annual Water Usage (cb.m)	Per capita daily usage (l)	Change  \n"
                + "    ---------------------------------------------------------------------------------------------------------------");
        double waterUsageValue;
        double perCapitaDailyUsage = 0;
        double change;
        double perCapitaDailyUsage2 = 0;
        PerCapitaDailyUsageArray[indexOfRegions][indexOfCities] = new int[years[indexOfRegions][indexOfCities].length];
        for (int j = 0; j < years[indexOfRegions][indexOfCities].length; j++) {

            output.print("	" + years[indexOfRegions][indexOfCities][j] + " \t\t");
            output.printf("%,1d \t", populations[indexOfRegions][indexOfCities][j]);
            output.printf("%,d  \t\t\t", waterUsage[indexOfRegions][indexOfCities][j]);

            //Per capita daily usage (l)
            waterUsageValue = waterUsage[indexOfRegions][indexOfCities][j];
            perCapitaDailyUsage = ((waterUsageValue / (populations[indexOfRegions][indexOfCities][j] * 365)) * 1000);
            int perCapitaDailyUsageNarrowing = (int) perCapitaDailyUsage;
            PerCapitaDailyUsageArray[indexOfRegions][indexOfCities][j] = perCapitaDailyUsageNarrowing;
            // Print Per capita daily usage (l)

            output.print(perCapitaDailyUsageNarrowing + " \t\t");

            //Change
            if (j == 0) {
                output.print("\t\tNA");
            } else {
                waterUsageValue = waterUsage[indexOfRegions][indexOfCities][j - 1];
                perCapitaDailyUsage2 = ((waterUsageValue / (populations[indexOfRegions][indexOfCities][j - 1] * 365)) * 1000);
                int perCapitaDailyUsageNarrowing2 = (int) perCapitaDailyUsage2;

                change = (((double) perCapitaDailyUsageNarrowing - perCapitaDailyUsageNarrowing2) / perCapitaDailyUsageNarrowing2) * 100;

                output.printf("  \t\t%.2f%c", change, '%');

            }

            output.println();

        }

        output.print("    ---------------------------------------------------------------------------------------------------------------\n");

    }

    //________________The  method of find lowest usage _______________________________________  
    public static void find_lowest_usage(Scanner input, String[] regions, String[][] cities, String[][][] years,
            int[][][] populations, int[][][] waterUsage, int[][][] PerCapitaDailyUsage, PrintWriter output) {

        output.print("\n[Command] find_lowest_usage\n"
                + "	* The city with lowest per capita water usage in all regions\n"
                + "	------------------------------------------------------------------------------------------\n"
                + "	Year      	Population	Annual Water Usage (cb.m)	Per capita daily usage (l)	\n"
                + "	------------------------------------------------------------------------------------------\n");

        int lowestUsage = PerCapitaDailyUsage[0][0][0];
        int indexOfRegions = 0;
        int indexOfCities = 0;
        int indexOfWaterUsage = 0;
        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                for (int k = 0; k < waterUsage[i][j].length; k++) {
                    if (PerCapitaDailyUsage[i][j][k] < lowestUsage) {
                        lowestUsage = PerCapitaDailyUsage[i][j][k];

                        indexOfRegions = i;
                        indexOfCities = j;
                        indexOfWaterUsage = k;

                    }

                }
            }
        }
        output.print("	" + years[indexOfRegions][indexOfCities][indexOfWaterUsage] + " \t\t");
        output.printf("%,1d", populations[indexOfRegions][indexOfCities][indexOfWaterUsage]);
        output.print(" \t");
        output.printf("%,d\t\t\t", waterUsage[indexOfRegions][indexOfCities][indexOfWaterUsage]);
        output.println(lowestUsage);

        output.println("	------------------------------------------------------------------------------------------");
        output.println(" \tIn Region: " + regions[indexOfRegions] + "," + " City: " + cities[indexOfRegions][indexOfCities]);
    }

    //________________The  method of find higest usage _______________________________________   
    public static void find_higest_usage(Scanner input, String[] regions, String[][] cities, String[][][] years,
            int[][][] populations, int[][][] waterUsage, int[][][] PerCapitaDailyUsage, PrintWriter output) {

        output.print("\n[Command] find_higest_usage\n"
                + "	* The city with highest per capita water usage in all regions\n"
                + "	------------------------------------------------------------------------------------------\n"
                + "	Year      	Population	Annual Water Usage (cb.m)	Per capita daily usage (l)	\n"
                + "	------------------------------------------------------------------------------------------\n");

        int higestUsage = PerCapitaDailyUsage[0][0][0];
        int indexOfRegions = 0;
        int indexOfCities = 0;
        int indexOfWaterUsage = 0;
        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                for (int k = 0; k < waterUsage[i][j].length; k++) {
                    if (PerCapitaDailyUsage[i][j][k] > higestUsage) {
                        higestUsage = PerCapitaDailyUsage[i][j][k];

                        indexOfRegions = i;
                        indexOfCities = j;
                        indexOfWaterUsage = k;

                    }

                }
            }
        }
        output.print("	" + years[indexOfRegions][indexOfCities][indexOfWaterUsage] + " \t\t");
        output.printf("%,1d \t", populations[indexOfRegions][indexOfCities][indexOfWaterUsage]);
        output.printf("%,d\t\t\t", waterUsage[indexOfRegions][indexOfCities][indexOfWaterUsage]);
        output.println(higestUsage);

        output.println("	------------------------------------------------------------------------------------------");
        output.println(" \tIn Region: " + regions[indexOfRegions] + "," + " City: " + cities[indexOfRegions][indexOfCities]);
    }

    //___________________The developer INFORMATION________________________________________________
    public static void about_developer(PrintWriter INFO) {

        INFO.println("\n[Command] about_developer\n"
                + "	-> Developed By: Ghada Essa Alsulami\n"
                + "	-> University ID: 1905190\n"
                + "	-> Section: IAR\n"
                + "");

    }

    //________________This method for finding index of a region ____________________ 
    public static int getIndexOfRegions(Scanner input, String[] regions) {
        String s = input.next();
        int indexOfRegions = 0;
        for (int i = 0; i < regions.length; i++) {
            if (regions[i].equalsIgnoreCase(s)) {
                indexOfRegions = i;
            }

        }
        return indexOfRegions;
    }

    //________________This method for finding index of a cities ____________________ 
    public static int getIndexOfCities(Scanner input, String[][] cities, int indexOfRegions) {

        int indexOfCities = 0;
        String s1 = input.next();
        for (int j = 0; j < cities[indexOfRegions].length; j++) {
            if (cities[indexOfRegions][j].equalsIgnoreCase(s1)) {
                indexOfCities = j;
            }
        }

        return indexOfCities;

    }

}
