package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import util.JDBCUtil;
import dao.PersonDaoImplement;
import entity.Person;

public class TelbookServiceImplement implements TelbookService
{

	public Person getPersonById(Integer id) 
	{
		Connection con = null ;
		PersonDaoImplement pdi = new PersonDaoImplement() ;
		
		try
		{
			 con = JDBCUtil.getConnection() ;
			 con.setAutoCommit(false);
			 
			 Person p = pdi.queryPersonById(id) ;
			 con.commit();
			 
			 return p ;
		}catch(Exception e)
		{
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			return null ;
		}finally
		{
			try 
			{
				JDBCUtil.close(null, null, con);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public void regist(String name, String mobile, String telphone,
			String email, String city, Date birthday)
	{
		Connection con = null ;
		PersonDaoImplement pdi = new PersonDaoImplement() ;
		
		try 
		{
			con = JDBCUtil.getConnection();
			
			Person p = new Person(null,name,mobile,telphone,email,city,birthday);
			pdi.insertPerson(p); 
			
			con.commit();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}finally
		{
			try 
			{
				JDBCUtil.close(null,null,con);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public List<Person> getAllPerson()
	{
		Connection con = null ;
		PersonDaoImplement pdi = new PersonDaoImplement() ;
		
		try 
		{
			con = JDBCUtil.getConnection();
			
			List<Person> list = pdi.queryAllPersons(); 
			
			con.commit();
			
			return list ;
		} catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
			return null ;
		}finally
		{
			try 
			{
				JDBCUtil.close(null,null,con);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public List<Person> getPersonByName(String name) 
	{

		Connection con = null ;
		PersonDaoImplement pdi = new PersonDaoImplement() ;
		
		try 
		{
			con = JDBCUtil.getConnection();
			
			List<Person> list = pdi.queryPersonsByName(name); 
			
			con.commit();
			
			return list ;
		} catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
			return null ;
		}finally
		{
			try 
			{
				JDBCUtil.close(null,null,con);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public List<Person> getPersonByMobile(String mobile) 
	{
		Connection con = null ;
		PersonDaoImplement pdi = new PersonDaoImplement() ;
		
		try 
		{
			con = JDBCUtil.getConnection();
			
			List<Person> list = pdi.queryPersonsByMobile(mobile); 
			
			con.commit();
			
			return list ;
		} catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
			return null ;
		}finally
		{
			try 
			{
				JDBCUtil.close(null,null,con);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public void dropPersonById(Integer id)
	{
		Connection con = null ;
		PersonDaoImplement pdi = new PersonDaoImplement() ;
		
		try 
		{
			con = JDBCUtil.getConnection();
			
			pdi.deletePerson(id); 
			
			con.commit();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}finally
		{
			try 
			{
				JDBCUtil.close(null,null,con);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}		
	}

	public void editPersonMessage(Integer id, String name, String mobile,
			String telphone, String email, String city, Date date) 
	{
		Connection con = null ;
		PersonDaoImplement pdi = new PersonDaoImplement() ;
		
		try 
		{
			con = JDBCUtil.getConnection();
			
			Person p = new Person(id,name,mobile,telphone,email,city,date);
			pdi.updatePerson(p);; 
			
			con.commit();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}finally
		{
			try 
			{
				JDBCUtil.close(null,null,con);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public List<Person> happyBirthday() 
	{
		Connection con = null ;
		PersonDaoImplement pdi = new PersonDaoImplement() ;
		
		try 
		{
			con = JDBCUtil.getConnection();
			
			List<Person> list = pdi.queryPersonsByMonth() ;
			
			con.commit();
			
			return list ;
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			return null ;
		}finally
		{
			try 
			{
				JDBCUtil.close(null,null,con);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
