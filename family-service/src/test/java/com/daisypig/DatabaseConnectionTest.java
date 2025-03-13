package com.daisypig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        // 数据库连接 URL，需要根据实际情况修改数据库名、用户名和密码
        String url = "jdbc:mysql://127.0.0.1:3306/FMSDB?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String username = "daisypig";
        String password = "gipysiad";

        try {
            // 加载 MySQL 驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("数据库连接成功！");
                // 关闭连接
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("未找到 MySQL 驱动类，请检查依赖是否添加。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("数据库连接失败，错误信息：" + e.getMessage());
            e.printStackTrace();
        }
    }
}