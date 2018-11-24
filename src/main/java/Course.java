import java.time.LocalDate;

public class Course {
    private LocalDate startDate;
    private LocalDate endDate;

    public Course(LocalDate startDate, LocalDate endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
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
