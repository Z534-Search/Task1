# Yelp-Dataset-Challenge
ILS - Z534 Search Project on Yelp Dataset Challenge

## Group 4 Team Members:
* [Dhvani Deven Kotak](https://github.com/dhvanikotak) (dkotak@indiana.edu)  
* [Manikandan Murugesan](https://github.com/manikandan5) (murugesm@indiana.edu)  
* [Rohit Dandona](https://github.com/rohitdandona) (rdandona@indiana.edu)  
* [Vikrant Kaushal](https://github.com/KaushalVikrant) (vkaushal@indiana.edu)  
* [Yash Sumant Ketkar](https://github.com/yashketkar) (yketkar@indiana.edu)

## Task 1 

Question : Predicting the category of each business

There are a total of around 85k businesses in the Yelp Dataset. Each of the business falls into a list of categories. We try to find the categories of each business from the user reviews and tips information.

We had used machine learning technique to do so. We went through each business and found the tips and reviews for these businesses. We extracted the features from these using Bag of Words model with TF-IDF scores. These features along with the categories of the business are fed to the leaner which learns from these models.

Then from the model, the program goes through the test dataset which classifies it into the list of possible categories.

## Main aspects of the program:

1) Since there were multiple classes, we found out the major categories. Major categories are the ones which a business has to belong to. 

2) Our program when it reads the data from the database and trains and classifies, uses multiple threads of the system. This was done to improve performance and save time. Hence powerful machines with multiple cores will run the classification algorithm pretty fast.

3) The program has been configured to run on a Linux or Mac machine. Incase the user wishes to make it run on a windows machine, the path in the class ImportDataToMongo.java which points to the dataset has to be modified.

## Important Classes:

1) **App.java** - This is the main Application class. This has the call to invoke Data Import into MongoDB and also the call which initiates the classification process.

2) **getBusinessData** - This is the class which goes through each business and calls the respective class to find the Tip and Review information of the business and then train and classifies using Naive Bayes on the features extacted. This class fully utilizes all the cores in the system and then works multithreaded to improve the performance and save time.

3) **getReviewData** - This class has the method which takes in the business id and gives out the review information.

4) **getTipData** - This class has the method which takes in the business id and gives out the tip information.

5) **ImportDataToMongo** - This class has the method which reads in the JSON file from the YELP Dataset and then inserts it into the respective collection depending on the information that is being read.

6) **SVMVersion** - This class does the same as getBusinessData class except that it uses SVM to classify the dataset rather than Naive Bayes.

7) **StopWords** - This class has methods which when invoked check for stop words and remove the same from the data that we have.

8) **util** - This class has some tools which are called in the code whenever needed.

9) **generateGroundTruth** - This class contains the method which generates the ground truth which helps us determine the accuracy of the data classified.

All the classes inside the folder objectStructure contain a class with a structure similar to Business, Review and Tip information so that these can be read into these classes.

## Steps to run the program:

1) Make sure that MongoDB is running

2) Navigate to the Task1 folder and run the following command:

    mvn clean compile assembly:single

   This makes sure that the JAR file with all the dependencies are created.

3) Then navigate into the Target folder where the JAR file is located and run the following command:

    java -cp project-1.0-SNAPSHOT-jar-with-dependencies.jar com.search.core.App <Path>

   <Path> is the directory where the Yelp Dataset is located.

   Sample command:
    
    java -cp project-1.0-SNAPSHOT-jar-with-dependencies.jar com.search.core.App /Users/murugesm/Downloads

   This command would trigger the main application and it would create three files:
    a. groundtruth.txt – File which contains the ground truth
    b. output.txt - File which contains the output for Naïve Bayes
    c. output-svm.txt - File which contains the output for SVM

4) To compare the output with the ground truth, then run the scorer function with the following command:

    python3 scorer.py <Path to groundtruth.txt> <Path to output file>

   This would give us the accuracy of the program.
