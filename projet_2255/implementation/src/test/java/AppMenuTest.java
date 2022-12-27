import java.io.IOException;

import static org.junit.jupiter.api.Assertation.*;

import org.junit.jupiter.api.test;

public class AppMenuTest {
    UserController userC;
    BinController binC;
    MetricController metricC;

    /**
     * @throws IOException
     */
    public void setUp() throws IOException {
        this.userC = new UserController();
        this.binC = new BinController();
        this.metricC = new MetricController(userC, binC);

        binC.getBins().add(new Bin(BinType.ORDURE, "qr", "bin1", "null"));

        Resident resident1 = new Resident("res1", "123", "res1", "phone", "adr");
        userC.getResidents().add(resident1);
        userC.getUsers().put("res1", "123");

    }

    @After
    public void testUserController() {
        assertTrue(userC.verifyUser("res1", "123"));
        assertEquals(userC.getConsumers() == null); // test for addResident does not add it to consummer.
        assertEquals(userC.getResidents().get(0).getAddress(), "adr"); // test for add user gives right address
    }

    @After
    public void testMetricController() {
        assertTrue(metricC.calAverageFillLevel() >= 0);
        assertTrue(metricC.calNbBinPerRes() >= 0);
        assertFalse(metricC.calRecyRate() >= 0);

    }

    @After
    public void testBinController() {
        assertTrue(binC.getBins().get(0).getBinType() != null); // test for add bin state type at instanciation step.
        assertTrue(binC.getBins().get(0).getStartTime() != null); // test for set Start time at instanciation step.
        assertTrue(binC.getBins().get(0).getBinStateType() != null); // test for add bin state type at instanciation
                                                                     // step.

    }

}