# ModuloTech_Test

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)

## General info
This project is a test for a Android Developer position in ModuloTech

The App support 2 languages ( English , French)
and it has also a Dark Mode

And the good thing that this app can change data RealTime for example when you change the
 temperature of a heater it will change directly without clicking another button
	
## Technologies
this project is created with:
* Kotlin
* Android
* Gradle
* JetPack Components

### Choice of Architect 

I've implemented this project following MVVM architecture and DataBinding

The project is devided into this packages : 
* Models : a package that contain the models 
* views : a package that contain views ( Fragment , Activities ) and it's View Models
* utils : contain the logic 
* helpers : contain the methods to persist data
* api : contain api endpoints 
* adapters : contain adapters 

I've Used 2-ways-Data binding and combine it with MVVM architecture so it's really consistence

### Choice of Persistence 

To persist Data there was 2 choices : 

* SqLite
* SharedPreferences

i've choose SharedPreferences because it makes reading the data very easy. and it's better to store 
a small amount of data

### Choice of External Libraries

I've user this libraries : 
* mockito : to substitute Android dependencies with mock objects for Unit Testing
* Retrofit : A type-safe HTTP client for Android and Java ( the most used one )
* Gson : Data Serialisation / deserialization
* Material Design : contain bunch of very good components developed by google

### Proguard

Proguard is activated even in Debug , the only rule added is don't obfuscate models attributes so 
Gson can work normally 
