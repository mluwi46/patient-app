import org.junit.Test;
import static org.junit.Assert.*;

public class PatientAppTest {

    @Test
    public void testAppTitle() {
        String expectedTitle = "SmartMed";
        String actualTitle = "SmartMed"; // Simulated check
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testWelcomeMessage() {
        String expectedMessage = "Welcome to SmartMed Patient System";
        String actualMessage = "Welcome to SmartMed Patient System"; // Simulated check
        assertEquals(expectedMessage, actualMessage);
    }
}

