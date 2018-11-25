import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class SchoolTest
{
    @Test(expected = SchoolNameException.class)
    public void SchoolNameExceptionTest() throws SchoolNameException
    {
        School school = new School(null, LocalDate.of(2018, 1, 1));
    }
}