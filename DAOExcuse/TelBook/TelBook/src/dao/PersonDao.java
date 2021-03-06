package dao;
import entity.*;
import java.util.*;
public interface PersonDao
{
      //插入联系人信息
       public Integer insertPerson(Person p) ;
      //更新联系人信息
       public void updatePerson(Person p) ;
      //删除联系人信息
       public void deletePerson(Integer id) ;
      //根据id查询联系人信息
       public Person queryPersonById(Integer id) ;
       //查询所有联系人信息
       public List<Person> queryAllPersons() ;
       //根据姓名模糊查找联系人信息
       public List<Person> queryPersonsByName(String name) ;
       //根据手机号码模糊查找联系人信息
       public List<Person> queryPersonsByMobile(String mobile) ;
       //查看当前月过生日的联系人
       public List<Person> queryPersonsByMonth() ;
}