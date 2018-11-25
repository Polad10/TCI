import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SchoolTest
{
    @Test(expected = SchoolNameException.class)
    public void SchoolNameExceptionTest() throws SchoolNameException, SchoolOpeningDateException
    {
        School school = new School(null, LocalDate.of(2018, 1, 1));
    }

    @Test(expected = SchoolOpeningDateException.class)
    public void SchoolOpeningDateExceptionTest() throws SchoolOpeningDateException, SchoolNameException
    {
        School school = new School("School Name", null);
    }

    @Test
    public void addCourseTest() throws SchoolOpeningDateException, SchoolNameException, CourseDateException, SchoolCourseException
    {
        School school = new School("School name", LocalDate.of(2018, 1, 1));
        Course course = new Course("Course name", LocalDate.of(2018, 2, 1), LocalDate.of(2018, 3, 1));
        school.addCourse(course);

        ArrayList<Course> allCourses = school.getAllCourses();
        Assert.assertTrue(allCourses.contains(course));
    }

    @Test(expected = SchoolCourseException.class)
    public void SchoolCourseExceptionTest() throws SchoolCourseException, SchoolOpeningDateException, SchoolNameException, CourseDateException
    {
        School school = new School("School name", LocalDate.of(2019, 1, 1));
        Course course = new Course("Course name", LocalDate.of(2018, 2, 1), LocalDate.of(2018, 3, 1));
        school.addCourse(course);
    }

    @Test(expected = DuplicateCourseException.class)
    public void DuplicateCourseExceptionTest() throws DuplicateCourseException, SchoolCourseException, SchoolOpeningDateException, SchoolNameException, CourseDateException
    {
        School school = new School("School name", LocalDate.of(2017, 1, 1));
        Course course1 = new Course("Course name", LocalDate.of(2018, 2, 1), LocalDate.of(2018, 3, 1));
        Course course2 = new Course("Course name", LocalDate.of(2018, 3, 1), LocalDate.of(2018, 4, 1));
        school.addCourse(course1);
        school.addCourse(course2);
    }
}