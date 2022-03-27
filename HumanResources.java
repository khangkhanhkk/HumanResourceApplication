//khai báo các thư viện để sử dụng
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HumanResources {
    public static void main(String[] args) {
        //khai báo mảng staff list và department list
        ArrayList<Staff> stafflist = new ArrayList<>();
        ArrayList<Department> deparmentlist = new ArrayList<>();
        //department là mảng cho trước và sẽ được chọn cho các nhân viên khi khai báo thông tin
        deparmentlist.add(new Department(1,"Sales",0));
        deparmentlist.add(new Department(2,"Marketing",0));
        deparmentlist.add(new Department(3,"Technical",0));
        int n = 0;
        do {//in ra hệ thống điều hướng
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
            System.out.println("2. Hiển thị các bộ phận trong công ty");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
            System.out.println("4. Thêm nhân viên mới vào công ty");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
            System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
            System.out.println("7. Hiển thêm bảng lương của nhân viên theo thứ tự giảm dần");
            System.out.println("8. Hiển thêm bảng lương của nhân viên theo thứ tự tăng dần");
            System.out.println("0. Thoát");
            Scanner sc = new Scanner(System.in);
            //n là giá trị nhập từ bàn phím  để đi tới các tính năng của chương trình
            n = Integer.parseInt(sc.nextLine());
            switch (n) {
                case 1: //sử dụng vòng lặp for đi hết toàn bộ stafflist và gọi displayinformation hiển thị thông tin
                    System.out.println("Danh sách nhân viên:");
                    for (int i = 0; i < stafflist.size(); i++) {
                        stafflist.get(i).displayInformation();
                    }
                    break;
                case 2://sử dụng 2 vòng lặp for, ứng với từng department kiểm tra toàn bộ stafflist nếu có nhân viên ứng với department đó, tăng số count lên nếu có và hiển thị thông tin gọi hàm cần thiết
                    System.out.println("Các bộ phận trong công ty:");
                    int count = 0;
                    for (int i = 0; i < deparmentlist.size(); i++) {
                        count = 0;
                        for (int j = 0; j < stafflist.size(); j++) {
                            if (stafflist.get(j).departmentName.equals(deparmentlist.get(i).departmentName)) count++;
                        }
                        deparmentlist.get(i).setEmplnumber(count);//gọi hàm tính số nhân viên thuộc bộ phận
                        System.out.println(deparmentlist.get(i).toString());//gọi hàm hiển thị thông tin bộ phận
                    }
                    break;
                case 3://sử dụng vòng lặp for, tương tự như chức năng 2, tuy nhiên hiển thị thông tin nhân viên hay vì thông tin bộ phận bằng hàm displayinformation
                    System.out.println("Danh sách nhân viên theo từng bộ phận:");
                    for (int i = 0; i < deparmentlist.size(); i++) {
                        deparmentlist.get(i).toString();
                        for (int j = 0; j < stafflist.size(); j++) {
                            if (stafflist.get(j).departmentName.equals(deparmentlist.get(i).departmentName)) {
                                stafflist.get(j).displayInformation();
                            }
                        }
                    }
                    break;
                case 4://khai báo các biến cần thiết để nhập dữ liệu nhân viên, cho giá trị đầu khi cần thiết
                    int inputemploy;
                    String name, dateStart, departmentName="", position = "";
                    int id, age, vacationDay, temp;
                    double salaryFactor, overtime, salaryRes;
                    //điều hướng nhập dữ liệu là quản lí hay nhân viên
                    System.out.println("Nhập số ứng với loại nhân viên cần thêm: ");
                    System.out.println("1. Nhân viên; 2. Quản Lý ");
                    do {//vòng lặp do while sẽ bắt nhập lại nếu không nhập 1 hoặc 2 như yêu cầu
                        inputemploy = Integer.parseInt(sc.nextLine());
                        if (inputemploy != 1 && inputemploy != 2)
                            System.out.println("Không hợp lệ, vui lòng nhập lại ");
                    } while (inputemploy != 1 && inputemploy != 2);
                    //nhập vào các thông tin chung của nhân viên và quản lý
                    System.out.print("Nhập ID ");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập Họ&Tên ");
                    name = sc.nextLine();
                    System.out.print("Nhập tuổi ");
                    age = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập bộ phận làm việc: 1. Sales; 2. Marketing; 3. Technical ");
                    int detemp;
                    do {//do while nhập lại nếu không chọn 1 2 3 ứng với tên bộ phận
                        detemp = Integer.parseInt(sc.nextLine());
                        if (detemp != 1 && detemp != 2 && detemp != 3)
                            System.out.println("Không hợp lệ, vui lòng nhập lại ");
                    } while (detemp != 1 && detemp != 2 && detemp != 3);
                    //gán bộ phận nhân viên thuộc vào
                    if (detemp==1) departmentName = "Sales";
                    else if (detemp==2) departmentName = "Marketing";
                    else if (detemp==3) departmentName = "Technical";
                    System.out.print("Nhập ngày bắt đầu theo dạng dd/mm/yyyy: ");
                    dateStart = sc.nextLine();
                    System.out.print("Nhập số ngày nghỉ ");
                    vacationDay = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập hệ số lương ");
                    salaryFactor = Double.parseDouble(sc.nextLine());
                    //phân biệt nhân viên và quản lí
                    if (inputemploy == 1) {//nhập số giờ làm thêm cho nhân viên r đưa giá trị vào mảng stafflist
                        System.out.print("Nhập số giờ làm thêm: ");
                        overtime = sc.nextDouble();
                        Employee nv = new Employee(name, dateStart, departmentName, id, age, salaryFactor, vacationDay, overtime);
                        stafflist.add(nv);

                    } else if (inputemploy == 2) {//chọn chứ vụ của quản lý
                        System.out.print("Chọn số ứng chức vụ quản lý tương ứng: 1. Business Leader, 2. Project Leader,3. Technical Leader ");
                        do {// nhập lại nếu k hợp lệ
                            temp = Integer.parseInt(sc.nextLine());
                            if (temp != 1 && temp != 2 && temp != 3)
                                System.out.println("Không hợp lệ, vui lòng nhập lại ");
                        } while (temp != 1 && temp != 2 && temp != 3);
                        if (temp == 1) {//gán vị trí quản lí
                            position = "Business Leader";
                        }
                        if (temp == 2) {
                            position = "Project Leader";
                        }
                        if (temp == 3) {
                            position = "Technical Leader";
                        }
                    //đưa các giá trị vào mảng
                    Manager ql = new Manager(name, dateStart, departmentName, id, age, salaryFactor, vacationDay, position);
                    stafflist.add(ql);
            }
                    break;

                case 5://khai báo biến cần thiết
                    int temp2, tempid;
                    String tempname;
                    System.out.println("Nhập tên hoặc mã nhân viên cần tìm: 1. Tìm theo tên; 2. Tìm theo mã nhân viên ");
                    do {//do while nhập lại nếu không hợp lệ
                        temp2 = Integer.parseInt(sc.nextLine());
                        if (temp2 < 1 || temp2 > 2) {
                            System.out.println("Không hợp lệ, vui lòng nhập lại ");
                        }
                    } while (temp2 < 1 || temp2 > 2);
                    if (temp2 == 1) {//tìm kiếm theo tên nhân viên
                        System.out.print("Nhập Họ và Tên đầy đủ ");
                        tempname = sc.nextLine();
                        for (int i = 0; i < stafflist.size(); i++) {
                            if (stafflist.get(i).name.equals(tempname)) {//nếu tên trùng với tên được nhập
                                stafflist.get(i).displayInformation();//gọi hàm hiển thị thông tin
                            }
                        }
                    }
                    if (temp2 == 2) {//tìm kiếm theo mã nhân viên
                        System.out.print("Nhập mã nhân viên (số) ");
                        tempid = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < stafflist.size(); i++) {
                            if (stafflist.get(i).id == tempid) {//nếu nhân viên có mã trùng với mã được nhập
                                stafflist.get(i).displayInformation();//gọi hàm hiển thị thong tin
                            }
                        }
                    }

                    break;
                case 6://hiển thị bảng lương, không có giá trị lương ghi nhân trực tiếp mà dùng giá trị tính toán trả về từ hàm calculatesalary bên trong stafflist
                    System.out.println("Bảng lương các nhân viên ");
                    for (int i = 0; i < stafflist.size(); i++) {
                        System.out.println("Mã nhân viên: " + stafflist.get(i).id + "  Họ&Tên: " + stafflist.get(i).name + "  Lương: " + stafflist.get(i).calculateSalary());
                    }
                    System.out.println();
                    break;
                case 7://sửa dụng collection sort để sắp xếp theo thứ tự giảm dần
                    Collections.sort(stafflist, new Comparator<Staff>() {
                        @Override
                        public int compare(Staff o1, Staff o2) {
                            return ((ICalculator) o1).calculateSalary() < ((ICalculator) o2).calculateSalary() ? 1 : -1;
                        }//nếu giá trị o1 nhỏ hơn o2 thỏa điều kiện thì o1 xếp ra sau
                    });
                    // show list
                    System.out.println("Bảng lương các nhân viên giảm dần ");
                    for (int i = 0; i < stafflist.size(); i++) {
                        System.out.print("Mã nhân viên: " + stafflist.get(i).id + "  Họ&Tên: " + stafflist.get(i).name );
                        System.out.printf("  Lương: %.0f" ,stafflist.get(i).calculateSalary());
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 8://sử dụng collection sort để xếp thứ tự tăng dần
                    Collections.sort(stafflist, new Comparator<Staff>() {
                        @Override
                        public int compare(Staff o1, Staff o2) {
                            return ((ICalculator) o1).calculateSalary() > ((ICalculator) o2).calculateSalary() ? 1 : -1;
                        }//nếu giá trị lương o1 lớn hơn o2 thì thỏa điều kiện và xếp o2 về trước
                    });
                    // show list
                    System.out.println("Bảng lương các nhân viên tăng dần ");
                    for (int i = 0; i < stafflist.size(); i++) {
                        System.out.print("Mã nhân viên: " + stafflist.get(i).id + "  Họ&Tên: " + stafflist.get(i).name );
                        System.out.printf("  Lương: %.0f" ,stafflist.get(i).calculateSalary());
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 0: //thoát khỏi vòng lặp switch case, thoát chương trình
                    break;
            }

        }while (n!=0);
    }
    }



