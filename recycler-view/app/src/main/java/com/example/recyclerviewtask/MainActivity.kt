package com.example.recyclerviewtask

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewtask.databinding.ActivityMainBinding
import com.example.recyclerviewtask.rv_messages.Message
import com.example.recyclerviewtask.rv_messages.MessagesAdapter
import com.example.recyclerviewtask.rv_messages.PaddingItemDecoration

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val messages = mutableListOf<Message>()

        binding.rvMessages.layoutManager = LinearLayoutManager(this)

        val messagesAdapter = MessagesAdapter()

        // Adapter Customizations
        messagesAdapter.attachToRecyclerView(binding.rvMessages) { messages.removeAt(it) }
        val paddingInDp = 16
        val paddingInPx = (paddingInDp * Resources.getSystem().displayMetrics.density).toInt()
        binding.rvMessages.addItemDecoration(PaddingItemDecoration(paddingInPx))

        binding.rvMessages.adapter = messagesAdapter

        binding.editText.setOnEditorActionListener { _, _, _ ->
            val content = binding.editText.text.toString()
            if (content.isNotBlank()) {
                messages.add(
                    if (binding.switchBtn.isChecked) Message(
                        "Jinx",
                        content,
                        isSender = false
                    ) else Message(
                        "Zeyad Abdullah",
                        content,
                        isSender = true
                    )
                )
                messagesAdapter.updateList(messages)
                binding.editText.text.clear()
            }
            true
        }

        binding.switchBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.switchBtn.text = getString(R.string.receiver)
            } else {
                binding.switchBtn.text = getString(R.string.sender)
            }
        }
    }
}