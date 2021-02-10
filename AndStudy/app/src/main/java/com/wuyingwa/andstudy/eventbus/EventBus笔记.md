# 事件总线`EventBus`笔记

## What

是一款“发布-订阅”事件总线，用于应用程序内各组件间、组件与后台线程间的通信。

由`green robot`发布的开源库，用于`Android`和`Java`

## Why
在`Android`应用开发过程中，组件间交互相当令人头疼。以前的时候会采用广播的方式进行通信，但是使用广播过于麻烦，效率也不高。
而`EventBus`开销小，代码也更优雅，将发送者和接收者解耦。
所以很多开发团队，选用`EventBus`当做组件间传递信息的工具

## How

### 导入`EventBus`包

```
implementation 'org.greenrobot:eventbus:3.2.0'
```

#### 如果配置proguard
```
-keepattributes *Annotation*
-keepclassmembers class * {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
 
# And if you use AsyncExecutor:
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}
```

### 基本使用步骤
#### 1、定义事件类
```java
public class MessageEvent {
   // 相当于消息类，可以封装需要传递的信息 
}
```

#### 2、在需要订阅事件的地方注册事件
在`Android`中使用时，一般在生命周期开始时，注册事件，在生命周期快结束时，取消监听。

发送事件时，只有对应的类已经注册(订阅)了,才可以接收到事件。

```java

public class XXXActivity {
     @Override
     public void onStart() {
         super.onStart();
         // 订阅事件
         EventBus.getDefault().register(this);
     }
    
     @Override
     public void onStop() {
         super.onStop();
         // 取消订阅事件
         EventBus.getDefault().unregister(this);
     }
 }
```

#### 3、发送事件
```java
EventBus.getDefault().post(new MessageEvent());
```

#### 4、处理事件
```java
// 通过在方法上加注解@Subscribe(可以指定线程), 并在参数中接收传递的消息
@Subscribe(threadMode = ThreadMode.MAIN)
public void onMessageEvent(MessageEvent event) {
    Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
}
```


