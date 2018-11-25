import java.time.LocalDate;
import java.util.ArrayList;

public class School
{
    private String name;
    private LocalDate openingDate;
    private ArrayList<Course> courses;

    public School(String name, LocalDate openingDate) throws SchoolNameException, SchoolOpeningDateException
    {
        setName(name);
        setOpeningDate(openingDate);
        courses = new ArrayList<Course>();
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

    public void addCourse(Course course) throws SchoolCourseException, DuplicateCourseException
    {
        if(openingDate.compareTo(course.getStartDate()) >= 0)
        {
            throw new SchoolCourseException("Course begin dates should be after the school begin date");
        }

        if(getCourse(course.getName()) != null)
        {
            throw new DuplicateCourseException("The name of the course within a school should be unique");
        }

        courses.add(course);
    }

    public Course getCourse(String courseName)
    {
        for (Course course : courses)
        {
            if(course.getName().equals(courseName))
            {
                return course;
            }
        }

        return null;
    }

    public ArrayList<String> getCourseNames()
    {
        ArrayList<String> courseNames = new ArrayList<>();

        for(Course course : courses)
        {
            courseNames.add(course.getName());
        }

        return courseNames;
    }

    public ArrayList<Course> getAllCourses()
    {
        return courses;
    }
}
