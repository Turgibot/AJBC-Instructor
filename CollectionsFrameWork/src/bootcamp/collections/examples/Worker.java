package bootcamp.collections.examples;

import java.util.Objects;

class Worker implements Comparable<Worker> {
    private String name;
    private double salary;

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker Worker = (Worker) o;
        return Double.compare(Worker.salary, salary) == 0 &&
                Objects.equals(name, Worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Compare two Worker objects by their salary
    @Override
    public int compareTo(Worker Worker) {
        if(this.getSalary() > Worker.getSalary()) {
            return 1;
        } else if (this.getSalary() < Worker.getSalary()) {
            return -1;
        } else {
            return 0;
        }
    }
}
