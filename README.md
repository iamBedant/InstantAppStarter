# InstantAppStarter
Starter Project Structure  for Android Instant app

Get the Sample App on Google Play [here](https://play.google.com/store/apps/details?id=com.iambedant.instantappstarter.app&hl=en).
## Medium Link
https://blog.mindorks.com/android-mvp-architecture-with-instant-app-support-11ba48241a82

## Instant App links

If your mobile device supports Instant App, you can use these links to try it out. To enable Instant Apps, navigate to Settings --> Google --> InstantApps and turn it on.

* https://iambedant.com/source
* https://iambedant.com/newslist/bbc-news

![](https://cdn-images-1.medium.com/max/1800/1*CWeD1UdUbAihM3c36Fi5OA.png)

# Project Architecture
MVP
## High level Structure:
### App Module: 
Responsible for building the Application Apk.
### Instant App Module: 
Responsible for building Instant App Apks.
### Feature Modules:
* **Base Module:** Contains all Common components like Network component, Dependency Injection Setup, Base Activities, Base Presenters, etc.
* **Feature One Module:** Contains all classes for first Instant App, which displays a list of news sources in a recyclerview.
* **Feature Two Module:** Contains all classes for Second Instant App, which displays a list of news stories from a selected source.
* **Other Module:** Contains other files which are not part of Instant App.


![](https://cdn-images-1.medium.com/max/1000/1*mlPE1lXVDfI2ueQlivwyNw.jpeg)

## How to implement a new Feature 
Suppose you want to add a new Feature called **MyFeature**
1. Add a new Feature Module(**MyFeature**) from Android studio New Module Wizard.
2. Add one `ActivityModule` and one `ActivityComponent`.
3. Add a `BaseActivityMyFeature` which will extend `BaseActivity` and inject your dependencies there.
4. If you want to make **MyFeature** an Instant App, Add `implementation project(":MyFeature")` to `build.gradle` of `instantapp` module.

You can refer to **other** module for example.

## Library Used
* Dagger2
* RxJava2
* Retrofit2
* Timber
* Rave
* Glide

## BuildFlavours
This Project consist of two Build Flavours.
* **uat** 
* **prod**

**Base url** and **Access keys** for these environments are inside `gradle.properties` file. 

## Build Types
* debug
* release
* qualityassurance

## Known Issues
* Instant App crashes with proguard on with error message
``could not find com.iambedant.instantappstarter.ui.newsSources.NewsSourceActivity in any atom class loader or parent class loader``

## Contributing to the project
If you want to improve this project, your pull requests are most welcome.

## License

```MIT License

Copyright (c) [2017] [Bedanta Bikash Borah]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
