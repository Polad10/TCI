import java.time.LocalDate;

public class Course {
    private LocalDate startDate;
    private LocalDate endDate;

    public Course(LocalDate startDate, LocalDate endDate) throws CourseDateException
    {
        if(endDate.compareTo(startDate) > 0)
        {
            this.startDate = startDate;
            this.endDate = endDate;
        }
        else
        {
            throw new CourseDateException();
        }
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
