package models;

public class Employees {
    private String name;
    private String position;
    private String role;
    private int departmentId;
    private int id;

    public Employees(String name, String position, String role, int departmentId) {
        this.name = name;
        this.position = position;
        this.role = role;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (departmentId != employees.departmentId) return false;
        if (id != employees.id) return false;
        if (name != null ? !name.equals(employees.name) : employees.name != null) return false;
        if (position != null ? !position.equals(employees.position) : employees.position != null) return false;
        return role != null ? role.equals(employees.role) : employees.role == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + departmentId;
        result = 31 * result + id;
        return result;
    }

}


