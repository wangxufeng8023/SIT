package cn.test.study;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import cn.test.untl.Mysqls;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mysqls my=new Mysqls();
		Connection conn=null;
		
	 
	
		try {
			conn = (Connection) my.connect();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    String province="����ʡ";//request.getParameter("province");
	    String city="������";//request.getParameter("city");
	    String school="������ѧ";//request.getParameter("school");
	    String subject="Ӣ��";//request.getParameter("subject");
	    String unit="������Ԫ";//request.getParameter("unit");
	    String grade="Сѧ���꼶";//request.getParameter("grade");
	    String radio="��ϰ";//request.getParameter("radio");
	    response.setContentType("text/html;charset=UTF-8");
	    String ability="һ��";//request.getParameter("city");
	    String username="xxx";//(String) getServletContext().getAttribute("username");
	    String characters="��";//(String) getServletContext().getAttribute("characters");
	    int a=0;
	    try {
			a=process(conn,province,city,school,grade, subject,unit,radio,ability,characters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println(a);
	}
	//���������Ҫѡ��ĸ���
	/*public static double p(Connection conn,String ability,String characters,String school){
		Mysqls my=new Mysqls();
		 
		 
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	     ps.setInt(1, 30);
	     ResultSet rs1 = ps.executeQuery();
	     
	     // �����
	      int i=0;
	    
	      while(rs1.next()){
	    	i++;
	    }
		System.out.println(i);
		
		
		
		
	}*/
//���ر�Ҷ˹�㷨֮�������з���Ҫ�����ݵ�������
	public static int process(Connection conn,String province,String city,String school,String grade,String subject,String unit,String radio,String ability,String characters) throws SQLException{
		 
		int[] sum=null;
	double[] temp=new double[20];
	Mysqls my=new Mysqls();
	 
	 sum=Mysqls.search(conn,grade,subject,unit,radio);
	 for(int i=0;i<sum.length;i++)
	 {
		 if(sum[i]!=0){ 
			double j=(double)my.search_emit(conn,grade,subject,unit,radio,sum[i]);
			 double w=(double)my.search_ability(conn,ability);
			 double m=(double)my.search_character(conn,characters);
		      double p=w/j;
		      double q=m/j;
		      double pro=(double)p*q;
		      temp[i]=pro;
		 
		 }
		 
		 
	 }
	 
	 double demo=0;
	 int u=0;
	 for(int j=0;j<temp.length;j++)
	 { 
		 if(j==0){
		 demo=temp[0];
	 }
	 else if(temp[j]>demo)
	 {
		 demo=temp[j];
		 u=j;
	 }
	 	 
	 }
	 //ɾ����ʱ����ͼ�ļ���
  
     // �����
    return sum[u];
	} 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
 
}
