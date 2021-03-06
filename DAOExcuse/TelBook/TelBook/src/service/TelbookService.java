package service;


import java.util.Date;
import java.util.List;

import entity.Person;

public interface TelbookService {
	//通过Id查找联系人
	public Person getPersonById(Integer id) ;
	
	//添加联系人需要使用的业务方法
    public void regist(String name,String mobile,String telphone,String email,String city,Date birth) ;
	
    //获得所有的联系人的业务方法
    public List<Person> getAllPerson() ;
    
    
    //根据联系人姓名查找联系人的业务方法
    public List<Person> getPersonByName(String name);
    
    
    //根据手机号码查询相关的联系人的业务方法
    public List<Person> getPersonByMobile(String mobile);
    
    //删除联系人需要调用的业务方法
    public void dropPersonById(Integer id) ;
  
  	//编辑联系人信息需要调用的业务方法
  	public void editPersonMessage(Integer id,String name,String mobile,String telphone,String email,String city,Date date );

    //获得本月过生日的联系人编号
    public List<Person> happyBirthday() ;
}
