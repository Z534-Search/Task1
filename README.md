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

Main aspects of the program:

1) Since there were multiple classes, we found out the major categories. Major categories are the ones which a business has to belong to. 

2) Our program when it reads the data from the database and trains and classifies, uses multiple threads of the system. This was done to improve performance and save time. Hence powerful machines with multiple cores will run the classification algorithm pretty fast.

3) The program has been configured to run on a Linux or Mac machine. Incase the user wishes to make it run on a windows machine, the path in the class ImportDataToMongo.java which points to the dataset has to be modified.
