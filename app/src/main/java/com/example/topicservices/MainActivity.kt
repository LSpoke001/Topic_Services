package com.example.topicservices


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.topicservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.simpleService.setOnClickListener {
            Toast.makeText(this, "WORK", Toast.LENGTH_SHORT).show()
            stopService(MyForegroundService.newIntent(this))
            startService(MyService.newIntent(this, 5))
        }
        binding.foregroundService.setOnClickListener {
            Toast.makeText(this, "WORK", Toast.LENGTH_SHORT).show()
            ContextCompat.startForegroundService(
                this,
                MyForegroundService.newIntent(this)
            )
        }
        binding.intentService.setOnClickListener {
            Toast.makeText(this, "WORK", Toast.LENGTH_SHORT).show()
            ContextCompat.startForegroundService(
                this,
                MyIntentService.newIntent(this)
            )
        }
    }
}