Android Sunflower - Java (Thank to zeero0's android-sunflower-java)

added databinding and removed view related code in fragment( I donot know why zeero0 kept view related code in fragement but it's replaced now).

android sunflower jetpack项目的java版本。
技术连续需要，还不能转kotlin，但是需要jeckpack的很多新组件。也看了下github上用到了mvvm，databinding，room，etc的项目，很多star很多的项目都不再维护了，或者issue比较多。正好发现了zeero0的java版本，感谢他。
但是不直到什么原因他没有把databinding做彻底，在一些fragment里还保留了view的纠缠。简单的替换成了databinding，也吧gradle升到了5.1.1.
别的没有动任何东西。
=========================
Java version of Google jetpack sunflower https://github.com/googlesamples/android-sunflower

A gardening app illustrating Android development best practices with Android Jetpack.

Android Sunflower is currently released as an alpha and is under heavy development. To view the latest changes, please visit the Releases page. Note that some changes (such as database schema modifications) are not backwards compatible during this alpha period and may cause the app to crash. In this case, please uninstall and re-install the app.

Introduction
Android Jetpack is a set of components, tools and guidance to make great Android apps. They bring together the existing Support Library and Architecture Components and arranges them into four categories:

Libraries Used

Foundation - Components for core system capabilities, Kotlin extensions and support for multidex and automated testing.
AppCompat - Degrade gracefully on older versions of Android.
Android KTX - Write more concise, idiomatic Kotlin code.
Test - An Android testing framework for unit and runtime UI tests.
Architecture - A collection of libraries that help you design robust, testable, and maintainable apps. Start with classes for managing your UI component lifecycle and handling data persistence.
Data Binding - Declaratively bind observable data to UI elements.
Lifecycles - Create a UI that automatically responds to lifecycle events.
LiveData - Build data objects that notify views when the underlying database changes.
Navigation - Handle everything needed for in-app navigation.
Room - Access your app's SQLite database with in-app objects and compile-time checks.
ViewModel - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
WorkManager - Manage your Android background jobs.
UI - Details on why and how to use UI Components in your apps - together or separate
Animations & Transitions - Move widgets and transition between screens.
Fragment - A basic unit of composable UI.
Layout - Lay out widgets using different algorithms.
Third party
Glide for image loading

