博客地址 : [【JetPack】数据绑定 DataBinding 简介 ( 使用要求 | Gradle 版本 | 定义数据类 | 定义数据绑定布局 | Activity 数据绑定 | 绑定类生成规则 )](https://blog.csdn.net/shulianghan/article/details/105538433)



<br>
<br>

#### I . 数据绑定 简介 

---

<br>


**1 . 数据绑定作用 :** <font color=red>不使用 Java 代码 , 直接在 layout 布局文件 中完成组件的 文本 , 图片 等数据 的设置 ; 

<br>

**2 . 数据绑定 与 视图绑定 :** <font color=blue>视图绑定仅仅是替代了 Java 代码中的 findViewById ( ) 操作 , 比视图绑定更进一步 , <font color=red>在替代上述操作的基础上 , 还为其设置了具体的值 ; 数据绑定比视图绑定功能更强大 ; 



<br>
<br>

#### II . 数据绑定 使用前提 ( 环境支持 )

---

<br>

**1 . 数据绑定 ( DataBinding ) 使用前提 :** 

<br>

**① 数据绑定最小兼容版本 :** <font color=blue>Android 4.0 , API 版本 14 ; 

**② Gradle 插件版本 :** <font color=red>1.5.0 以上的版本 ;  


<br>


**2 . Gradle 插件版本 与 Gradle 版本 对应关系 :** <font color=red>推荐使用当前最新配置 ( 2020/04/15 ) , 最新 Gradle 插件版本是 3.6.1 , 最新 Gradle 版本是 5.6.4 ; 

<br>

**① Gradle 插件版本 :** <font color=blue>在 Project 下的 build.gradle 中配置 , 如下配置的是 3.6.1 版本的 Gradle 插件 ; 
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200415194531114.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hhbjEyMDIwMTI=,size_16,color_FFFFFF,t_70)

**② Gradle 版本 :** <font color=red>在 Project 下的 gradle/wrapper/gradle-wrapper.properties 文件中配置 , 如下配置的是 5.6.4 版本的 Gradle ; 

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200415194617978.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hhbjEyMDIwMTI=,size_16,color_FFFFFF,t_70)

<br>

**3 . Gradle 插件版本 与 Gradle 版本对应 关系 :** 如果对应错了 , Android 应用无法编译 ; 

| Gradle 插件版本  | Gradle 版本 |
|--|--|
|1.0.0 - 1.1.3 |	2.2.1 - 2.3 | 
1.2.0 - 1.3.1	 |	2.2.1 - 2.9
1.5.0	 |	2.2.1 - 2.13
2.0.0 - 2.1.2 |		2.10 - 2.13
2.1.3 - 2.2.3	 |	2.14.1+
2.3.0+ |		3.3+
3.0.0+ |		4.1+
3.1.0+ |		4.4+
3.2.0 - 3.2.1	 |	4.6+
3.3.0 - 3.3.2	 |	4.10.1+
3.4.0 - 3.4.1	 |	5.1.1+
3.5.0+	 |	5.4.1-5.6.4


<br>
<br>

#### III . 数据绑定 使用流程 一 : 启用数据绑定

---

<br>

**启用数据绑定 :** <font color=red>在 Module 的 build.gradle 构建脚本中 的 android 中配置如下代码 : 

```java
/** 启用数据绑定 */
dataBinding {
    enabled = true
}
```



<br>
<br>

#### IV . 数据绑定 使用流程 二 : 定义数据类

---

<br>


**定义数据类 :** 

```kotlin
package kim.hsl.db

/** 视图绑定数据类 */
data class Student (var name:String, var age:Int)
```


<br>
<br>

#### V . 数据绑定 使用流程 三 : 定义数据绑定布局

---

<br>

**1 . 定义根标签及命名空间 :** <font color=red>定义 \<layout\> 根标签 , 并且将布局文件的命名空间定义在该标签中 ; 

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- 根标签是 layout, 将根布局的命名空间都拷贝到根标签中 -->
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
</layout>
```

<br>

**2 . 定义对象数据标签 :** <font color=blue>使用 \<data\> 标签 , 在标签中定义 \<variable\> 字标签 ,  在 \<variable\> 标签中使用 name 属性定义变量名 , type 属性定义类的 包名.类名 全路径类型名称 ; 

**如下 :** <font color=green>定义 kim.hsl.db.Student 类的对象 student , 之后就使用 student 变量名来调用类中的字段 , 如 student.name 获取对象的 name 属性 ; 

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- 根标签是 layout, 将根布局的命名空间都拷贝到根标签中 -->
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <!-- data 标签中设置要绑定的对象名称 和 对应的类名 -->
    <data>
        <variable name="student" type="kim.hsl.db.Student"/>
    </data>
</layout>
```

<br>


**3 . 定义实际的布局 :** <font color=orange>定义与 \<data\> 标签平级的布局组件根标签 , 这个布局组件就是原来的根视图 ; 之后的内容就一样了 , 在根视图中 , 定义各种用于 UI 交互的组件 ; 

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- 根标签是 layout, 将根布局的命名空间都拷贝到根标签中 -->
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <!-- data 标签中设置要绑定的对象名称 和 对应的类名 -->
    <data>
        <variable name="student" type="kim.hsl.db.Student"/>
    </data>

    <!-- 实际的布局, 被改造前是根标签 -->
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

<br>


**4 . 调用变量值 :**<font color=red> 在 @{} 中使用布局绑定表达式调用 student 变量的值 , 表达式语法操作与代码基本一致 , 如方位 student 对象的 name 属性 , 使用 @{student.name} 即可 ; 

<font color=blue>该布局是最终的完全体 , 显示内容是 "姓名 : Tom 年龄 : 18" ; 

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- 根标签是 layout, 将根布局的命名空间都拷贝到根标签中 -->
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <!-- data 标签中设置要绑定的对象名称 和 对应的类名 -->
    <data>
        <variable name="student" type="kim.hsl.db.Student"/>
    </data>

    <!-- 实际的布局, 被改造前是根标签 -->
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:id="@+id/hello"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text='@{"姓名 : " + student.name + " 年龄 : " + student.age}'
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```


<br>
<br>

#### VI . 数据绑定 使用流程 四 : Activity 数据绑定

---

<br>







**1 . 声明 数据绑定类 对象 :** <font color=blue>在成员变量中 , 声明数据绑定类对象 ; 

```kotlin
/** 数据绑定类 */
    lateinit var binding : ActivityMainBinding
```

<br>

**2 . 声明 数据类 对象 :**<font color=green> 在成员变量中 , 声明被绑定的数据对象 ; 

```kotlin
/** 要绑定的数据类对象 */
lateinit var student : Student
```

<br>

**3 . 绑定视图 :** <font color=red>使用 DataBindingUtil 的 setContentView 方法 , 绑定视图 , 获取数据绑定类 对象 ; 

```kotlin
/** 绑定视图, 并获取数据绑定类 */
binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
```

<br>

**4 . 绑定数据 :** <font color=blue>创建 Student 对象 , 设置给 数据绑定类 对象 ; 

```kotlin
/** 创建要绑定的数据对象 */
student = Student("Tom", 18)
/** 将要绑定的数据对象设置到数据绑定类中 */
binding.student = student
```

<br>

**5 . Activity 完整代码实现 :** 

```kotlin
package kim.hsl.db

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kim.hsl.db.databinding.ActivityMainBinding

class MainActivity : Activity() {

    /** 要绑定的数据类对象 */
    lateinit var student : Student
    /** 数据绑定类 */
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** 绑定视图, 并获取数据绑定类 */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /** 创建要绑定的数据对象 */
        student = Student("Tom", 18)
        /** 将要绑定的数据对象设置到数据绑定类中 */
        binding.student = student

    }
}
```




<br>
<br>

#### VII . 数据绑定类 生成规则 

---

<br>

**1 . 绑定类 :** <font color=red>数据绑定 与 视图绑定 生成的绑定类是相同的 , 数据绑定类比视图绑定类中多一个被绑定数据变量 ; 

<br>


**2 . 绑定类组件成员名称生成规则 :** <font color=blue>组件中的字段也是按照驼峰式命名生成 , 首字母小节 , 中间的字母首字母大写 , 如 id 是 text_view , 生成的成员变量名称是 textView ;  


**3 . 生成组件字段规则 :** <font color=magenta>只要在布局文件中定义了 id 属性的组件 , 绑定类中就会为该组件生成相应的字段 ; 

<br>

**① 绑定类字段对应布局 ID :**  <font color=green>activity_main.xml 布局文件中 , 第一个和第二个 TextView 都定义了 id 分别是 text_view 和 text_view2 ; 

**② 绑定类生成的字段 :** <font color=purple>那么系统会在 ActivityMainBinding 中生成 TextView textView 和 TextView textView2 两个字段 ; 

**③ 绑定类组件字段访问 :** <font color=orange>通过 ActivityMainBinding 对象可以直接访问这两个组件 ; 

**④ 不生成字段 :** <font color=brown>第三个 TextView 没有定义 id 属性 , ActivityMainBinding 中不会生成该组件对应的字段 ; 


<br>

**4 . 生成绑定数据字段规则 :** <font color=blue>在 \<data\> 标签中定义的数据类对象 , 会在绑定类中生成 ; 




 


