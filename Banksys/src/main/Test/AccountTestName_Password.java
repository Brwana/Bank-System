import com.example.banksys.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountTestName_Password {

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
    public void testName()throws InvalidPass {
       acc = new Account("yehia","123345","Checking");
       assertEquals("Incorrect Name","yehia",acc.getName());
    }

    @Test
    public void testPasswordSuccess()
    {
        try {
            acc = new Account("yehia", "123456", "Checking");
            assertEquals("Incorrect password","123456",acc.getPass());
        } catch (Exception e){
            fail();
        }
    }
    @Test
    public void testPasswordFail()
    {
        try {
            acc = new Account("yehia", "123", "Checking");
            fail();
        } catch (Exception e){

        }
    }

//    @Test
//    public void testAccountID() throws InvalidPass{
//        acc = new Account("Noha" , "122343","Saving");
//        assertEquals("Incorrect ID",4,acc.getAccountID());
//    }

}