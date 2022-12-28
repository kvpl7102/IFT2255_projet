import java.io.IOException;

		

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;	



public class AppMenuTest{
    UserController userC;
    BinController binC;
    MetricController metricC;

    @Before
    public void setUp() throws IOException {
        this.userC = new UserController();
        this.binC = new BinController();
        this.metricC = new MetricController(userC, binC);

        binC.getBins().add(new Bin(BinType.ORDURE,"qr","bin1","null"));

        Resident resident1 = new Resident("res1", "123", "res1", "phone", "adr");
        userC.getResidents().add(resident1);
        userC.getUsers().put("res1", "123");

    }

    @Test
    public void testUserController(){
        Resident resident1 = new Resident("res1", "123", "res1", "phone", "adr");
        userC.getResidents().add(resident1);
        userC.getUsers().put("res1", "123");

        assertTrue(userC.verifyUser("res1", "123"));
        assertNotEquals(userC.getConsumers(), userC.getResidents()); //test for addResident does not add it to consummer.
        assertEquals(userC.getResidents().get(0).getAddress(), "adr"); //test for add user gives right address
    }

    @Test
    public void testMetricController(){
        this.userC = new UserController();
        this.binC = new BinController();
        this.metricC = new MetricController(userC, binC);
        binC.getBins().add(new Bin(BinType.ORDURE,"qr","bin1","null"));

        assertTrue(metricC.calAverageFillLevel() >= 0);
        assertTrue(metricC.calNbBinPerRes() >= 0);
        assertTrue(metricC.calRecyRate() >= 0); 

    }

    @Test
    public void testBinController(){
        binC.getBins().add(new Bin(BinType.ORDURE,"qr","bin1","null"));
        
        assertNotNull(binC.getBins().get(0).getBinType()); // test for add bin state type at instanciation step.
        assertNotNull(binC.getBins().get(0).getStartTime()); // test for set Start time at instanciation step.
        assertNotNull(binC.getBins().get(0).getBinStateType()); // test for add bin state type at instanciation step.

    }



}