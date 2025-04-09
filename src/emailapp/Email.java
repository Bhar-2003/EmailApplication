package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private final String companySuffix="abc.com";
    private String alternateEmail;

    //Constructor to receive the first name and last name
    public Email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;

        // call a method  asking for the department - return the department
        this.department=setDepartment();

        // call a method that returns a random password
        this.password=randomPassword(8);

        //Combine elements to generate email
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.substring(0,3)+"."+companySuffix;
        System.out.println(showInfo());
        System.out.println("==============================");
    }

    //Ask for the department
    private String setDepartment(){
        System.out.println("Department Code :\n1 for Sales\n2 for Development\n3 for Accounting\nEnter the Department Code :");
        Scanner sc=new Scanner(System.in);
        byte dept_choice=sc.nextByte();
        if (dept_choice==1)
            return "Sales";
        else if(dept_choice==2)
            return "Development";
        else if(dept_choice==3)
            return "Accounting";
        else
            return "Department does not Exists";
    }

    //Generate a random password
    private String randomPassword(int length){
        String password_Set="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
        char[]password=new char[length];
        for(int i=0;i<length;i++){
            int rand=(int)(Math.random()*password_Set.length());
            password[i]=password_Set.charAt(rand);
        }
        return new String(password);
    }

    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }

    //change the password
    public void changePassword(String password){
        this.password=password;
    }

    //getting the alternate Email
    public String getAlternateEmail(){
        return alternateEmail;
    }

    //getting the password
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Name : "+firstName+" "+lastName+
                "\nEmail id : "+email+
                "\nPassword : "+password;
    }
}
