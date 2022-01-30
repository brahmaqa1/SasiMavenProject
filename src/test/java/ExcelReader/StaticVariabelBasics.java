package ExcelReader;

public class StaticVariabelBasics {

	int eno;
	String name="Ram";
	
	
	
	static String CollegeName = "JNTU HYD"; // static var
	public static void M1()  //  static ethod
	{
		System.out.println("in M1- static ");
	}
	
	static
	{
		System.out.println("in static block");
	}
	public static void main(String[] args) {
		
		StaticVariabelBasics  stobj= new StaticVariabelBasics();
		System.out.println("eno=" +stobj.eno);
		System.out.println("name=" +stobj.name);
//		eno=0
//				name=Ram
		System.out.println("CollegeName=" +stobj.CollegeName);
		stobj.CollegeName="Osmania";
		
		StaticVariabelBasics  stobj2= new StaticVariabelBasics();
		
		//    sttaic k/w
		//  it create only one copy in the menmory --  static  area
		//   and it can be access across all  objects -
		System.out.println("CollegeName=" +stobj2.CollegeName);
		
		/// save memory
		// obj  - gets created heap area 
		
		System.out.println("CollegeName=" +stobj.CollegeName);
		
		//  statci var  can be accessed using classname.statsi var
//		
		
		System.out.println("CollegeName  using class name="+StaticVariabelBasics.CollegeName);
//		CollegeName=JNTU HYD
//				CollegeName=Osmania
//				CollegeName=Osmania
//				CollegeName  using class name=Osmania
		
		// can we use static var in statoc mehod directly?  yes
		System.out.println("static var in static metod="+CollegeName);
		
		// call static methods
//		1.obj
		// 2. class name
		// 3.directly  use in static metohd
		stobj.M1();
		StaticVariabelBasics.M1();
		M1();
		
		
		
	}

}
