public class Manager extends Staff implements ICalculator {
    //khai báo các thuộc tính và dùng super để nhận thuộc tính kế thừa từ staff
    String position;
    Manager(String gtname, String gtdateStart, String gtdepartmentName, int gtid, int gtage, double gtsalaryFactor, int gtvacationDay, String gtposition) {
        super(gtname,gtdateStart,gtdepartmentName,gtid,gtage,gtsalaryFactor, gtvacationDay);
   this.position=gtposition;
    }
    public void setPosition(String gtposition){
        this.position = gtposition;
    } //hàm set vị trí
    public String getPosition() {
        return position;
    }//hàm lấy vị trí
    //hiển thị thông tin quản lý, dùng override để ghi đè lên staff
    @Override
    public void displayInformation(){
        System.out.println("Mã số NV: "+id+ "   Họ&Tên: "+ name);
        System.out.println("Chức danh: "+position +"  Tuổi: "+age);
        System.out.println("Bộ phân làm việc: "+departmentName+ "   Ngày bắt đầu: "+ dateStart);
        System.out.println("Số ngày nghỉ phép: "+vacationDay);
        System.out.println("Bộ phân làm việc: "+departmentName+ "   Ngày bắt đầu: "+ dateStart);
        System.out.println("Hệ số lương "+salaryFactor );
        System.out.println();
    }
    //hiển thị lương sau khi tính toán, dùng override để ghi đè lên stafff
    @Override
    public double calculateSalary(){
        double salaryRes=0;
        if (position.equals("Business Leader") ){
            salaryRes = 8000000;
        }
        if (position.equals("Project Leader")){
            salaryRes = 5000000;
        }
        if (position.equals("Technical Leader")){
            salaryRes = 6000000;
        }
        double salary;
        salary = salaryFactor*5000000+salaryRes;
        return salary;
    }
}
