package com.companylockers.pvtltd;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {
	
	//Bubble sort to sort file in ascending order.
			protected static String[] sort_sub(String array[], int size){
				String temp = "";
				for(int i=0; i<size; i++){
					for(int j=1; j<(size-i); j++){
						if(array[j-1].compareToIgnoreCase(array[j])>0){
							temp = array[j-1];
							array[j-1]=array[j];
							array[j]=temp;
						}
					}
				}
				return array;
			}
			

			
			//File listing function
			protected static void listFiles() {
				
				int fileCount = 0;
			    ArrayList<String> filenames = new ArrayList<String>();
			
				File directoryPath = new File(System.getProperty("user.dir"));
				File[] listOfFiles = directoryPath.listFiles();
				fileCount = listOfFiles.length;
				
				
				System.out.println("Files in ascending Order: ");
				for (int i = 0; i < fileCount; i++) {
				  if (listOfFiles[i].isFile()) {
				    filenames.add(listOfFiles[i].getName());
				  } 
				}
				
				String[] str = new String[filenames.size()];
				 
			    for (int i = 0; i < filenames.size(); i++) {
			        str[i] = filenames.get(i);
			    }
				
			    String[] sorted_filenames = sort_sub(str, str.length);
				
				for(String currentFile: sorted_filenames) {
					System.out.println(currentFile);
				}

			}
			
			//File creation function
					protected static void createFile (String fileToBeCreated) {
						File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeCreated );
						
						try {
							if (file.createNewFile() ) {
							
								System.out.println("File Created!");
									
							}
							else {
								System.out.println("File already exists");
							}
								
							
						} catch (IOException e) {
							
							e.printStackTrace();
						}
			}
			
					protected static void searchFile(String fileToBeSearched) {
					    	int t = 0;
				
						File directoryPath = new File(System.getProperty("user.dir"));
						File[] listOfFiles = directoryPath.listFiles();
					for (int i = 0; i < listOfFiles.length; i++) {
							  if ((listOfFiles[i].getName()).equals(fileToBeSearched)) 
							  {t++;}
							  }
							if(t!=0) {	  
							  System.out.println("File is found");
							}
							  else
								  System.out.println("File is not found or Please check Case Sensitivity in Filename");
					           PrintWriter pw;  
			        try {  
			            pw = new PrintWriter(fileToBeSearched); //may throw exception   
			            pw.println("saved");  
			        }  
			        // providing the checked exception handler  
			        catch (FileNotFoundException e) {  
			              
			            System.out.println(e);  
			        } 
						
}	

					
		//File delete function
	protected static void deleteFile(String fileToBeDeleted, Scanner s)throws Exception {
								
	try  {
			int t=0;
		File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeDeleted );
		File directoryPath = new File(System.getProperty("user.dir"));
		File[] listOfFiles = directoryPath.listFiles();
		for (int i = 0; i <  listOfFiles.length; i++) {
		 if ((listOfFiles[i].getName()).equals(fileToBeDeleted)) {t=i;
			 break;}}
			if(t!=0) {
						System.out.println("Are you sure to delete the file" +(listOfFiles[t].getName()) +"(Y/N)?");
						String c= s.next();
													
						if(c.equalsIgnoreCase("Y")) {
						file.delete();
						System.out.println("Done! File deleted successfully!");
											}
						else 
						System.out.println(" File is not deleted");
									  }
			else
				 System.out.println("File  not deleted as it doesn't exists or Please check Case Sensitivity in FileName");
							}											
catch(Exception e1)
					{
					System.out.println("Exception,"+ e1.getMessage());
									
					}
							}
							
								
							}
				




