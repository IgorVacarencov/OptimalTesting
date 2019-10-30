# OptimalTesting

Here is presented application, which performs handling of the .csv file.

Presented Java application consume a .csv file, parse data and insert to a SQLite In-Memory Database. I

Installation, configuration, and startup instructions:
1. Download & Install SQLite (https://www.sqlitetutorial.net/download-install-sqlite/)
                        SQlite must be installed and source folder must be C:\sqlite3
2. Create source folder for initial document and for document with bad data.
                        Source folder must be C:\OptimalFolderCSV
3. Initial .csv file must be located in source folder and must have name "Interview-task"
               
Operating Instructions:
1. Application automatically checks if the db exist, creates one, if it is needed and creates table X in this db.
2. Application consume a .csv file from source folder, parse data and insert to a SQLite In-Memory Database. 
2. If there is data in .csv file, which is located in out of needed range, then application automatically creates another timestamp.csv file
in source folder, where is stored such information.


Known issues:
Application is capable to handle only .csv file, where there isn't empty spaces (Project version 1.0)


Approach to solve the challenge:

 Was decided to make methods in another class, which will provides concrete implementation for some functions.
In main class (Application.class) remained only needed some lines, which, I hope, provides better understanding of the application.
Some functional was not created/finished due to missunderstanding of the main goal of it.



               
Contact details:
igori.vacarencov@gmail.com
