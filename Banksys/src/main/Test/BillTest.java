import com.example.banksys.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BillTest {
    static private Bill bill;
    static private ArrayList<Item> items = new ArrayList<>();
    @BeforeClass
    public static void set(){
        items.add(new Item("Item1",500));
        items.add(new Item("Item2",200));
        items.add(new Item("Item3",100));
        items.add(new Item("Item4",50));

    }
    @Test
    public void buyItemTest(){
        bill=new Bill(123);
        bill.buyItem(items.get(0),2);
        bill.buyItem(items.get(2),1);
        bill.buyItem(items.get(1),3);


        assertEquals("Incorrect price",1700,bill.calculatePrice(), 0.1);
    }
    @Test
    public void buyItemTest2(){
        bill=new Bill(123);
        bill.buyItem(items.get(0),1);
        bill.buyItem(items.get(2),1);
        bill.buyItem(items.get(1),1);
        bill.buyItem(items.get(3),1);

        assertEquals("Incorrect price",850,bill.calculatePrice(), 0.1);
    }
    //This Function is written by me
    //SUUUUUUUUUUUUUUUU Messi is the GOAT
    @Test
    public void testHistory() throws InsufficientBalance, InvalidPass {
        Account acc1 = new Account("abc", "123000", "Saving");
        bill=new Bill(123);
        bill.buyItem(items.get(0),1);
        acc1.addBills(bill);

        boolean flag = false;
        for(Bill b:acc1.getBills()) {
            if (b.getBillID() == bill.getBillID()) {
                flag = true;
                break;
            }
        }

        assertTrue("Bill Not Found in Account",flag);
    }
}