package view;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;



import service.TelbookService;
import service.TelbookServiceImplement;
import entity.Person;

import org.junit.Test;

public class TelBookView {
	private Scanner sc=new Scanner(System.in);
	private TelbookService  service=null;
	public TelBookView() {
		try{service = new TelbookServiceImplement();}catch(Exception e){}
	}
	@Test
	public  void showMainView(){
		while(true){
			System.out.println("***************欢迎访问通讯录***************");
			System.out.println("1.显示所有联系人     2.按姓名查找联系人     3.按号码查找联系人");
			System.out.println("4.添加联系人            5.删除联系人                6.修改联系人信息");
			System.out.println("7.生日快乐     8.退出");
			System.out.println("请选择操作：");
			int selected=sc.nextInt();
			requestDispatcher(selected);
		}
	}
	public void  requestDispatcher(int selected) {
		try {
			switch(selected){
			case 1:{ showAllPerson(); break;}
			case 2:{ showPersonsByName(); break;}
			case 3:{ showPersonsByMobil();break;}
			case 4:{ addPerson(); break;}
			case 5:{ dropPersonById(); break;}
			case 6:{changePersonMessageById(); break;}
			case 7:{ sayHappy(); break;}
			case 8:{ 
				System.out.println("--------------------谢谢使用,再见------------------");
				System.exit(0); 
				break;
			}
			default:{
				throw new Exception("输入错误，请考虑重新选择！");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//用户选择功能1,显示所有联系人
	public void  showAllPerson() throws Exception{
		//调用service的查询方法,查询所有的联系人
      List<Person>  list=service.getAllPerson();
      //调用本类的方法显示联系人信息
      showPersons(list);
	}
	//只供本类其他方法是用，用表格形式显示list集合里的联系人信息
	private void showPersons(List<Person> list) throws Exception{
		System.out.println("Id\tName\t  Mobile  \t  Telphone  \t    Email    \t  City  \t  Birthday  ");
		for(Person p:list){
	    	   System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getMobile()+"\t"+p.getTelphone()+"\t"+p.getEmail()+"\t"+p.getCity()+"\t"+p.getBirthday());
	    }
	}
	//用户选择功能2,按姓名查询联系人,允许模糊查询
   public void showPersonsByName() throws Exception{
	   System.out.println("请输入需要查询的联系人姓名（可以模糊查询）：");
	   String name=sc.next();
	   //调用service方法查询相关数据
	   List<Person>  list=service.getPersonByName(name);
	    //调用本类的方法显示联系人信息
      showPersons(list);
   }
   //用户选择功能3,按手机查询联系人,允许模糊查询
	public void showPersonsByMobil() throws Exception{
		 System.out.println("请输入需要查询的联系人手机号码（可以模糊查询）：");
		 String mobile=sc.next();
		 //调用service方法查询相关数据
	   List<Person>  list=service.getPersonByMobile(mobile);
	    //调用本类的方法显示联系人信息
      showPersons(list);
	}
	//用户选择功能4,添加联系人,允许用户名重复
    public void addPerson() throws Exception{
    	System.out.println("请输入联系人姓名：");
    	String name=sc.next();
    	System.out.println("请输入联系人手机号码：");
    	String mobile=sc.next();
    	System.out.println("请输入联系人座机号码：");
    	String telphone=sc.next();
    	System.out.println("请输入联系人email：");
    	String email=sc.next();
    	System.out.println("请输入联系人地址：");
    	String city=sc.next();
    	System.out.println("请输入生日(1980-6-23):");
    	String date=sc.next();
    	
    	//调用service的regist()
    	service.regist(name, mobile, telphone, email, city, Date.valueOf(date));
    	
    	System.out.println("添加联系人成功！！！！");
    }
    //用户选择功能5,删除联系人,需要输入联系人的id
    public void dropPersonById() throws Exception{
       System.out.println("请输入需要删除的联系人的id：");
		   int id=sc.nextInt();	
		   //调用service的方法删除联系人
		   service.dropPersonById(id);
		   System.out.println("-----------删除成功----------");
    }
    //首先需要用户输入被修改用户的id,将该用户信息显示在屏幕上.
    //目前修改联系人只能全表修改,必须给定除id以外的所有值
    public void changePersonMessageById() throws Exception{
    	System.out.println("请输入需要修改的联系人的编号(id):	");
		  int id=sc.nextInt();	
		  //调用service的根据id查询联系人方法,获得联系人具体信息并且显示
		  Person  p=service.getPersonById(id);
		  System.out.println("您要修改的联系人具体信息如下:");
		  System.out.println("Id\tName\t  Mobile  \t  Telphone  \t    Email    \t  City  \t  Birthday  ");
      System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getMobile()+"\t"+p.getTelphone()+"\t"+p.getEmail()+"\t"+p.getCity()+"\t"+p.getBirthday());
      //用户输入修改信息
      System.out.println("请输入联系人姓名：");
    	String name=sc.next();
    	System.out.println("请输入联系人手机号码：");
    	String mobile=sc.next();
    	System.out.println("请输入联系人座机号码：");
    	String telphone=sc.next();
    	System.out.println("请输入联系人email：");
    	String email=sc.next();
    	System.out.println("请输入联系人地址：");
    	String city=sc.next();
    	System.out.println("请输入生日(1980-6-23):");
    	String date=sc.next();
    	//调用service里的修改联系人的方法
    	service.editPersonMessage(id,name,mobile,telphone,email,city,Date.valueOf(date));
      System.out.println("-----------修改成功----------");
    }
    //向本月过生日的联系人发送happybirthday短信
    public void sayHappy(){
    	//调用service的查询方法,查询所有过生日的联系人
      List<Person>  list=service.happyBirthday();
      //调用本类的方法显示联系人信息
      try {
		showPersons(list);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println("哈哈，祝你年年有今日，岁岁有今朝");
    }
}
