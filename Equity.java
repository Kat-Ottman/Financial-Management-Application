import java.util.ArrayList;
import java.lang.StringBuilder;

public class Equity extends Account {
    ArrayList<Stock> stocks = new ArrayList<Stock>();
    int totalValue;


    //Initializes basic account information
    Equity(String fn, String ln, String ma, int an){
        this.setFName(fn);
        this.setLName(ln);
        this.setMailingAdress(ma);
        this.setAccountNum(an);
    }

    //Writes Equity Account information to HTML
    @Override
    String GenerateHTML() {
        StringBuilder b = new StringBuilder();

        b.append(super.GenerateHTML());

        for(Stock s : stocks){
            b.append("<p> " + s.toString() + " \n </p>");
        }

        b.append("<p> Total Value of Equity Account: " + totalValue + "\n </p>");

        return b.toString();   
    }

    /*
    Changes Equity specific information based off stock price
    read in from Stocks.txt in QueryPrices class and 
    adds to stocks (transactions) list
    */
    @Override
    void buyStock(String n, String ts, int ns){
        Stock s = new Stock(n, ts);
        s.purchasePricePerShare = s.FindStockPrice(ts, 1);
        s.numSharesAtPurchasePrice = ns;
        totalValue += s.FindStockPrice(ts, ns);
        stocks.add(s);
    }

    //returns Equity balance
    @Override
    double getValue(){
        return totalValue;
    }
};