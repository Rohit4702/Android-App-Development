package com.internshala.bookish.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.internshala.bookish.R
import com.internshala.bookish.activity.DescriptionActivity
import com.internshala.bookish.model.Book
import com.squareup.picasso.Picasso
import java.util.ArrayList

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashboardViewHolder(view)
    }

    //responsible for recycling and reusing of viewholders
    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book=itemList[position]
        holder.txtBookName.text=book.bookName
        holder.txtBookAuthor.text=book.bookAuthor
        holder.txtBookPrice.text=book.bookprice
        holder.txtBookRating.text=book.bookRating
        //// holder.imgBookImage.setImageResource(book.bookImage)
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)
        //adding click listener for book items
        holder.llContent.setOnClickListener{
            //Toast.makeText(context,"Clicked on ${holder.txtBookName.text}",Toast.LENGTH_SHORT).show()
            val intent= Intent(context,DescriptionActivity::class.java)
            intent.putExtra("book_id",book.bookId)
            context.startActivity(intent)
        }

    }

    ///stores the total number of items of a list
    override fun getItemCount(): Int {
        //for static list we know the number in advance so just return the number.... for eg 5
        //return 5

        //but for dynamic list:
        return itemList.size
    }

    class DashboardViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val txtBookName : TextView = view.findViewById(R.id.txtBookName)
        val txtBookAuthor: TextView= view.findViewById(R.id.txtBookAuthor)
        val txtBookPrice: TextView=view.findViewById(R.id.txtBookPrice)
        val txtBookRating: TextView=view.findViewById(R.id.txtBookRating)
        val imgBookImage: ImageView=view.findViewById(R.id.imgBookImage)
        val llContent:LinearLayout=view.findViewById(R.id.llContent)
    }
}

