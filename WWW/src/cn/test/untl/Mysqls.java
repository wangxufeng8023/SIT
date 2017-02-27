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
		String province="陕西省";//request.getParameter("province");
	    String city="西安市";//request.getParameter("city");
	    String school="初级中学";//request.getParameter("school");
	    String subject="英语";//request.getParameter("subject");
	    String unit="第三单元";//request.getParameter("unit");
	    String grade="小学三年级";//request.getParameter("grade");
	    String radio="复习";//request.getParameter("radio");
	    String ability="一般";//request.getParameter("city");
	    String username="xxx";//(String) getServletContext().getAttribute("username");
	    String characters="良";//(String) getServletContext().getAttribute("characters");
	   
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
	
	String[] province={"北京","天津市","河北省","辽宁省","上海市","湖北省","山西省","陕西省","四川省","广东省","河南省","山东省","江苏省","浙江省","湖南省"};
	String[] beijing={"东城","房山","通州","顺义","西城","昌平","大兴","平谷","怀柔" ,"密云","延庆","朝阳","丰台","石景山","海淀","门头沟"};
	String[] tianjin={"和平","东丽","西青","津南","北辰","河东","宁河","武清","静海","宝坻","蓟县"};
	String[] hebei= {"石家庄","张家口","保定","唐山","秦皇岛","承德","邯郸","邢台","衡水","廊坊","沧州"};
	String[]liaoning={"大连市","沈阳市","丹东市","辽阳市","葫芦岛市","锦州市","朝阳市"," 营口市","鞍山市","抚顺市","阜新市","本溪市","盘锦市","铁岭市"};
	String[]hubei={"武汉市","宜昌市","襄樊市","荆州市","恩施州","孝感市","黄冈市","十堰市","咸宁市","黄石市","仙桃市","随州市","天门市","荆门市","潜江市","鄂州市","神农架林区"};
	String[]hunan={"长沙市","邵阳市","常德市","衡阳市","株洲市","湘潭市","永州市","岳阳市","怀化市","郴州市","娄底市","阳市","张家界市","湘西州"};
	String[]sichuan={"成都市","绵阳市","广元市","达州市","南充市","德阳市","广安市"," 阿坝州","巴中市","遂宁市","内江市","凉山州","攀枝花市","乐山市","自贡市","泸州市","雅安市","宜宾市","资阳市","眉山市","甘孜州"};
	String[]henan= {"郑州市","南阳市","新乡市","安阳市","洛阳市","信阳市","平顶山市","周口市","商丘市","开封市","焦作市","驻马店市","濮阳市","三门峡市","漯河市","许昌市","鹤壁市"," 济源市"};
	String[]shanxi={"太原市","大同市","运城市","长治市","晋城市","忻州市","临汾市","吕梁市","晋中市","阳泉市","朔州市"};
	String[]shangxi= {"西安市","咸阳市","宝鸡市","汉中市","渭南市","安康市","榆林市","商洛市","延安市","铜川市"};
	String[]zhejiang={"温州市","宁波市","杭州市","台州市"," 嘉兴市","金华市","湖州市","绍兴市","舟山市"," 丽水市","衢州市"};
	String []username={"xxx","yyy"};
	String[]shanghai={"松江区","宝山区","金山区","嘉定区","南汇区","青浦区","浦东新区","奉贤区"," 闵行区","徐汇区","静安区"," 黄浦区","普陀区","杨浦区","虹口区","闸北区 ","长宁区","崇明县","卢湾区"};
	String[]jiangsu= {"苏州市","徐州市","盐城市","无锡市","南京市","南通市","连云港市","常州市","扬州市","镇江市","淮安市","泰州市","宿迁市"};
	String[]guangdong={"东莞市","广州市","中山市","深圳市","惠州市","江门市","珠海市","汕头市","佛山市","湛江市","河源市","肇庆市","潮州市","清远市","韶关市","揭阳市","阳江市","云浮市","茂名市","梅州市","汕尾市"};
	String[] shandong={"济南市","青岛市","临沂市","济宁市","菏泽市","烟台市","泰安市","淄博市","潍坊市","日照市","威海市","滨州市","东营市","聊城市","德州市","莱芜市","枣庄市"};
	String[] school=  {"第一中学","初级中学","民族中学","第四初级中学","第二初级中学","中心小学","新世纪高中","市级附中","人民小学","第五中学"};	
	String[]characters={"及格","良","优"};
	String[]subject={"语文","数学","英语","历史","政治","地理","生物","化学","物理","实验"};
	String[]grade={"小学一年级","小学二年级","小学三年级","小学四年级","小学五年级","小学六年级","初中一年级","初中二年级","初中三年级","高中一年级","高中二年级","高中三年级"};
	String[]unit={"第一单元","第二单元","第三单元","第四单元","第五单元","第六单元","第七单元","第八单元","第九单元","第十一单元","第十二单元"};
    String []ability={"差","一般","突出"};
    String[]radio={"预习","复习"};
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
	//用户输入上次的真实时间rtime
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
		String flag="修改失败，请重试。。。。";
	   if(i==1)
		{flag="修改成功";}
	   return flag;
	}
	//验证手机号
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
	    // 结果集
	    String result="手机号正确";
	    ResultSet rs=null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			while(rs.next()) {
			// 选择sname这列数据
				result= "手机号已经被注册";
			 
			                 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//删除试图
	public static String drop(Connection conn) throws SQLException{
		 String sql1= "drop view result";
		 PreparedStatement ps1 = null;
		 ps1 = (PreparedStatement) conn.prepareStatement(sql1);
	     
	 
	     // 结果集
	     ps1.executeUpdate();
	     return "result被删除了";
	}
	     public static String drops(Connection conn) throws SQLException{
	     String sql= "drop view results";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	     
	 
	     // 结果集
	     ps.executeUpdate();
		return "临时试图被删除";
		
	}
	//第四次查找，匹配ability
	public static int search_ability(Connection conn,String ability) throws SQLException{
		String sql= "select count(*) from results where  ability=?";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	   
	     ps.setString(1, ability);
	     // 结果集
	    
	     ResultSet rs = ps.executeQuery();
	     int a=0;
	 while(rs.next()){a=rs.getInt("count(*)");}
	     return a;
	     
		
		
		
		
	}
	//第三次查找数据。
	public static int search_character(Connection conn,String characters) throws SQLException{
		String sql= "select count(*) from results where  characters=?";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	
	     ps.setString(1, characters);
	     // 结果集
	    
	     ResultSet rs = ps.executeQuery();
	 
	     int a=0;
		 while(rs.next()){a=rs.getInt("count(*)");}
		
		 
		     return a;
		     
	     
		
		
		
		
	}
	//向数据库中插入数据（原始模拟的数据）
   //第二次获得跟精确的数据
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
	     // 结果集
	     ps1.executeUpdate();
	     int a=0;
	     while(rs.next()){
	     a=rs.getInt("count(*)");
	     }
	     return a;
	}
	     // 结果集
	    
	//第一次获得匹配的数据
	public static int[] search(Connection conn,String grade,String subject,String unit,String radio) throws SQLException{
		 drop(conn);
		String sql= "select distinct rtime from record where grade=? and subject=? and unit=? and radio=? order by rtime asc";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	     ps.setString(1, grade);
	     ps.setString(2, subject);
	     ps.setString(3, unit);
	     ps.setString(4, radio);
	     //创建出试图。
	     String sql1= "create view result as select * from record where grade=? and subject=? and unit=? and radio=? order by rtime asc";
		 PreparedStatement ps1 = null;
		 ps1 = (PreparedStatement) conn.prepareStatement(sql1);
	     ps1.setString(1, grade);
	     ps1.setString(2, subject);
	     ps1.setString(3, unit);
	     ps1.setString(4, radio);
	     ps1.executeUpdate();
	     // 结果集
	   
	     // 结果集
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
		 String sql= "insert into record (username,province,city,school,grade,subject,unit,radio,ability,etime,record_time,characters) values(?,?,?,?,?,?,?,?,?,?,?,?)";  //sql语句不再采用拼接方式，应用占位符问号的方式写sql语句。	
		 String flag="数据存储成功，等待匹配";
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String record_time=df.format(new Date(System.currentTimeMillis()));// new Date()为获取当前系统时间
	        PreparedStatement ps1 = null;
	        
	         ps1=(PreparedStatement) conn.prepareStatement(sql);
	         ps1.setString(1, username); //对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
	         ps1.setString(2, province); 
			 ps1.setString(3, city);
	         ps1.setString(4, school);
	         ps1.setString(5, grade);
	         ps1.setString(6, subject); //对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
	         ps1.setString(7, unit); 
			 ps1.setString(8, radio);
	         ps1.setString(9, ability);
	         ps1.setInt(10,etime);
	         ps1.setString(11,record_time);
	         ps1.setString(12,characters);
	       
	         int i=ps1.executeUpdate();
	         if(i==0)
	         {
	        	 flag="输入数据有误";
	        	 }
			 return flag;
	
	
	
	}
	public static String login(Connection conn, String username,String password) throws SQLException{
		 String sql= "select * from user where username=? and password=?";
		 PreparedStatement ps = null;
		 ps = (PreparedStatement) conn.prepareStatement(sql);
	     ps.setString(1, username);
	     ps.setString(2, password);
	     
	     // 结果集
	     String result="用户名或密码错误";
	     ResultSet rs = ps.executeQuery();
	     while(rs.next()) {
	   	    
	         // 选择sname这列数据
	         result="登录成功";
	     
	        }
	     return result;
	     }

		
		
		
	
	public static String register(Connection conn, String username,String password,String phone,String email,String characters) throws SQLException, ClassNotFoundException{
		 String flag="注册成功";	
		//首先验证用户的用户名有没有被注册
			PreparedStatement ps = null;
			String sql1= "select * from user where username=?";
			ps = (PreparedStatement) conn.prepareStatement(sql1);
		    ps.setString(1,username);
		    // 结果集
		    String result="";
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		   	// 选择sname这列数据
		    	result="用户名已被注册";
		     
		                     }
		    //往mysql中加入数据；
		    PreparedStatement ps2 = null;
			String sql2= "select * from user where email=?";
			ps2 = (PreparedStatement) conn.prepareStatement(sql2);
		    ps2.setString(1,email);
		    // 结果集
		    String result1="";
		    ResultSet rs1 = ps2.executeQuery();
		    while(rs1.next()) {
		   	// 选择sname这列数据
		    	result1="邮箱已被注册";
		     
		                     }
		    //往mysql中加入数据；
		   
	         if(result=="用户名已被注册")
	         {
	        	 return "用户名已被注册";
	         }
	         
	         else if(result1=="邮箱已被注册")
    		 {
	        	 return "邮箱已被注册";
    		 }
	         else{
	        	 String sql= "insert into user (username,password,phone,email,characters)values(?,?,?,?,?)";  //sql语句不再采用拼接方式，应用占位符问号的方式写sql语句。
	 	       
	 	        PreparedStatement ps1 = null;
	 	         ps1=(PreparedStatement) conn.prepareStatement(sql);
	 	         ps1.setString(1, username); //对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
	 	         ps1.setString(2, password); 
	 			 ps1.setString(3, phone);
	 	         ps1.setString(4, email);
	 	         ps1.setString(5, characters);
	 	         int i=ps1.executeUpdate();
	 	         
	 	         while(i==0){
	 	        	 flag="网络忙，请重试。。。";
	 	         }
	         }
	         
	        	 
	        	 return flag;
	         
	     }
	
	// 链接本地数据库程序，返回conn为操作数据库提供接口
	public static Connection  connect() throws ClassNotFoundException, SQLException{
		 String driver = "com.mysql.jdbc.Driver";

		   // URL指向要访问的数据库名scutcs
		   String url = "jdbc:mysql://127.0.0.1:3306/project";

		   // MySQL配置时的用户名
		   String user = "root"; 

		   // MySQL配置时的密码
		   String password = "wangxufeng";


		    // 加载驱动程序
		    Class.forName(driver);

		    // 连续数据库
		    Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
		
	}
}
