package com.companylockers.pvtltd;

import java.util.Scanner;



public class Our_Locker {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=0;char ch='\0';		
		System.out.println("WELCOME TO COMPANY LOCKERS.PVT.LTD");
		System.out.println("LOCKED ME By G.SUVARNAVALLI");
	
		boolean d=true;
		do {
		
		System.out.println("Select any Option");
		System.out.println("1.Existing File names\n2.User Operations\n3.Exit the Application");
			try { n=sc.nextInt();}
		catch(Exception e)  
        {  
            System.out.println("Null Exception occurred");  
           }         
			
		switch(n)
		{
		case 1:System.out.println("All Files are");
	            FileOperations.listFiles();
	            break;
		case 2:
    
			boolean i=true;
			do{
    	 System.out.println("File Operations");
         System.out.println("a. Add File\n b.Delete File \n c.Search File\n d.Back to main menu");
         System.out.println("Pick your Option"); 
         try {
          ch=sc.next().charAt(0);
         }
         catch(Exception e)  
         {  
          System.out.println("Null Exception occurred");  
         }       
         switch(ch) {
         		case'a':System.out.println("Enter the file name to be added");
                 		String fileCreate = sc.next();
                 		FileOperations.createFile(fileCreate);
                 			break;
         		case 'b':
         				System.out.println("Enter the file name to be deleted"); 
         				String fileDelete = sc.next();
         				  
         				// Calling the function to delete the file
         				FileOperations.deleteFile(fileDelete, sc);
         				break;
          
         		case'c':
         				System.out.println("Enter the file name to be searched");
         				String fileSearch = sc.next();
				
         				// Calling the function to search the file
         				FileOperations.searchFile(fileSearch);
         				break;
         		case'd':
         				System.out.println("Current execution context Closed Succesfully......\n");
         				i=false;
         				break;
         				//In the case of unknown input execute this
         		default: System.out.println("Enter valid Option from (a to d)");
         				break;
         }
        
            }while(i==true);
					break;
		case 3:
				sc.close();
				System.out.println("\n Thankyou for using 'LOCKED ME' Application");
				System.exit(1);
				d=false;
				break;
		default:
					//In the case of unknown input execute this
				System.out.println("\n\n Enter a valid Input, Select within the range of 1-3\n");
				break; 
	
		}
		}while(d==true);
		
		
	
	}

}


	

