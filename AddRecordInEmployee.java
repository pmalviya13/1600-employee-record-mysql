import java.sql.*;
class AddRecordInEmployee {
public static void main(String gg[]) {
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection c;
c=DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");
PreparedStatement ps;
int departmentCode=1;
int designationCode=1;
int x;
x=1;
while(x<=16000)
{
if(departmentCode<5 && designationCode<6)
{
ps=c.prepareStatement("insert into employee (name,department_code,designation_code) values(?,?,?)");
ps.setString(1,"Employee - "+x);
ps.setInt(2,departmentCode);
ps.setInt(3,designationCode);
ps.executeUpdate();
ps.close();
}
if(departmentCode==5 && designationCode!=6)
{
ps=c.prepareStatement("insert into employee (name,designation_code) values(?,?)");
ps.setString(1,"Employee - "+x);
ps.setInt(2,designationCode);
ps.executeUpdate();
ps.close();
}
if(designationCode==6 && departmentCode!=5)
{
ps=c.prepareStatement("insert into employee (name,department_code) values(?,?)");
ps.setString(1,"Employee - "+x);
ps.setInt(2,departmentCode);
ps.executeUpdate();
ps.close();
}
if(departmentCode==5 && designationCode==6)
{
ps=c.prepareStatement("insert into employee (name) values(?)");
ps.setString(1,"Employee - "+x);
ps.executeUpdate();
ps.close();
}
departmentCode++;
designationCode++;
if(departmentCode==6)
{
departmentCode=1;
}
if(designationCode==7)
{
designationCode=1;
}
x++;
}
c.close();
}catch(Exception e)
{
System.out.println(e);
}
}
}
