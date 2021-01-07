# HKTV Coding Interview 
1. Introduction
    1. For this project, it uses the Java Spring Framework for it. It includes the Spring Web, Spring Data JPA and MySQL Driver.
    
1. How to compile and start application?
    1. Import the HKTV_WEARHOUSE_DATABASE.sql to your personal Mysql database
    1. Use your IDE to import that project
    1. For Example, go to the \src\main\java\com\pixeltrice\springbootimportcsvfileapp\SpringBootImportCsvFileAppApplication.java class SpringBootImportCsvFileAppApplication and click debug SpringBootImportCsvFileAppApplication.main() to run the program
    1. You need to change the \src\main\resources\application.properties for your own MySql database setting
    
1. The Daily schedule
    1. Day1
        1. Build up the Mysql
        1. Find the sutible freamwork for this web application
    1. Day2
        1. Implement the menthod to print out the database date
        1. create the four html file
        1. Find a way to read and import the csv file to MySql database
    1. Day3
        1. Implement the menthod to read and import the csv file to MySql database
        1. Test the functions
        
1. Note
    1. The additem.csv is using to add new item to database
        1. Productid is the primarykey in table productid, you need to manutally increase it)
    1. The addtransition.csv is using to add new transition for wearhouse
        1. Recordid is the primaryket in table record, you need to manutally increase it
        1. Locationid: You need to refer to location table to find the corresponding address
        1. Productid: You need to refe to product table to find the corresponding product info
        1. Number: if you try to transfer the product from one wearhouse to other, you need to input two record(e.g [Recordid, Locationid. Number, Productid]1,1,5,1 and 2,2,-5,1 which means you wish to transfer the productid1 from locationid2 to locationid1 and the number is 5)
     
1. Credit
    1. For the function of import the CSV file into Mysql Database using Spring Boot Application is from SHUBHAM KUMAR https://github.com/sk444/spring-boot-import-csv-file-app
