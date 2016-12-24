package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil 
{
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static Properties properties = new Properties() ;
	static
	{
		InputStream is = null ;
		
		try
		{
			is = JDBCUtil.class.getResourceAsStream("/Person.properties");
			properties.load(is);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(is != null)
			{
				try
				{
					is.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Connection getConnection()throws Exception
	{
		Connection connection = tl.get();
		
		if(connection == null)
		{
			try
			{
				Class.forName(properties.getProperty("driver"));
				connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
				tl.set(connection);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return connection ;
	}
	
	public static void close(ResultSet rs , PreparedStatement ps , Connection connection) throws Exception
	{
		if(rs != null)
		{
			rs.close();
		}
		
		if(ps != null)
		{
			ps.close();
		}
		
		if(connection != null)
		{
			connection.close();
			tl.remove();
		}
	}
	
}
