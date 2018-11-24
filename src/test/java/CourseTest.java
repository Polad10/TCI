import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void EndDateIsAfterStartDateTest()
    {
        LocalDate startDate = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2019, Month.JANUARY, 1);
        Course course = new Course(startDate, endDate);

        Assert.assertTrue(course.getEndDate().compareTo(course.getStartDate()) > 0);
    }

}
