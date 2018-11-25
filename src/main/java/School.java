import java.time.LocalDate;
import java.util.ArrayList;

public class School
{
    private String name;
    private LocalDate openingDate;
    ArrayList<Course> courses;

    public School(String name, LocalDate openingDate) throws SchoolNameException
    {
        setName(name);
    }

    private void setName(String name) throws SchoolNameException
    {
        if(name == null)
        {
            throw new SchoolNameException("School name is not allowed to be null");
        }

        this.name = name;
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
