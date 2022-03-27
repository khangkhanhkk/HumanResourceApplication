public abstract class Staff implements ICalculator {
    //khai báo các thuộc tính cần thiết
    String name,dateStart,departmentName;
    int id,age,vacationDay;
    double salaryFactor;
    Staff(String gtname, String gtdateStart, String gtdepartmentName, int gtid, int gtage, double gtsalaryFactor, int gtvacationDay ){
        this.name = gtname;
        this.dateStart=  gtdateStart;
        this.departmentName = gtdepartmentName;
        this.id = gtid;
        this.age = gtage;
        this.salaryFactor = gtsalaryFactor;
        this.vacationDay = gtvacationDay;
        //nhap thong tin nhan vien
    }
    //staff là abstract nên displayinformation k có nội dung, sẽ được ghi đè bỏ chương trình con
    public void displayInformation(){
    }

}


