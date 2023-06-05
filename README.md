# Cindy's Poker App

[![Build_Status](https://img.shields.io/azure-devops/build/UnifiedPlatform/cindy-poker-test/14)](https://img.shields.io/azure-devops/build/UnifiedPlatform/cindy-poker-test/14)
[![Tests](https://img.shields.io/azure-devops/tests/UnifiedPlatform/cindy-poker-test/14)](https://img.shields.io/azure-devops/tests/UnifiedPlatform/cindy-poker-test/14)
[![Coverage](https://img.shields.io/azure-devops/coverage/UnifiedPlatform/cindy-poker-test/14)](https://img.shields.io/azure-devops/coverage/UnifiedPlatform/cindy-poker-test/14)


This project is is a variant of poker called Five-card draw.

In this as the player receives 5 cards and the cards are evaluated to determine the highest rank. 

## Functionality
- Shuffling of deck
- Deal hand of cards
- Rank evaluation 

## Parameters
Parameter| Required | Type | Description 
--- | --- | --- | ---
hand-size | True | Integer | Number of cards in players' hand 
shuffle.strategy | True | String | Selected strategy method 


There are two shuffling methods available:

Method| Value 
--- | ---
Normal method (default) | normal
Collection method | collection


## Run project
#### Option 1: Maven
- Default
```
mvn spring-boot:run
```

- Specifying shuffle option
```
mvn spring-boot:run -Dspring-boot.run.arguments=--shuffle.strategy=collection
```

#### Option 2: Docker image
- Default
```
docker run -it harbor.labs.epiuse.com/public/poker-app
```

- Specifying shuffle option
```
docker run -it -e SHUFFLE_STRATEGY=collection  harbor.labs.epiuse.com/public/poker-app
```

## Build

To build this project the standard Maven build process can be used
```
mvn clean install
```