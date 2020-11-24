package util;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectMysql{
    protected Connection conn;
    private Properties properties;

    public ConnectMysql(){
        getConncet();
    }

    //获取连接
    protected void getConncet(){
        try {
            //获取连接所需全局参数
            InputStreamReader inputStream= new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("druid.properties"),"GBK");
            this.properties=new Properties();
            this.properties.load(inputStream);
            String driverClassName=this.properties.getProperty("driverClassName");
            String url=this.properties.getProperty("url");
            String userName=this.properties.getProperty("userName");
            String password=this.properties.getProperty("password");
            //获取连接
            //加载驱动
            Class.forName(driverClassName);
            this.conn= DriverManager.getConnection(url,userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭连接
    protected void closeConnect(){
        try {
            if(this.conn!=null&&!this.conn.isClosed())
                this.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
