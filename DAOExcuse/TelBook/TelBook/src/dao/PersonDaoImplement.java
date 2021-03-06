package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import entity.Person;

public class PersonDaoImplement implements PersonDao
{

	public Integer insertPerson(Person p) 
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		int result = 0 ;
		
		try
		{
			con = JDBCUtil.getConnection() ;
			
			ps = con.prepareStatement("insert into person1 values(person_seq.nextval,?,?,?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getMobile());
			ps.setString(3, p.getTelphone());
			ps.setString(4, p.getEmail());
			ps.setString(5, p.getCity());
			ps.setDate(6, java.sql.Date.valueOf(p.getBirthday().toString()));
			result = ps.executeUpdate();
			
			return result ;
		} catch (Exception e)
		{

			e.printStackTrace();
			throw new RuntimeException("插入失败");
		}finally
		{
			try 
			{
				JDBCUtil.close(null,ps,null);
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
	}

	public void updatePerson(Person p) 
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		
		try
		{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement("update person1 set name = ?, mobile = ? , telphone = ? ,email = ? , city = ? , birthday = ? where id = ?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getMobile());
			ps.setString(3, p.getTelphone());
			ps.setString(4, p.getEmail());
			ps.setString(5, p.getCity());
			ps.setDate(6, java.sql.Date.valueOf( p.getBirthday().toString()));
			ps.setInt(7, p.getId());
			ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				JDBCUtil.close(null, ps, null);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public void deletePerson(Integer id) 
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		
		try
		{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement("delete from person1 where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				JDBCUtil.close(null, ps, null);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public Person queryPersonById(Integer id) 
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		Person p = null ;
		
		try
		{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement("select * from person1 where id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				p = new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
			}
			
			return p ;
		}catch(Exception e)
		{
			e.printStackTrace();
			
			throw new RuntimeException("没有查到该数据");
		}finally
		{
			try
			{
				JDBCUtil.close(rs, ps, null);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public List<Person> queryAllPersons() 
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		List<Person> list = new ArrayList<Person>() ;
		
		try
		{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement("select * from person1 ");
		
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Person p = new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
				
				list.add(p);
			}
			
			return list ;
		}catch(Exception e)
		{
			e.printStackTrace();
			
			throw new RuntimeException("没有查到数据");
		}finally
		{
			try
			{
				JDBCUtil.close(rs, ps, null);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public List<Person> queryPersonsByName(String name) 
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		List<Person> list = new ArrayList<Person>() ;
		
		try
		{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement("select * from person1 where name = ?");
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Person p = new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
				
				list.add(p);
			}
			
			
			return list ;
		}catch(Exception e)
		{
			e.printStackTrace();
			
			throw new RuntimeException("没有查到同名的数据");
		}finally
		{
			try
			{
				JDBCUtil.close(rs, ps, null);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public List<Person> queryPersonsByMobile(String mobile) 
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		List<Person> list = new ArrayList<Person>() ;
		
		try
		{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement("select * from person1 where mobile = ?");
			ps.setString(1, mobile);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Person p = new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
				
				list.add(p);
			}
			
			return list ;
		}catch(Exception e)
		{
			e.printStackTrace();
			
			throw new RuntimeException("没有查到同手机号的数据");
		}finally
		{
			try
			{
				JDBCUtil.close(rs, ps, null);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public List<Person> queryPersonsByMonth() 
	{
		Connection con = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		
		List<Person> list = new ArrayList<Person>() ;
		
		try
		{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement("select * from person1 where to_char(birthday,'yyyy-mm') like to_char(sysdate,'yyyy-mm')");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Person p = new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
				
				list.add(p);
			}
			
			if(list.isEmpty())
			{
				try
				{
					throw new RuntimeException("没有查到同天出生的数据");

				}catch(Exception ep)
				{
					ep.printStackTrace();
				}
			}
			return list ;
		}catch(Exception e)
		{
			e.printStackTrace();
			try
			{
				throw new RuntimeException("没有查到同天出生的数据");

			}catch(Exception ep)
			{
				ep.printStackTrace();
			}
			
			return list ;
		}finally
		{
			try
			{
				JDBCUtil.close(rs, ps, null);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}


