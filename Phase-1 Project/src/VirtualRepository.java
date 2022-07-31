
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;


public class VirtualRepository {
	public static void main(String[] args)
	{
		create();
		optionsSelection();
	}
	public static void createMainFolderIfNotPresent(String folderName) {
		
		File file = new File(folderName);
		if (!file.exists()) {
			file.mkdirs();
		
		}
	}
	public static void create() {
		
		VirtualRepository.createMainFolderIfNotPresent("main");
		File file;
		try {
			
			String Names[] = { "New", "Test", "Example", "Sample" };
			for (int j = 0; j < Names.length; j++) {
				file = new File("main//"+Names[j] + ".txt");
				file.createNewFile();
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static void displayFiles() {
		File directoryPath = new File("C:\\Users\\KOPPURAVURI\\Desktop\\Simplilearn Phase-1 Project\\VirtualRepository\\Phase-1 Project\\main");
		String contents[] = directoryPath.list();
	      System.out.println("List of files in ascending order :");
	      for(int i=0; i<contents.length; i++) {
	         System.out.println(contents[i]);
	      }
	      Arrays.sort(directoryPath.list());
	}
	
	public static void options() {
	     System.out.println("\n1. Add a file");
		 System.out.println("2. Delete a user specified file from the existing directory list");
		 System.out.println("3. Search a user specified file from the main directory");
		 System.out.println("4. Back to main menu\n");
        }
	public static void loop() {
		System.out.println("\nEnter your choice:\t");
		Scanner sc1=new Scanner(System.in);
        int ch1=sc1.nextInt();
        switch(ch1) {
        case 1 : System.out.println("Enter the name of the file : ");
                 Scanner sc2=new Scanner(System.in);
                 String new_file=sc2.next();
                 File f = new File("C:\\Users\\KOPPURAVURI\\Desktop\\Simplilearn Phase-1 Project\\VirtualRepository\\Phase-1 Project\\main",new_file);
                 try{f.createNewFile();}
                 catch(Exception e)  
                 {  
                 e.printStackTrace();          
                 }
                 System.out.println("File is added to the directory.");
                 options();
                 loop();
                 break;
        case 2 : System.out.println("Enter the name of the file to be deleted : ");
                 Scanner sc3=new Scanner(System.in);
                 String file1=sc3.next();
                 File directoryPath = new File("C:\\Users\\KOPPURAVURI\\Desktop\\Simplilearn Phase-1 Project\\VirtualRepository\\Phase-1 Project\\main");
       	         String[] flist = directoryPath.list();

                		try
                		{
                			boolean flag=false;
                		for (int i = 0; i < flist.length; i++){
                			String filename = flist[i];
                		if (filename.equals(file1)) {
                		flag=true;
                		}
                		}
                		if (flag){
                			boolean res=Files.deleteIfExists(Paths.get("C:\\Users\\KOPPURAVURI\\Desktop\\Simplilearn Phase-1 Project\\VirtualRepository\\Phase-1 Project\\main",file1));
                	    System.out.println("File is deleted"); }
                		else{System.out.println("File not found");
                		}
                		}
                	
                        	
                        	
                        	catch(NoSuchFileException e) 
                            { 
                                System.out.println("No such file/directory exists"); 
                            } 
                            
                        	catch(IOException e) 
                            { 
                               System.out.println("File Not Found"); 
                            } 
                	         
       	        options();
                loop();
                  break;
         case 3 : System.out.println("Enter the name of the file : ");
                 Scanner sc4=new Scanner(System.in);
                 String file2=sc4.next();
       	         File directoryPath1 = new File("C:\\Users\\KOPPURAVURI\\Desktop\\Simplilearn Phase-1 Project\\VirtualRepository\\Phase-1 Project\\main");
       	         String[] flist1 = directoryPath1.list();
                 int flag1 = 0;
                 if (flist1 == null) {
                 System.out.println("Empty directory.");
                 }
                 else {
                	  for (int i = 0; i < flist1.length; i++) {
                     String filename = flist1[i];
                     if (filename.equals(file2)) {
                   	  System.out.println("File is found in the directory");
                         flag1 = 1;
                     }
                  }
                }
                 if (flag1 == 0) {
               	  System.out.println("File Not Found in the directory");
                 }
                 options();
                 loop();
                 break;
        case 4 : optionsSelection();
                 break;
	        }
	}
	public static void optionsSelection()  {
		System.out.println("Welcome to the Virtual Repository");
		System.out.println("              -Developed by Gayatri");
		System.out.println("\n1. Retreiving the file names in ascending order");
		System.out.println("2. Business-level operations");
		System.out.println("3. Option to close the application");
		System.out.println("\nEnter your choice:\t");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
	    switch(ch) {
	    case 1 : displayFiles();
	             System.out.println("\n");
	    	     optionsSelection();
	    	     break;
	    case 2 : options();
	    	     loop();
	    	     break;
	    case 3 : System.out.println("Closing the application. Thankyou!!");
	             break;
		}
	}
}     