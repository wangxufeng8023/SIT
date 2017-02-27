package cn.test.study;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.mysql.jdbc.Connection;

import cn.test.untl.Mysqls;

/**
 * Servlet implementation class Tel
 */
@WebServlet("/Tel")
public class Tel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			String phone=(String)request.getParameter("tel"); 
		
		 response.setContentType("text/html;charset=UTF-8");  
		/*String phone="15702976609";*/
		   Mysqls my=new Mysqls();
			Connection conn=null;
			try {
				conn = (Connection) my.connect();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result=my.search_p(conn, phone);
		    if(result=="手机号正确"){
		 	
		    Random a=new Random();
		    int value=0;
		    int s=1000;
		    for(int i=0;i<4;i++)
		    {
		    	int b=a.nextInt(10);
		    	  value=value+b*s;
		    	  s=s/10;
		    }
		   
		    getServletContext().setAttribute("phone", phone);
		    getServletContext().setAttribute("yanzhengma", value);
		    String info=send(phone, value);
		    System.out.println(info);
		    response.getWriter().write("验证码已经发到您的手机号"+phone+"请注意查收");
	        System.out.println("验证码已经发到您的手机号"+phone+"请注意查收");
	}     
		   else{
		    	
		    	 response.getWriter().write("手机号已经被注册，请换一个手机号");
		   System.out.println("手机号已经被注册，请换一个手机号");
		   }}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static String send(String tel,int num )
	{

	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
	NameValuePair[] data ={ new NameValuePair("Uid", "wangxufeng1"),new NameValuePair("Key", "05ff0733dd7b69c35715"),new NameValuePair("smsMob",tel),new NameValuePair("smsText","欢迎注册学习规划系统,您的验证码为:"+num)};
	post.setRequestBody(data);

	try {
		client.executeMethod(post);
	} catch (HttpException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
	System.out.println(h.toString());
	}
	String result="";
	try {
		result = new String(post.getResponseBodyAsString().getBytes("gbk"));
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	post.releaseConnection();
	return result; //打印返回消息状态

	}
}
