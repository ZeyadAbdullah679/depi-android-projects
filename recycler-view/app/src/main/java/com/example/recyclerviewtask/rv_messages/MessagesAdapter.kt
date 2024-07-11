package com.example.recyclerviewtask.rv_messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewtask.databinding.ReceivedMessageBinding
import com.example.recyclerviewtask.databinding.SentMessageBinding

class MessagesAdapter : RecyclerView.Adapter<ViewHolder>() {
    private val messages: MutableList<Message> = mutableListOf()

    class SentMessageViewHolder(val binding: SentMessageBinding) : ViewHolder(binding.root)

    class ReceivedMessageViewHolder(val binding: ReceivedMessageBinding) : ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isSender) VIEW_TYPE_SENT else VIEW_TYPE_RECEIVED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_SENT -> {
                val binding = SentMessageBinding.inflate(layoutInflater, parent, false)
                SentMessageViewHolder(binding)
            }

            VIEW_TYPE_RECEIVED -> {
                val binding = ReceivedMessageBinding.inflate(layoutInflater, parent, false)
                ReceivedMessageViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        when (holder) {
            is SentMessageViewHolder -> {
                holder.binding.name.text = message.name
                holder.binding.message.text = message.content
                holder.binding.time.text = message.time.toString()
            }

            is ReceivedMessageViewHolder -> {
                holder.binding.name.text = message.name
                holder.binding.message.text = message.content
                holder.binding.time.text = message.time.toString()
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    fun attachToRecyclerView(recyclerView: RecyclerView) {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder, target: ViewHolder): Boolean {
                return false // We don't want to support move operation in this case
            }

            override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                updateList(messages.filterIndexed { index, _ -> index != position })
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }


    fun updateList(newMessages: List<Message>) {
        val diffCallback = MessagesDiffUtil(newMessages, messages)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        messages.clear()
        messages.addAll(newMessages)

        diffResult.dispatchUpdatesTo(this)
    }

    companion object {
        private const val VIEW_TYPE_SENT = 1
        private const val VIEW_TYPE_RECEIVED = 2
    }
}