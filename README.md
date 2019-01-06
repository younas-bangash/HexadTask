# APIs and Architectures Used

1. Model View ViewModel Architecture (MVVM)
2. RxAndroid 2 for concurrency
3. Dagger2 for managing the dependency tree and also for dependency injection
4. Glide for Image Loading
5. Repository pattern 
6. JUnit for Unit testing 
7. Gson for Json Parsing

#  Advatages of using MVVM
The whole application is built based on the MVVM architectural pattern. The main advatage of using MVVM, there is no two way dependency between ViewModel and Model unlike MVP. Here the view can observe the datachanges in the viewmodel as we are using LiveData which is lifecycle aware. The viewmodel to view communication is achieved through observer pattern (basically observing the state changes of the data in the viewmodel).
