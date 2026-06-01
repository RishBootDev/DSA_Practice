import java.util.List;

public class EmployeeImportance {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    List<Employee> list ;

    public int getImportance(List<Employee> employees, int id) {
         this.list = employees;
         Employee e = getEmp(id);
         return imp(e);
    }

    public Employee getEmp(int id) {
        for(Employee emp : this.list) {
            if(emp.id == id) return emp;
        }
        return null;
    }

    public int imp(Employee e) {
        if(e.subordinates.isEmpty()) return e.importance;

        int ans = 0;
        List<Integer> sub = e.subordinates;
        for (int i = 0; i < sub.size(); i++) {
           Employee emp = getEmp(sub.get(i));
           ans += imp(emp) + emp.importance;
        }
        return ans;
    }
}
