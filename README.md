# CPU-Memory-Project

This project involved creating a simulated machine or computer using code to develop a CPU and Memory. The project was implemented with interrupts, processes, and a memory and CPU simulation. The memory has 2000 integer entries and supports read and write operations, and reads a specified input file with a program into its array. The CPU class keeps track of different modes like user and system, executes various operations, and handles logical and I/O commands. The processes were implemented using runtime.exec to call the memory class with arguments to determine the file's location. 

sample1: ![sample1](https://user-images.githubusercontent.com/100010326/236336369-8beec43c-cdd5-4c7f-9a0d-4d0f28fba115.PNG)

sample2: ![sample2](https://user-images.githubusercontent.com/100010326/236336394-6d5d72cd-de0c-45e7-936e-91968bc06747.PNG)

sample3: ![sample3](https://user-images.githubusercontent.com/100010326/236336410-47071a00-7991-4bb9-bec8-49bb3b46e817.PNG)

sample4: ![sample4](https://user-images.githubusercontent.com/100010326/236336430-132cbdcd-b049-4aca-99dd-19123f006873.PNG)

## How To Run

﻿Files:
CPU.java -- simulates the CPU, creates processes of Memory.java with arguments to transfer data back and forth. Parent class.
Memory.java -- requests data from pipe and writes data to the address. Child class.
Sample5.txt -- Prints out a special message


Project was created with Intellij
To run with Intellij:
1. Load project
2. Enter project directory via terminal (ex: cd C:\Users\maste\IdeaProjects\Project1\src)
3. Compile project with “javac CPU.java Memory.java
4. Run project with ex: “java CPU sample5.txt 30”
