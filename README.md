## Overview

This project repository has 3 sub projects.  
The three sub projects are 'MSA_REF_BIZ_ORDER', 'MSA_REF_BIZ_PAYMENT', and 'MSA_REF_BIZ_STOCK'.  
And this project is managed by 2 Branches.  
The two branches are 'main' and dev'.  
The difference between 'main' and 'dev' can be seen in the 'MSA_REF_BIZ_ORDER' sub project.  
When you build and run the 'main' branch of your 'MSA_REF_BIZ_ORDER' project   
and connect to the 'http://localhost:8081', you can see the UI screen.  
And if you change the branch, build the dev branch, run it.  

## Java and Gradle installation
Download jdk 17 and register bin path - https://www.azul.com/  
Download gradle 7.6 and register bin path - https://gradle.org/releases/    

## Project Directory and Git clone
Make directory C:\Project\CAA  
C:\Project\CAA> git clone https://github.com/architectstory/MSA_REF_PATTERN.git

## How to build and run application? (main branch)  

C:\Project\CAA\MSA_REF_PATTERN> .\gradlew.bat -p MSA_REF_BIZ_ORDER clean build    
C:\Project\CAA\MSA_REF_PATTERN\MSA_REF_BIZ_ORDER\build\libs> ls    
C:\Project\CAA\MSA_REF_PATTERN\MSA_REF_BIZ_ORDER\build\libs> java -jar MSA_REF_BIZ_ORDER.jar    
connect to http://localhost:8081 , you can see the message  "MICRO SERVICE VER. 1.0"  on screen. 

## How to build and run application? (dev branch)

C:\Project\CAA\MSA_REF_PATTERN> git switch dev    
C:\Project\CAA\MSA_REF_PATTERN> git branch    
C:\Project\CAA\MSA_REF_PATTERN> .\gradlew.bat -p MSA_REF_BIZ_ORDER clean build      
C:\Project\CAA\MSA_REF_PATTERN\MSA_REF_BIZ_ORDER\build\libs> ls      
C:\Project\CAA\MSA_REF_PATTERN\MSA_REF_BIZ_ORDER\build\libs> java -jar .\MSA_REF_BIZ_ORDER.jar  
connect to http://localhost:8081 , you can see the message  "MICRO SERVICE VER. 1.0 - DEV"  on screen. 


## Docker Build
Dockerfile
```dockerfile
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17.0.10

EXPOSE 8081

ARG JAR_FILENAME="*.jar"
COPY $JAR_FILENAME /app.jar

CMD ["java", "-XX:+PrintFlagsFinal", "-Dserver.port=8081", "-jar", "/app.jar"]
```

docker run after gradle build.
```
docker build --build-arg JAR_FILENAME=MSA_REF_BIZ_ORDER/build/libs/MSA_REF_BIZ_ORDER.jar -t biz_order:v1 .
docker build --build-arg JAR_FILENAME=MSA_REF_BIZ_PAYMENT/build/libs/MSA_REF_BIZ_PAYMENT.jar -t biz_payment:v1 .
docker build --build-arg JAR_FILENAME=MSA_REF_BIZ_STOCK/build/libs/MSA_REF_BIZ_STOCK.jar -t biz_stock:v1 .

git switch dev
# Build gradle
docker build --build-arg JAR_FILENAME=MSA_REF_BIZ_ORDER/build/libs/MSA_REF_BIZ_ORDER.jar -t biz_order:v2 .
docker build --build-arg JAR_FILENAME=MSA_REF_BIZ_PAYMENT/build/libs/MSA_REF_BIZ_PAYMENT.jar -t biz_payment:v2 .
docker build --build-arg JAR_FILENAME=MSA_REF_BIZ_STOCK/build/libs/MSA_REF_BIZ_STOCK.jar -t biz_stock:v2 .
```

Image save
```
docker save biz_order:v1 biz_payment:v1 biz_stock:v1 | gzip > caa_v1.tar.gz
docker save biz_order:v2 biz_payment:v2 biz_stock:v2 | gzip > caa_v2.tar.gz
```

Image load
```
docker load < caa_v1.tar.gz
docker load < caa_v2.tar.gz
```
## Docker Run
docker run
```
docker run -d -p 8082:8081 --name biz1 public.ecr.aws/q2w5i2w9/biz-order:v1
docker run -d -p 8083:8081 --name biz2 public.ecr.aws/q2w5i2w9/biz-order:v2
```

Browser
```
localhost:8082
localhost:8083
```
