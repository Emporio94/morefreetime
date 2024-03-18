# OOSE Lab Exam Bank

# Task One - Design Decisions

In this task 1 I have to dynamically employ a system that Will group Traders in the correct TraderAssetDesk. The CSV file shows a group of individuals with different roles. Traders and Team Leads. Looking at the Strucutre of the file we can see that there are mutiple groups within eash Asset type under a group Lead. The csv file starts with a Team Lead under a specific Asset Type and all of the individuals under under the team lead for their respective asset type are in that team.

Firstly I utilised the Factory design pattern which will create a Person object by taking certain elements in the csv file row and putting it through the constructur. 

The next and most important part is the utilisation of the Composite Design pattern. This is particularly important as the future task will require checking each trader for each group for each asset deck. I have used a Trading Composite interface which is used for every element in the bank which can trade. The Traders can be grouped in specific which is lead by a group lead and those groups will be 

