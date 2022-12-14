import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc_mysql";
        // 下面两个改成你的用户名和密码
        String username = "root";
        String password = "040416";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 定义 sql 语句
        String sql1 = "INSERT INTO tb_user (name, sex, email) VALUES ('jerry','女','jerry@sina.com' ;";

        // 获取执行sql语句的对象 statement
        Statement state = conn.createStatement();

        // 执行sql语句
        state.executeUpdate(sql1);

        state.close();
        conn.close();
    }
}

// class car {
// private String brand;
// private double price;
// private String color;
// private Calendar date;

// public car() {
// }

// public car(String brand, double price, String color, Calendar date) {
// this.brand = brand;
// this.price = price;
// this.color = color;
// this.date = date;
// }

// public String getBrand() {
// return brand;
// }

// public void setBrand(String brand) {
// this.brand = brand;
// }

// public double getPrice() {
// return price;
// }

// public void setPrice(double price) {
// this.price = price;
// }

// public String getColor() {
// return color;
// }

// public void setColor(String color) {
// this.color = color;
// }

// public Calendar getDate() {
// return date;
// }

// public void setDate(Calendar date) {
// this.date = date;
// }

// @Override
// public String toString() {
// return "car [brand=" + brand + ", price=" + price + ", color=" + color + ",
// date=" + date + "]";
// }

// }