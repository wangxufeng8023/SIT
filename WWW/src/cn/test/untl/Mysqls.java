package cn.test.untl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;


public class Mysqls {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Connection conn=connect();	 
		String province="����ʡ";//request.getParameter("province");
	    String city="������";//request.getParameter("city");
	    String school="������ѧ";//request.getParameter("school");
	    String subject="Ӣ��";//request.getParameter("subject");
	    String unit="������Ԫ";//request.getParameter("unit");
	    String grade="Сѧ���꼶";//request.getParameter("grade");
	    String radio="��ϰ";//request.getParameter("radio");
	    String ability="һ��";//request.getParameter("city");
	    String username="xxx";//(String) getServletContext().getAttribute("username");
	    String characters="��";//(String) getServletContext().getAttribute("characters");
	   
	    int []a=search( conn,grade,subject,unit,radio);
	    for(int i=0;i<a.length;i++)
	    {
	    	System.out.println(a[i]);
	    }
	    int rtime=26;
	    int w=search_emit(conn,grade,subject,unit,radio,rtime);
	    
	   int x= search_ability(conn,ability);
	   int y=search_character(conn,characters);
	   insert(conn,username,province,city,school,grade,subject,unit,radio,ability,26,characters);
	   System.out.println("w"+w);
	   System.out.println("x"+x);
	   System.out.println("y"+y);
	  
	/*
	
	String[] province={"����","�����","�ӱ�ʡ","����ʡ","�Ϻ���","����ʡ","ɽ��ʡ","����ʡ","�Ĵ�ʡ","�㶫ʡ","����ʡ","ɽ��ʡ","����ʡ","�㽭ʡ","����ʡ"};
	String[] beijing={"����","��ɽ","ͨ��","˳��","����","��ƽ","����","ƽ��","����" ,"����","����","����","��̨","ʯ��ɽ","����","��ͷ��"};
	String[] tianjin={"��ƽ","����","����","����","����","�Ӷ�","����","����","����","����","����"};
	String[] hebei= {"ʯ��ׯ","�żҿ�","����","��ɽ","�ػʵ�","�е�","����","��̨","��ˮ","�ȷ�","����"};
	String[]liaoning={"������","������","������","������","��«����","������","������"," Ӫ����","��ɽ��","��˳��","������","��Ϫ��","�̽���","������"};
	String[]hubei={"�人��","�˲���","�差��","������","��ʩ��","Т����","�Ƹ���","ʮ����","������","��ʯ��","������","������","������","������","Ǳ����","������","��ũ������"};
	String[]hunan={"��ɳ��","������","������","������","������","��̶��","������","������","������","������","¦����","����","�żҽ���","������"};
	String[]sichuan={"�ɶ���","������","��Ԫ��","������","�ϳ���","������","�㰲��"," ������","������","������","�ڽ���","��ɽ��","��֦����","��ɽ��","�Թ���","������","�Ű���","�˱���","������","üɽ��","������"};
	String[]henan= {"֣����","������","������","������","������","������","ƽ��ɽ��","�ܿ���","������","������","������","פ�����","�����","����Ͽ��","�����","�����","�ױ���"," ��Դ��"};
	String[]shanxi={"̫ԭ��","��ͬ��","�˳���","������","������","������","�ٷ���","������","������","��Ȫ��","˷����"};
	String[]shangxi= {"������","������","������","������","μ����","������","������","������","�Ӱ���","ͭ����"};
	String[]zhejiang={"������","������","������","̨����"," ������","����","������","������","��ɽ��"," ��ˮ��","������"};
	String []username={"xxx","yyy"};
	String[]shanghai={"�ɽ���","��ɽ��","��ɽ��","�ζ���","�ϻ���","������","�ֶ�����","������"," ������","�����","������"," ������","������","������","�����","բ���� ","������","������","¬����"};
	String[]jiangsu= {"������","������","�γ���","������","�Ͼ���","��ͨ��","���Ƹ���","������","������","����","������","̩����","��Ǩ��"};
	String[]guangdong={"��ݸ��","������","��ɽ��","������","������","������","�麣��","��ͷ��","��ɽ��","տ����","��Դ��","������","������","��Զ��","�ع���","������","������","�Ƹ���","ï����","÷����","��β��"};
	String[] shandong={"������","�ൺ��","������","������","������","��̨��","̩����","�Ͳ���","Ϋ����","������","������","������","��Ӫ��","�ĳ���","������","������","��ׯ��"};
	String[] school=  {"��һ��ѧ","������ѧ","������ѧ","���ĳ�����ѧ","�ڶ�������ѧ","����Сѧ","�����͸���","�м�����","����Сѧ","������ѧ"};	
	String[]characters={"����","��","��"};
	String[]subject={"����","��ѧ","Ӣ��","��ʷ","����","����","����","��ѧ","����","ʵ��"};
	String[]grade={"Сѧһ�꼶","Сѧ���꼶","Сѧ���꼶","Сѧ���꼶","Сѧ���꼶","Сѧ���꼶","����һ�꼶","���ж��꼶","�������꼶","����һ�꼶","���ж��꼶","�������꼶"};
	String[]unit={"��һ��Ԫ","�ڶ���Ԫ","������Ԫ","���ĵ�Ԫ","���嵥Ԫ","������Ԫ","���ߵ�Ԫ","�ڰ˵�Ԫ","�ھŵ�Ԫ","��ʮһ��Ԫ","��ʮ����Ԫ"};
    String []ability={"��","һ��","ͻ��"};
    String[]radio={"Ԥϰ","��ϰ"};
    int j=0;
    int[] etime={47,45,43,42,39,38};
    int [] rtime={49,47,45,42,41,39};
		
		
		
		
		
		String characterss=characters[0];
		for(int z=0;z<200;z++)
			
		{	
		 String radios=radio[0];
		  String abilitys=ability[0];
		 
			Random r=new Random();
			int m=r.nextInt(11);
			int h=r.nextInt(6);
			int etimes=etime[h];
			int b=r.nextInt(6);
		int  rtimes=rtime[b];
			 String units=unit[m];
		    int x=r.nextInt(15);
			String provinces=province[x];
			String grades=grade[z%10];
		    String subjects=subject[z%10];
			String usernames=username[z%2];
			String schools=school[z%10];
			String citys=null;
			int q=r.nextInt(16);
			int w=r.nextInt(9);
			int e=r.nextInt(11);
			int t=r.nextInt(14);
			int y=r.nextInt(18);
			int u=r.nextInt(10);
			int i=r.nextInt(21);
			int o=r.nextInt(17);
			int p=r.nextInt(13);
			switch(x)
			{
			case 0:citys=beijing[q];break;
			case 1:citys=tianjin[w];break;
			case 2:citys=hebei[e];break;
			case 3:citys=liaoning[t];break;
			case 4:citys=shanghai[y];break;
			case 5:citys=hubei[u];break;
			case 6:citys=shanxi[e];break;
			case 7:citys=shangxi[u];break;
			case 8:citys=sichuan[i];break;
			case 9:citys=guangdong[i];break;
			case 10:citys=henan[u];break;
			case 11:citys=shandong[o];break;
			case 12:citys=jiangsu[p];break;
			case 13:citys=zhejiang[e];break;
			case 14:citys=hunan[t];break;
			
			}
			System.out.println(x);
			String name=insert(conn,usernames,provinces,citys,schools,grades,subjects,units,radios,abilitys,etimes,characterss,rtimes);
		
		
		
	}*/
	}
	//�û������ϴε���ʵʱ��rtime
	public static String update(Connection conn,String rtime,String username) throws SQLException{

		PreparedStatement ps = null;
		String sql1= "update record set rtime=? where username=?";
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			ps.setString(1,rtime);
			ps.setString(2, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   int i=ps.executeUpdate();
		String flag="�޸�ʧ�ܣ������ԡ�������";
	   if(i==1)
		{flag="�޸ĳɹ�";}
	   return flag;
	}
	//��֤�ֻ���
	public static String search_p(Connection conn,String phone)
	{
		Mysqls mysql=new Mysqls();
		
	
		PreparedStatement ps = null;
		String sql1= "select * from user where phone=?";
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			ps.setString(1,phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // �����
	    String result="�ֻ�����ȷ";
	    ResultSet rs=null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			while(rs.next()) {
			// ѡ��sname��������
				result= "�ֻ����Ѿ���ע��";
			 
			                 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//ɾ����ͼ
	public static String drop(Connection conn) throws SQLException{
		 String sql1= "drop view result";
		 PreparedStatement ps1 = null;
		 ps1 = (PreparedStatement) conn.prepareStatement(sql1);
	     
	 
	     // �����
	     ps1.executeUpdate();
	     return "result��ɾ����";
	}
	     public static String drops(Connection conn) throws SQLException{
	     String sql= "drop view results";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	     
	 
	     // �����
	     ps.executeUpdate();
		return "��ʱ��ͼ��ɾ��";
		
	}
	//���Ĵβ��ң�ƥ��ability
	public static int search_ability(Connection conn,String ability) throws SQLException{
		String sql= "select count(*) from results where  ability=?";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	   
	     ps.setString(1, ability);
	     // �����
	    
	     ResultSet rs = ps.executeQuery();
	     int a=0;
	 while(rs.next()){a=rs.getInt("count(*)");}
	     return a;
	     
		
		
		
		
	}
	//�����β������ݡ�
	public static int search_character(Connection conn,String characters) throws SQLException{
		String sql= "select count(*) from results where  characters=?";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	
	     ps.setString(1, characters);
	     // �����
	    
	     ResultSet rs = ps.executeQuery();
	 
	     int a=0;
		 while(rs.next()){a=rs.getInt("count(*)");}
		
		 
		     return a;
		     
	     
		
		
		
		
	}
	//�����ݿ��в������ݣ�ԭʼģ������ݣ�
   //�ڶ��λ�ø���ȷ������
	public static int search_emit(Connection conn,String grade,String subject,String unit,String radio,int rtime ) throws SQLException{
		 drops(conn);
		String sql= "select count(*) from record where grade=? and subject=? and unit=? and radio=? and rtime=?";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	     
		 ps.setString(1, grade);
	     ps.setString(2, subject);
	     ps.setString(3, unit);
	     ps.setString(4, radio);
	     ps.setInt(5, rtime);
	     ResultSet rs = ps.executeQuery();
	     String sql1= "create view results as select * from record where grade=? and subject=? and unit=? and radio=? and rtime=?";
		 PreparedStatement ps1 = null;
		 ps1 = (PreparedStatement) conn.prepareStatement(sql1);
	     
		 ps1.setString(1, grade);
	     ps1.setString(2, subject);
	     ps1.setString(3, unit);
	     ps1.setString(4, radio);
	     ps1.setInt(5, rtime);
	     // �����
	     ps1.executeUpdate();
	     int a=0;
	     while(rs.next()){
	     a=rs.getInt("count(*)");
	     }
	     return a;
	}
	     // �����
	    
	//��һ�λ��ƥ�������
	public static int[] search(Connection conn,String grade,String subject,String unit,String radio) throws SQLException{
		 drop(conn);
		String sql= "select distinct rtime from record where grade=? and subject=? and unit=? and radio=? order by rtime asc";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	     ps.setString(1, grade);
	     ps.setString(2, subject);
	     ps.setString(3, unit);
	     ps.setString(4, radio);
	     //��������ͼ��
	     String sql1= "create view result as select * from record where grade=? and subject=? and unit=? and radio=? order by rtime asc";
		 PreparedStatement ps1 = null;
		 ps1 = (PreparedStatement) conn.prepareStatement(sql1);
	     ps1.setString(1, grade);
	     ps1.setString(2, subject);
	     ps1.setString(3, unit);
	     ps1.setString(4, radio);
	     ps1.executeUpdate();
	     // �����
	   
	     // �����
	     int []a=new int[20];
	     ResultSet rs = ps.executeQuery();
	     int i=0;
	     while(rs.next())
	    	 {
	    		 a[i]=rs.getInt("rtime");
	    		 i++;
	    	 }
	
	     return a;
	     
		
		
		
	}
	
	public static String insert(Connection conn,String username,String province,String city,String school,String grade,String subject,String unit,String radio,String ability,int etime,String characters) throws SQLException{
		 String sql= "insert into record (username,province,city,school,grade,subject,unit,radio,ability,etime,record_time,characters) values(?,?,?,?,?,?,?,?,?,?,?,?)";  //sql��䲻�ٲ���ƴ�ӷ�ʽ��Ӧ��ռλ���ʺŵķ�ʽдsql��䡣	
		 String flag="���ݴ洢�ɹ����ȴ�ƥ��";
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			String record_time=df.format(new Date(System.currentTimeMillis()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
	        PreparedStatement ps1 = null;
	        
	         ps1=(PreparedStatement) conn.prepareStatement(sql);
	         ps1.setString(1, username); //��ռλ������ֵ��ռλ��˳���1��ʼ����һ��������ռλ����λ�ã��ڶ���������ռλ����ֵ��
	         ps1.setString(2, province); 
			 ps1.setString(3, city);
	         ps1.setString(4, school);
	         ps1.setString(5, grade);
	         ps1.setString(6, subject); //��ռλ������ֵ��ռλ��˳���1��ʼ����һ��������ռλ����λ�ã��ڶ���������ռλ����ֵ��
	         ps1.setString(7, unit); 
			 ps1.setString(8, radio);
	         ps1.setString(9, ability);
	         ps1.setInt(10,etime);
	         ps1.setString(11,record_time);
	         ps1.setString(12,characters);
	       
	         int i=ps1.executeUpdate();
	         if(i==0)
	         {
	        	 flag="������������";
	        	 }
			 return flag;
	
	
	
	}
	public static String login(Connection conn, String username,String password) throws SQLException{
		 String sql= "select * from user where username=? and password=?";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	     ps.setString(1, username);
	     ps.setString(2, password);
	     
	     // �����
	     String result="�û������������";
	     ResultSet rs = ps.executeQuery();
	     while(rs.next()) {
	   	    
	         // ѡ��sname��������
	         result="��¼�ɹ�";
	     
	        }
	     return result;
	     }

		
		
		
	
	public static String register(Connection conn, String username,String password,String phone,String email,String characters) throws SQLException, ClassNotFoundException{
		 String flag="ע��ɹ�";	
		//������֤�û����û�����û�б�ע��
			PreparedStatement ps = null;
			String sql1= "select * from user where username=?";
			ps = (PreparedStatement) conn.prepareStatement(sql1);
		    ps.setString(1,username);
		    // �����
		    String result="";
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		   	// ѡ��sname��������
		    	result="�û����ѱ�ע��";
		     
		                     }
		    //��mysql�м������ݣ�
		    PreparedStatement ps2 = null;
			String sql2= "select * from user where email=?";
			ps2 = (PreparedStatement) conn.prepareStatement(sql2);
		    ps2.setString(1,email);
		    // �����
		    String result1="";
		    ResultSet rs1 = ps2.executeQuery();
		    while(rs1.next()) {
		   	// ѡ��sname��������
		    	result1="�����ѱ�ע��";
		     
		                     }
		    //��mysql�м������ݣ�
		   
	         if(result=="�û����ѱ�ע��")
	         {
	        	 return "�û����ѱ�ע��";
	         }
	         
	         else if(result1=="�����ѱ�ע��")
    		 {
	        	 return "�����ѱ�ע��";
    		 }
	         else{
	        	 String sql= "insert into user (username,password,phone,email,characters)values(?,?,?,?,?)";  //sql��䲻�ٲ���ƴ�ӷ�ʽ��Ӧ��ռλ���ʺŵķ�ʽдsql��䡣
	 	       
	 	        PreparedStatement ps1 = null;
	 	         ps1=(PreparedStatement) conn.prepareStatement(sql);
	 	         ps1.setString(1, username); //��ռλ������ֵ��ռλ��˳���1��ʼ����һ��������ռλ����λ�ã��ڶ���������ռλ����ֵ��
	 	         ps1.setString(2, password); 
	 			 ps1.setString(3, phone);
	 	         ps1.setString(4, email);
	 	         ps1.setString(5, characters);
	 	         int i=ps1.executeUpdate();
	 	         
	 	         while(i==0){
	 	        	 flag="����æ�������ԡ�����";
	 	         }
	         }
	         
	        	 
	        	 return flag;
	         
	     }
	
	// ���ӱ������ݿ���򣬷���connΪ�������ݿ��ṩ�ӿ�
	public static Connection  connect() throws ClassNotFoundException, SQLException{
		 String driver = "com.mysql.jdbc.Driver";

		   // URLָ��Ҫ���ʵ����ݿ���scutcs
		   String url = "jdbc:mysql://127.0.0.1:3306/project";

		   // MySQL����ʱ���û���
		   String user = "root"; 

		   // MySQL����ʱ������
		   String password = "wangxufeng";


		    // ������������
		    Class.forName(driver);

		    // �������ݿ�
		    Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
		
	}
}
