import java.util.Scanner;
public class Employee extends Staff implements ICalculator {
    //khai báo các thuộc tính cần thiết và các thuộc tính kế thừa từ staff
    double overtime;
    Employee(String gtname, String gtdateStart, String gtdepartmentName, int gtid, int gtage, double gtsalaryFactor, int gtvacationDay, double gtovertime){
        super(gtname,gtdateStart,gtdepartmentName,gtid,gtage,gtsalaryFactor, gtvacationDay);
        //nhạn thong tin overtime
        this.overtime= gtovertime;
    }
    public double getOvertime(){
        return overtime;
    }
    //hiển thị thông tin nhân viên, ghi đè từ staff
    @Override
    public void displayInformation(){

        System.out.println("Mã số NV: "+this.id+ "   Họ&Tên: "+ this.name);
        System.out.println("Tuổi: "+this.age);
        System.out.println("Bộ phân làm việc: "+this.departmentName+ "   Ngày bắt đầu: "+ this.dateStart);
        System.out.println("Số ngày nghỉ phép: "+this.vacationDay+ "   Số giờ làm thêm: "+ this.overtime);
        System.out.println("Bộ phân làm việc: "+this.departmentName+ "   Ngày bắt đầu: "+ this.dateStart);
        System.out.println("Hệ số lương "+this.salaryFactor);
        System.out.println();
    }
    // tính lương nhân viên và trả về, ghi đè từ staff
    @Override
    public double calculateSalary(){
        double salary = salaryFactor*3000000+overtime*200000;
        return salary;
    }
}
