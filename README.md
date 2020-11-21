# Login-Or-CreateAccount
Java Servlet backend with Tomcat; MySQL for simple login system and display basic user information
Most web apps start with system Login.
This mini-project serves both purposes by Building backend with Tomcat 9 & Oracle 11g for simple Login system and Displaying user information.


See how it works->
1) First a Login page will open and if you already have an account (i.e you enter an entry in your database then it will fetch information from userinfo table)


 <img src="LoginImage (2).jpg">
 
 2) If you enter wrong username or password it will show alert.<br>
 
 


 <img src="Screenshot (69).png">
 
 
 3)If you don't have an account (i.e you didn't enter entry in database) click on create account.
 
  <img src="CreateAccount.jpg">
  
  After it you will navigate to Login Page again and to see user information of new user you have to enter username and password.
  
 *************************************************************************************************************************************************************************
 
 <h1>Database commands </h1>
 Create two tables in oracle database->
 
 Table 1-> Create loginIfo table-> <br>
  <b> create table loginIfo(username varchar(20),password varchar(20)); </b>
  
  Table 2-> Create userinfo table-> <br>
  <b> create table userinfo(username varchar(20),name varchar(20),gender varchar(10),age number,salary number);</b>
