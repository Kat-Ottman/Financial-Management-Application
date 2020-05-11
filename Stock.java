public class Stock{
    String name;
    String tickerSymbol;
    double purchasePricePerShare;
    int numSharesAtPurchasePrice;
    QueryPrices q = new QueryPrices(); //made so QueryPrices class isn't static because static is stupid and makes things complicated

    //Initializes stock information
    Stock(String n, String ts){
        name = n;
        tickerSymbol = ts;
    }

    //Retrieves current value of stock based off number of stock shares given
    double FindStockPrice(String ts, int numShares){
        return numShares * GetCurrentValue(ts);
    }

    //Prints Stock informatoin
    @Override
    public String toString(){
        return "Name: " + name + ", Ticker symbol: " + 
        tickerSymbol + ", Purchase Price: " + purchasePricePerShare +
        ", # of Shares at Purchase Price: " + numSharesAtPurchasePrice;
    }

    /*
    If Hashmap of stocks has not be made, make it
    Returns current value of stock given by ticker symbol
    */
    double GetCurrentValue(String ts){
        if(q.pflag != 1){
            q.ReadInStocks();
        }

        return  (q.m.get(ts));
    }
};