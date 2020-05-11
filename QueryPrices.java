import java.util.*;
import java.io.*;

public class QueryPrices {
    HashMap<String, Double> m = new HashMap<String, Double>();
    int pflag = 0; //makes sure no overloading of hashmap is done

    //Reads current values of stocks from Stocks.txt into HashMap m
    void ReadInStocks(){
        try{
            FileInputStream fstream = new FileInputStream("Stocks.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while((strLine = br.readLine()) != null){
                String[] tokens = strLine.split(" ");
                m.put(tokens[0], Double.valueOf(tokens[1]));
            }
            br.close();
            in.close();
        } catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
};