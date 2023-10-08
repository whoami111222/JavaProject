import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.*;

public class SqlConnect {
    private static String url = "jdbc:mysql://127.0.0.1:3306/stu";
    private static String username = "root";
    private static String password = "jianshoudixian1";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   //加载MYSQL JDBC驱动程序
            //Class.forName("org.gjt.mm.mysql.Driver");
//            System.out.println("成功加载Mysql驱动程序!");
        } catch (Exception e) {
//            System.out.print("加载Mysql驱动程序时出错!");
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("成功连接MYSQL服务器！");
            Statement statement = connection.createStatement();
            statement.execute("insert into stu_info(name,gender,age) values ('小明','男',23)");
//            statement.execute("delete from stu_info where id=6");
            ResultSet resultSet = statement.executeQuery("select * from stu_info");
            while (resultSet.next()) {
                System.out.print("name:" + resultSet.getString("name") + "\t");
                System.out.print("gender:" + resultSet.getString("gender") + "\t");
                System.out.print("age:" + resultSet.getInt("age"));
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
