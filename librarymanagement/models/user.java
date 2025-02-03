package librarymanagement.models;

public class user
{
   private String name;
   private String email;
   private int id;
   private int borrowedbookcount;
   
   public String getname()
   {
	 return name;	   
   }
   public String getemail()
   {
	 return email;	   
   }
   public int getid()
   {
	 return id;	   
   }
   public void setname(String name)
   {
	  this.name=name;	   
   }
   public void setemail(String email)
   {
	  this.email=email;	   
   }
   public void setid(int id)
   {
	  this.id=id;	   
   }
public int getBorrowedBooksCount() {
	
	return borrowedbookcount;
}
public void setBorrowedBooksCount(int i)
{
	this.borrowedbookcount=i;
	
}
public void setId(int id2) {
	// TODO Auto-generated method stub
	
}
public void setName(String name2) {
	// TODO Auto-generated method stub
	
}
public void setEmail(String email2) {
	// TODO Auto-generated method stub
	
}
}
