/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
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

        int ans = e.importance;

        for (int subId : e.subordinates) {
            Employee emp = getEmp(subId);
            ans += imp(emp);
        }

        return ans;
    }
}