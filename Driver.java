import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class Driver{

    public static void main(String[] args){
        List<Account> l = new ArrayList<Account>();

        Account a1 = new Checking("Dave", "Fallon", "8001 Winn Road, Spring Grove, IL 60081", 1, 2001.00);
        Account a2 = new Equity("Alexandra", "Trombley", "W5630 Vicki Terrace, Elkhorn, WI 53121", 2);
        Account a3 = new Checking("Roy", "Scott", "2001 Alford Park Drive, Kenosha, WI 53140", 3, 99.72);

        a1.MakeDeposit(26.72);
        a2.buyStock("Apple", "AAPL", 7);
        a3.MakeWithdrawal(103.79);

        l.add(a1);
        l.add(a2);
        l.add(a3);

        Collections.sort(l, Driver.BalanceComparator);

        Driver d = new Driver();

        d.generateReport(l);
    }

    //Creates file and writes account information to file
    void generateReport(List<Account> a){
        Report r = new Report();
        r.GenerateFile();
        r.WriteToFile(a);
    }

    //Compares balances of accounts
    public static Comparator<Account> BalanceComparator = new Comparator<Account>(){
        @Override
        public int compare(Account a1, Account a2){
            int retVal = 0;

            if(a1.getValue() < a2.getValue()){
                retVal = -1;
            } else if (a1.getValue() > a2.getValue()){
                retVal = 1;
            }

            return retVal;
        }
    };
};