import java.time.LocalDate;

public class Course {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public Course(String name, LocalDate startDate, LocalDate endDate) throws CourseDateException
    {
        if(endDate.compareTo(startDate) > 0)
        {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
        }
        else
        {
            throw new CourseDateException();
        }
    }

    public String getName()
    {
        return name;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }
}
