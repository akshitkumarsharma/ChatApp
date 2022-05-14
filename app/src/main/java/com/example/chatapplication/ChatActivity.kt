package com.example.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent as Intent

class ChatActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var sendButton: ImageView
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: ArrayList<Message>

    var receiveRoom: String?=null
    var senderRoom: String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val name=intent.getStringExtra("name")
        val receiverUid=intent.getStringExtra("uid")

        val senderUid=FirebaseAuth.getInstance().currentUser?.uid

        senderRoom=receiverUid + senderUid
        receiveRoom=senderUid + receiverUid

        supportActionBar?.title=name

        chatRecyclerView=findViewById(R.id.chatRecycleView)
        messageBox=findViewById(R.id.messageBox)
        sendButton=findViewById(R.id.sendButton)
        messageList= ArrayList()
        messageAdapter=MessageAdapter(this,messageList)


    }
}