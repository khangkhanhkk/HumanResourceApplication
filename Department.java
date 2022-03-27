public class Department {
    //khai báo các thuộc tính của các bộ phận
    int departmentID,emplnumber;
    String departmentName;
    Department(int gtdepartmentID, String gtdepartmentName,int emplnumber) {
        this.departmentID = gtdepartmentID;
        this.departmentName = gtdepartmentName;
    }
    //set mã bộ phận và lấy mã bộ phận
    public void setDepartmentId(int departmentID) {
        this.departmentID = departmentID;
    }
    public int getDepartmentId() {
        return departmentID;
    }
    //set tên bộ phận và lấy tên bộ phận
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    //hàm tính số nhân viên thuộc bộ phận và đưa vào mảng bộ phận nhận từ chương trình chính
    public void setEmplnumber(int emplnumber){this.emplnumber =  emplnumber;}
    //hiển thị thông tin bộ phận bằng cách override
@Override
    public String toString(){return "Mã bộ phận: "+departmentID+"  Tên bộ phận: "+departmentName+"  Số lượng nhân viên: "+emplnumber;}

}
