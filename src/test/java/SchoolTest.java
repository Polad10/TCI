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
    public void addCourseTest() throws SchoolOpeningDateException, SchoolNameException, CourseDateException, SchoolCourseException, DuplicateCourseException
    {
        School school = new School("School name", LocalDate.of(2018, 1, 1));
        Course course = new Course("Course name", LocalDate.of(2018, 2, 1), LocalDate.of(2018, 3, 1));
        school.addCourse(course);

        ArrayList<Course> allCourses = school.getAllCourses();
        Assert.assertTrue(allCourses.contains(course));
    }

    @Test(expected = SchoolCourseException.class)
    public void SchoolCourseExceptionTest() throws SchoolCourseException, SchoolOpeningDateException, SchoolNameException, CourseDateException, DuplicateCourseException
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

    @Test
    public void getCourseTest() throws SchoolOpeningDateException, SchoolNameException, CourseDateException, SchoolCourseException, DuplicateCourseException
    {
        School school = new School("School name", LocalDate.of(2018, 1, 1));
        Course course = new Course("Course name", LocalDate.of(2018, 2, 1), LocalDate.of(2018, 3, 1));
        school.addCourse(course);

        Assert.assertSame(course, school.getCourse("Course name"));
    }

    @Test
    public void getCourseNamesTest() throws SchoolOpeningDateException, SchoolNameException, CourseDateException, SchoolCourseException, DuplicateCourseException
    {
        String courseName1 = "course1";
        String courseName2 = "course2";

        ArrayList<String> expectedCourseNames = new ArrayList<String>();
        expectedCourseNames.add(courseName1);
        expectedCourseNames.add(courseName2);

        School school = new School("School name", LocalDate.of(2018, 1, 1));
        Course course1 = new Course(courseName1, LocalDate.of(2018, 2, 1), LocalDate.of(2018, 3, 1));
        Course course2 = new Course(courseName2, LocalDate.of(2018, 3, 1), LocalDate.of(2018, 4, 1));

        school.addCourse(course1);
        school.addCourse(course2);

        Assert.assertEquals(expectedCourseNames, school.getCourseNames());
    }

    @Test
    public void getAllCoursesTest() throws SchoolOpeningDateException, SchoolNameException, CourseDateException, SchoolCourseException, DuplicateCourseException
    {
        Course course1 = new Course("Course 1", LocalDate.of(2018, 2, 1), LocalDate.of(2018, 3, 1));
        Course course2 = new Course("Course 2", LocalDate.of(2018, 3, 1), LocalDate.of(2018, 4, 1));

        ArrayList<Course> expectedCourses = new ArrayList<Course>();
        expectedCourses.add(course1);
        expectedCourses.add(course2);

        School school = new School("School name", LocalDate.of(2018, 1, 1));

        school.addCourse(course1);
        school.addCourse(course2);

        Assert.assertEquals(expectedCourses, school.getAllCourses());
    }
}