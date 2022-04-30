package bootcamp.collections.examples;

import java.time.LocalDate;
import java.util.Objects;

public class Candidate implements Comparable<Candidate>{

	private int id;
    private String name;
    private double salary;
    private LocalDate joiningDate;

    public Candidate(int id, String name, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    // Compare Two Candidates based on their ID
    /**
     * @param   anotherCandidate - The Candidate to be compared.
     * @return  A negative integer, zero, or a positive integer as this Candidate
     *          is less than, equal to, or greater than the supplied Candidate object.
    */
    @Override
    public int compareTo(Candidate anotherCandidate) {
        return this.getId() - anotherCandidate.getId();
    }
    //this is a detailed version of the compareTo method
    /*
    public int compareTo(Employee anotherEmployee) {
        if(this.getId() < anotherEmployee.getId()) {
            return -1;
        } else if (this.getId() > anotherEmployee.getId()) {
            return 1;
        } else {
            return 0;
        }
    }
    */

    // Two Candidates are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate Candidate = (Candidate) o;
        return id == Candidate.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                '}';
    }

}
