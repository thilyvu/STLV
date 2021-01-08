package DAO;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.SQLGrammarException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import CONTROLLER.USER.USERINFO.userInfoControl;
import MODEL.Chitietdonhang;
import MODEL.Donhang;
import MODEL.Giohang;
import MODEL.User;
import MODEL.Xacthucdonhang;
import MODEL.Xacthucuser;
import Mail.SSLEmail;

public class thu {
	
	public static void main(String[] args) {
		try
		{
			/*
			ArrayList<Object[]> list=Cgiohang.Getgiohang("user1");
			for(Object[] x:list)
		    {
		    	for(Object i:x)
		    	{
		    		 System.out.println(i.toString());
		    	}
		    }
			Giohang gh=new Giohang();
			gh.setId_user("user1");
			gh.setId_sp(14);
			gh.setSoluong(3);
			System.out.print(Cgiohang.themgiohang(gh));
			
			Donhang x=new Donhang();
			x.setId_user("user1");
			x.setThoigian(LocalDateTime.now().toString());
			System.out.print(Cdonhang.themdonhang(x));
			
			Donhang x=new Donhang();
			x.setId_user("user1");
			x.setThoigian(LocalDateTime.now().toString());
			int id=Cdonhang.themdonhang(x);
			if(id==0)
			{
				id=Cdonhang.getiddonhangbyuser("user1");
			}
			System.out.print(id+"");
			/*
				ArrayList<Chitietdonhang> list =new ArrayList<Chitietdonhang>();
				list.add(new Chitietdonhang(id,11,1));
				list.add(new Chitietdonhang(id,2,2));
				
				System.out.print(Cchitietdonhang.themdsChitietdh(id, list, "user1"));
			

			 	String str = "2020-12-17T21:39:35.348437500"; 
		       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		        LocalDateTime dateTime = LocalDateTime.parse(str);
		        System.out.println("After Formatting: " + dateTime); 
		        System.out.println( LocalDateTime.now().withNano(0));
		        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		        String formatDateTime = dateTime.format(format);  
		        System.out.println("After Formatting: " + formatDateTime);  
		       
		       ArrayList<Object[]> list=Cthongke.Loaisanpham();
		       for(Object[] x : list)
		       {
		    	   System.out.println(x[0].toString());
		       }
		         */
				/*
		       Giohang gh=new Giohang();
		       gh.setId_sp(24);
		       gh.setId_user("user1");
		       gh.setSoluong(1);
		       
		       System.out.print(Cgiohang.themgiohang(gh));
		       
		       
				
				
			String bang="<table>";
			bang+="<tr>";				
			bang+="<th>Sản phẩm</th>";
			bang+="<th>Tên sản phẩm</th>";
			bang+="<th>Số lượng</th>";
			bang+="<th>Giá</th>";
			bang+="<th>Tổng</th>";	
			bang+="</tr>";
			float tongbill=0;
			ArrayList<Object[]> listct=Cchitietdonhang.GetChitietbyidDonhang(22);
			for(Object[] t:listct)
			{
				bang+="<tr>";		
				bang+="<td> <img src=\""+t[7].toString().trim()+"\" width=\"120px\"></td>";
				bang+="<td>"+t[6].toString().trim()+"</td>";
				bang+="<td>"+t[2].toString()+"</td>";
				bang+="<td>"+t[4].toString()+"</td>";
				bang+="<td>"+Float.parseFloat(t[2].toString())*Integer.parseInt(t[4].toString())+"</td>";
				bang+="</tr>";
				
				tongbill+=Float.parseFloat(t[2].toString())*Integer.parseInt(t[4].toString());
			}
			bang+=" </table>";	
			SSLEmail.sendmail("songoku2505@gmail.com", "STVL:Xác nhận đơn hàng",bang);
				String body="";
			body+="<br><a href=\"https://localhost:8080/shop/cpayment?maxacthuc="+0+"&id="+0+"\"><button>Xác nhận đã giao</button></a>";
			//body+="<br><a href=\"https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox/FMfcgxwKkHgGpMCvwLBjMTWdwtkTbMXv\">Khách đã hủy nhận hàng</a>";
			SSLEmail.sendmail("songoku2505@gmail.com", "Xác nhận giao hàng", body);
			
			JSONArray a=new JSONArray();
			JSONObject obj=new JSONObject();
			obj.put("id", 1);
			obj.put("sl", 100);
			a.add(obj);
			
			ArrayList<Object[]> list=Cdonhang.kiemtrasoluong(a.toJSONString());
			for(Object[] x: list)
			{
				System.out.print(x[0].toString());
				System.out.print(x[1].toString());
				System.out.print(x[2].toString());
				System.out.print(x[3].toString());
			}
			*/
			String body="";
			body+="<a href=\"https://www.w3schools.com\">Visit W3Schools.com!</a>";
			body+="<br> <a href=\"https://stvlshop.herokuapp.com/Cregister?id="+0+"&maxacthuc="+1+"\"></a>";
			SSLEmail.sendmail("songoku2505@gmail.com", "mail", body);
		}
		catch (Exception e) {
			// TODO: handle exception
			
			System.out.print("so luong san pham con lai khong du");
			
		}
	}
}
