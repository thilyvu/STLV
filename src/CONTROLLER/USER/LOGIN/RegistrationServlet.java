package CONTROLLER.USER.LOGIN;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cuser;
import DAO.Cxacthucuser;
import MODEL.User;
import MODEL.Xacthucuser;
import Mail.SSLEmail;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   try
   		{
   			String email = request.getParameter("email");
   			String phone = request.getParameter("phone");
   			String password = request.getParameter("mk");
   			String password1 = request.getParameter("mk1");
   			
   			if(!password.equals(password1))
   			{
   				request.setAttribute("matkhau", "Mật khẩu phải trùng nhau");	
   			}
   			else
   			{
   				User x=new User();
   				x.setId_user(email);
   				x.setSdt(phone);
   				x.setEmail(email);
   				x.setPass(password);
   				x.setPermission("0");
   				x.setKichhoat("0");
   				x.setAvatar("https://image.freepik.com/free-vector/cute-blue-dolphin-avatar_79416-75.jpg");
   				if(Cuser.themUser(x)>0)
   				{
   					Xacthucuser xt=new Xacthucuser();
   					xt.setId_user(x.getId_user());
   					xt.setGmail(x.getEmail());
   					int code = (int) Math.floor(((Math.random() * 899999) + 100000));
   					xt.setMaxacthuc(""+code);
   					xt.setTinhtrang("0");
   					int i=Cxacthucuser.themxacthuc(xt);
   					if(i>0)
   					{
	   					String body="";
	   					body+="<br>Chúc mừng bạn đã đăng kí tài khoản tại STVL";
	   					body+="<br>mời bạn vui long click vào link dưới đây để hoàn tất đăng kí";
	   					body+="<br> <a href=\"https://localhost:8080/stlv/Cregister?id="+i+"&maxacthuc="+code+"\">click vào đây</a>";
	   					SSLEmail.sendmail(x.getEmail(), "Xác nhận tài khoản", body);
	   					request.setAttribute("taikhoan", "Chúng tôi vửa gửi tin nhắn xác nhận đến email của bạn");
	   				}
   				}
   				else
   					request.setAttribute("taikhoan", null);	
   			}
   		}
   		catch (Exception e) {
   			// TODO: handle exception
   		}
   		request.getRequestDispatcher("./login/registration.jsp").forward(request, response);
    }
   
}
