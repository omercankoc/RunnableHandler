## Runnable
<p>The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread. The class must define a method of no arguments called run.</p>
<p>This interface is designed to provide a common protocol for objects that wish to execute code while they are active. For example, Runnable is implemented by class Thread. Being active simply means that a thread has been started and has not yet been stopped.</p>

## Handler
<p>A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue. Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler it is bound to a Looper. It will deliver messages and runnables to that Looper's message queue and execute them on that Looper's thread.</p>

### Definition Variables:
```kotlin
private var time : Int = 0
private var hour : Int = 0
private var minute : Int = 0
private var second : Int = 0

var runnable : Runnable = Runnable {  }
var handler : Handler = Handler(Looper.getMainLooper())
```
### Starting the Runnable and Handler:
```kotlin
runnable = object : Runnable {
    override fun run() {
        time += 1
        timer(time)
        handler.postDelayed(this,1000)
    }
}
handler.post(runnable)
```
### Stop Runnable and Handler:
```kotlin
handler.removeCallbacks(runnable)
time = 0
hour = 0
minute = 0
second = 0
timer(time)
```
### Timer Function:
```kotlin
private fun timer(time: Int){

    var second : Int = time
    var minute : Int = second / 60
    second %= 60
    val hour : Int = minute / 60
    minute %= 60

    if(second < 10 && minute < 10 && hour < 10){
        print("0$hour:0$minute:0$second")
    } else if(second < 10 && minute < 10 && hour >= 10){
        print("$hour:0$minute:0$second")
    } else if(second < 10 && minute >= 10 && hour < 10){
        print("0$hour:$minute:0$second")
    } else if(second >= 10 && minute < 10 && hour < 10){
        print("0$hour:0$minute:$second")
    } else if(second >= 10 && minute >= 10 && hour < 10){
        print("0$hour:$minute:$second")
    } else if(second < 10 && minute >= 10 && hour >= 10){
        print("$hour:$minute:0$second")
    } else if(second >= 10 && minute < 10 && hour >= 10){
        print("$hour:0$minute:$second")
    } else if(second >= 10 && minute >= 10 && hour >= 10){
        print("$hour:$minute:$second")
    }
}


```
