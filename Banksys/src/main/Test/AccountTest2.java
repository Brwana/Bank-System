import com.example.banksys.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountTest2 {

    static private ArrayList<Account> accounts;
   @BeforeClass
    static public void createAccounts() throws InvalidPass{
       accounts = new ArrayList<>();
       accounts.add(new Account("Yehia","123344","Checking"));
       accounts.add(new Account("Noha","123344","Checking"));
       accounts.add(new Account("Brwana","123344","Checking"));
   }
    Account acc;


    @Test
    public void testWithdraw()throws InvalidPass
    {
     acc = new Account("yehia","123456","Checking");
     double d = acc.getBalance();
     try {
         acc.withdraw(1300);
         fail();
     }
     catch(Exception e){

     }
    }
    @Test
    public void testDeposit()throws InvalidPass {
        acc = new Account("yehia", "123456", "Checking");
        double d = acc.getBalance();
        acc.deposit(300);
        double d2 = acc.getBalance();
        //assertEquals(700.0, d2, 0);
        assertTrue(d2 - d == 300);
    }


//    @Test
//    public void testTransfer() throws InvalidPass{
//        acc = new Account("Noha" , "12","Saving");
//        Account acc2 = new Account("adsf" , "12","Saving");
//        try {
//            acc.transfer(acc2, 200);
//            fail();
//        } catch(Exception e){
//
//        }
//        assertEquals("Transfer failed",1200,acc2.getBalance(),0);
//
//    }

}