/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import core.SessionFactoryUtil;
import dto.Student;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Vidurajith
 */
public class StudentService {
    
    
    public static boolean addNewStudent(Student student){
        
        SessionFactory sf=SessionFactoryUtil.getSessionFactory();
        Session session=sf.openSession();
        
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            
            session.save(student);
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
            return true;
        }
    }
    
    public static Student findStudent(int sid){
        Student student=null;
        SessionFactory sf=SessionFactoryUtil.getSessionFactory();
        Session session=sf.openSession();
        
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            
            student=(Student) session.get(Student.class,sid);
            
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
            return student;
        }
    }
    
    public static boolean deleteStudent(Student student){
        
        SessionFactory sf=SessionFactoryUtil.getSessionFactory();
        Session session=sf.openSession();
        
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            
            session.delete(student);
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
            return true;
        }
    }
    
    public static boolean updateStudent(Student student){
        
        SessionFactory sf=SessionFactoryUtil.getSessionFactory();
        Session session=sf.openSession();
        
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            
            session.update(student);
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
            return true;
        }
    }
    
    public static List<Student> getAll(){
        
        List<Student> result=null;
        
        SessionFactory sf=SessionFactoryUtil.getSessionFactory();
        Session session=sf.openSession();
        
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            
            Criteria cr=session.createCriteria(Student.class);
            result=cr.list();
            
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
            return result;
        }
    }
}
