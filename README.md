[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/sevjcMrr)
# CS230X-assignment5-F24
# Take a Walk in Cyberspace

In this assignment, you will create a mini web browser that will allow you to travel in cyberspace by visiting webpages and going back when needed.

Goals:
- [ ] Get a better understanding of using interfaces
- [ ] Practice designing a solution using paper, pencil and eraser.
- [ ] Manage program input from the keyboard, a local file, or the Web
- [ ] Using ArrayStack from the package javafoundations
- [ ] Using ArrayList from Java Collections


## Introduction

For this task, you will write an application to visit some web pages and report to the user some information about them.

The input to the program will be initialized with a set of Strings, each representing a url, i.e the web address of a page. Here is an example of such a url string: http://cs.wellesley.edu/~cs230x. These urls will constitute your cyberspace, or the websites that are available for the user to visit.

By using your program, a user can visit a webpage available in your cyberspace. When a user visits a webpage, it gets added to a LIFO history. A user can decide to go back to a previous page, which should remove the top webpage from the history.

Define the following three classes for this application:
- **Webpage**: represents a single web page,
- **Cyberspace**: contains and maintains a collection of Webpage objects and a history stack,
- **CyberspaceExplorer**: the driver for this application.

### Steps to Follow:

1. **Your design in a diagram:**

You are required to submit a diagram which shows your plan for this task. In this diagram show the classes involved in the application, the instance variables and the most important methods in each class. Draw the appropriate arrows to show how the three classes relate to each other.

You can use drawings, words and explanatory short sentences in your diagram. Think carefully about this task, and prepare your diagram early. The more thoughtful your digram is, the easier and more enjoyable your programming will be! Of course it would be fine to make some changes to the design, if you decide so, during the programming phase.

Produce a PDF or JPG file of your diagram, and submit it by uploading it to your gradescope account.

2. **The Webpage class:**
 
The Webpage class represents a web page on the web.

- Design this class based on how it will be used in the other classes in the program, i.e in CyberspaceApp and Cyberspace. Make sure you read the description of this whole exercise carefully before attempting to decide what state (instance variables) and behaviors (methods) a Webpage object should have.

- This class should contain a method with the signature `public static Webpage readAndCreateWebpage(String addr)` that takes a string input corresponding to a URL and reads the page from the web to obtain its HTML code. Note that this method is static.

- As usual, implement the toString() method to provide a String representation of Webpage objects, including its web address (url) and the title of the webpage. The starter code provides a helpful method `getTitle()` to get the title of a webpage. On any website, the title is contained within the `<title>` tags (you can find this by right-clicking on any webpage and going to 'view page source' to view its HTML).
  
- Feel free to define any other methods that might be needed in this class.

- Add a main() method to this class for testing purposes.

2. **The Cyberspace class:**

Cyberspace contains and maintains a collection of Webpage objects and manages a history of Webpages viewed. It is required that you use an ArrayList for your list of Webpages in cyberspace and an ArrayStack (from the implementation provided in this assignment) to manage the history of visited webpages. 

Your Cyberspace implementation must contain:
- a constructor with no arguments
- the ability to add Webpages to the list of webpages in cyberspace
- the ability to visit a webpage (which adds that webpage to the history stack) that exists in cyberspace
- the ability to go back to the last visited webpage from the history
- printing the collection of webpages in cyberspace
- printing the browsing history
- a main() method for testing code

3. **The CyberspaceExplorer class:**

This class is your main driver, it has two main tasks:
- It reads an input file (urls.txt) containing all the urls for your cyberspace. Feel free to add others to the given file.
- After the cyberspace has been initialized from the file, this driver should listens to user input from the keyboard and performs three different tasks depending on what the user inputs.

1) If the user provides a url, the program should check to make sure that the url exists in cyberspace and it should add the corresponding Webpage to the history of visited webpages.
2) If the user inputs 'back', the program should remove the most recently visited webpage from the history and present it back to the user as the webpage they are currently viewing.
3) If the user inputs 'history', the program should print the entire history stack.

Finally, if the user inputs 'q' the program quits.

It uses the Cyberspace and Webpage classes to achieve its goals and produce its output as described earlier. As a driver, it should contain only a main() method. Try for a very short and high level piece of code here. No functionality should be defined in the driver. Just use objects and their methods that have already been defined elsewhere.

## SAVING YOUR WORK ON GITHUB
As we have discussed in class, it is important to work on labs and assignments regularly and save frequently. You should test your work incrementally, which will require you to save your file before compiling/running it. In addition to saving your work on your local machine, you should also frequently push your work to this Github repository. You can refer to Lab0 and the [Git and Github tutorial](https://github.com/CS230X-F24/github-starter-course) for a refresher on using these tools. 

## SUBMITTING TO GRADESCOPE
Turn in your work submitting files Webpage.java, Cyberspace.java and CyberspaceExplorer.java to your Gradescope account. [Click here for Gradescope instructions.](https://docs.google.com/document/d/1zGAJrbdAhfPZVlyDP9N3MmdKXWvNo7rQqehKNM5Q0_M/edit) 

## AUTOGRADER
When you submit your assignment to Gradecope, you will not immediately see feedback. You are welcome to resubmit as many times as you wish until the deadline but you will only receive feedback after the grades have been published. Click here for 230X instructions on: [testing your code](https://docs.google.com/document/d/19cKOyolT8UtSfMNrVw8MGgVWS-lYgHpBs8g2Cf_8Vvc/edit#heading=h.rt39ohf1jp6s), [styling your code](https://docs.google.com/document/d/14uwj9HAjNKfFBm0ZjUpWR7jdqKSj13rudIEJaG74mPk/edit), and [documenting your code](https://docs.google.com/document/d/15uqs_NH8y2sAuLLpiZuSxlI0UsL6a8CHuWY_qcvF4B4/edit). 

## ASSIGNMENT SOLUTIONS
Assignment solutions will not be shared. If you did not get full credit on the assignment, you should review the feedback and ask me or the TAs if you have further questions.   
