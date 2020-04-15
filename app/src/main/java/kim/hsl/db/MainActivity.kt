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