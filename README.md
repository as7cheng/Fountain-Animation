# UW-Madison-CS300-Program-2

Introduction

Start by creating a new Java Project in eclipse and adding a new class called Fountain to this project. 
Ensure that this new project uses Java 8, by setting the “Use an execution environment JRE:” drop down 
setting to “JavaSE-1.8” within the new Java Project dialog box. The Fountain.java source file that this 
class is defined within will be the only file that you submit for grading through gradescope.com. If you 
do not already have a gradescope.com account, you should receive an email about setting this up on the 
evening of 1/30 (or you can use your wisc.edu email with this link to update your password: 
https://www.gradescope.com/reset_password). Please contact your instructor, if you do not receive such 
an email. You can make as many submissions as you would like prior to the deadline for this assignment, 
and the submission marked as “active” is the one that will be used for additional grading after the deadline.
Next download this P2ParticleFountain.jar file and copy it into your project folder. If this .jar file is 
not immediately appearing in the Project Explorer, try right-clicking your project folder and selecting 
“Refresh” to fix that. To make use of the code within this jar file, you’ll need to right click on it within 
the Project Explorer and choose “Add to Build Path” from the “Build Path” menu. To ensure that this is working, 
call Utility.runApplication() from the main method within your Fountain class. When you run this program, 
a gray window should appear as a result along with an error message in the console which we’ll resolve in the 
next steps: “ERROR: Could not find method named setup that can take arguments [] in class Fountain.” This jar 
file that you are using makes use of the processing library, which you will get more direct experience with in 
future assignments.
