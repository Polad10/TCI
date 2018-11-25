import java.time.LocalDate;
import java.util.ArrayList;

public class School
{
    private String name;
    private LocalDate openingDate;
    ArrayList<Course> courses;

    public School(String name, LocalDate openingDate) throws SchoolNameException, SchoolOpeningDateException
    {
        setName(name);
        setOpeningDate(openingDate);
    }

    private void setName(String name) throws SchoolNameException
    {
        if(name == null)
        {
            throw new SchoolNameException("School name is not allowed to be null");
        }

        this.name = name;
    }

    private void setOpeningDate(LocalDate openingDate) throws SchoolOpeningDateException
    {
        if (openingDate == null)
        {
            throw new SchoolOpeningDateException("School opening date is not allowed to be null");
        }

        this.openingDate = openingDate;
    }

    public void addCourse()
    {

    }

    public Course getCourse(String courseName)
    {
        return null;
    }

    public ArrayList<String> getCourseNames()
    {
        return null;
    }

    public ArrayList<Course> getAllCourses()
    {
        return null;
    }
}
