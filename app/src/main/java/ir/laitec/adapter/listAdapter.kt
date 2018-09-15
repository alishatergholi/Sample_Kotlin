package ir.laitec.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ir.laitec.kotlinsample.R
import ir.laitec.model.categoryModel
import kotlinx.android.synthetic.main.listviewitem.view.*

class listAdapter(private val items : ArrayList<categoryModel>,private val context: Context) : BaseAdapter(){

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertview: View?, parent: ViewGroup?): View {
        val viewitem    : View?
        var holder      : viewHolder?
        if (convertview == null){
            val inflater  = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            viewitem = inflater.inflate(R.layout.listviewitem,parent,false)
            holder   = viewHolder(viewitem)
            viewitem.tag = holder
        }else{
            viewitem = convertview
            holder   = convertview.tag as viewHolder
        }

        val item = getItem(position)
        holder.textItem?.text  = item.title
        return viewitem as View
    }

    override fun getItem(p0: Int): categoryModel {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return  items.count()
    }

    private class viewHolder(row : View) {

        var textItem : TextView? = null

        init {
            textItem = row.listTextItem as TextView
        }

    }

}