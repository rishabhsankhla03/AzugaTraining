
#  Azuga Training Program

## About Project

The Project Azuga Training contains the well modularized java files for different functionalities . These codes were written in training with CodeOps as day to day tasks and are uploded to the Github repository,so that they can be used for future references and will be availble for any updates and any suggestions from the people for project upgradation


This project contains codes for linux command like: mv, Cd, Echo, Cp, rm, mkdir, rmdir, date, cat, Pwd, whoami, less, more, touch. That we can run using command line arguement.

This project also contain codes in which I Implemented all the features of “ls” command: 
ls-a, ls-x, ls-r, ls-R, ls-m, ls-la, ls-1 etc. 

It contain codes that can mimic the behaviour, it don’t call the command itself from the program. I implemented all essential command-line options as possible.


It contain codes for Wc command with command line option.

It contain code for pipe ("|") command as well, mainly I have used combinations with cat, sort, head, tail, wc, ls, uniq, grep etc.

It contain code that are cleaned up, with no compiler warning and are tested thoroughly.

It contain proper documentation with all the comments and copyrights.

## Weather_API 

It contain code for Weather API, codes to generate json file and csv file for the given cities. 
One can just put the desired city name and it will get you all the weather information for the following city.

one can get the information in any format one desired, this project contain code for the conversion of "JSON To XML", "CSV to PDF", and "CSV to PDF".


## Codes_for_Chart

Bar chart code: This project also contain bar chart for weather report, where the temperature is seen on y axis and city names can be seen on x axis, we can put as many cities as we want and it will seen on the chart as well.


Pie chart code: This project contain codes to create pie chart for market capital %age for crypto currency, which is the value of all the coin that have been mined, we are considering the tope ten coins of the list with considerable percentage value.  

Line chart: This project contain codes to figure out the value of crypto of last 7 days from the present day and it can fetch the data for any crypto currency listed in the crypto market. The value will be seen on the y axis and days on x axis.

### Project contain all the loggings and documentation, which makes it more readable for any other user.

This project also contain codes to zip and unzip the folder. 
This project also contain codes to write an email and with a method to attach any file one want. 

This project also contain the code to generate the jar file.  


## Acknowledgements

 - [Javatpoint](https://awesomeopensource.com/project/elangosundar/awesome-README-templates) helps to write the correct code snippet.
 - [GeeksforGeeks](https://github.com/matiassingers/awesome-readme)helps in understanding all the basic doubts related to the programming.
 - [Baeldung](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)helps in understanding all the queries related to logging, and zip-UnZip program.


## Installation
## The FrameWorks used to build these java files are:

The project doesnot need any installation , by adding this project to the IDE's workspace and adding all the required jar files given below to the class path the project will surve its purpose.
### Prerequisites 
The Project has some Prerequisites, jar files / libraries must be installed or added to the dependency’s. Following are required Jar files to add to the classPath for different features,
1. [pdfunit-java-2016.05.jar](http://www.pdfunit.com/en/download/)
2. [javax.mail.jar](https://jar-download.com/artifacts/com.sun.mail/javax.mail/1.6.1/source-code)
3. [activation-1.1.1.jar](https://jar-download.com/artifacts/javax.activation/activation/1.1.1/source-code)
4. [jfreechart-1.5.3.jar](https://search.maven.org/artifact/org.jfree/jfreechart/1.5.3/jar)
5. [Underscore-1.81.jar](https://mavenlibs.com/jar/file/com.github.javadev/underscore)
6. [opencsv-1.7.jar](https://jar-download.com/?search_box=opencsv-1.7)
7. [jflat-core-1.3.8.jar](https://jar-download.com/?search_box=JFlat)
8. [commans.io.2.11.0.jar](https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0)
9. [itextpdf-5.1.0.jar](https://mvnrepository.com/artifact/com.itextpdf/itextpdf/5.1.0)
10. [zip4j-2.11.2.jar](https://mvnrepository.com/artifact/net.lingala.zip4j/zip4j/2.11.2)

- if any of them are not working try out the latest versions of jar file    
## API Reference

#### Get all items

```API key to get the weather information of any "i" city.
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. "http://api.weatherapi.com/v1/current.json?key=95c78ce997844bb184340839222809&q=" + city[i] + "&aqi=yes"; |

#### Get item

```http
  API key to get information of any "i" crypto currency. 
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. "https://api.coingecko.com/api/v3/coins/polkadot/market_chart?vs_currency=usd&days=7&interval=daily" |


## Appendix

The Project Azuga Training has codes for different applications like,
- Linux-commands
The project contains programs that mimics some of the basic Linux-Commands like cat, wc, head, tail, sort, ls etc

- Api-Calls
It is included with programs for major Api's GET methods to get the data from the Api's and use them to create the .csv and .json files. 

- File-Formatting
The data from the Api's Call method stored in .csv and .json file are formatted to the .xml, .pdf, .html formats.

- Charts Creation
The Api's data in the files are used to create the charts, i.e to visualize the properties of the Api. Bar chart, Pie Chart and Line Chart are created.

- OOps Concepts
OOps concepts like interface, methods, objects, classes, constructors, abstraction etc were also used in the java codes.

- Zip And UnZip
The reports created from the Api calls and Formatters were zipped, unzipped and sent through the mail programatically using java language.


## FAQ

#### What to do when the key got expired?

Answer: You have to generate new key from the same account you created during Weather API site.

#### What to do to get information for any other crypto currency?

Answer: In the place, where you put the url in the code, just put the name of the crypto which is listed in the crypto market, for eg in the place of polkadot one can put dogecoin to check the updates.

## Feedback

If you have any feedback, please reach out to us at rishabh.sankhla20@gmail.com
