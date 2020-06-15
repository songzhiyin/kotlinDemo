package com.szy.kotlindemo.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.TabWidget
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseRecyAdapter
import com.szy.kotlindemo.entity.Studient

class ItemStudientAdapter(mContext: Context) :
    BaseRecyAdapter<ItemStudientAdapter.ViewHoder, Studient>(mContext) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        return ViewHoder(mInflater!!.inflate(R.layout.item_input_studient_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        var entity = getItemData(position)
        var viewHoder = holder as ViewHoder
        viewHoder.edtAge.text = entity?.age
        viewHoder.edtName.text = entity?.name
        var textWatcherName = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                entity?.name = viewHoder.edtName.text.toString().trim()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
        var textWatcherAge = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                entity?.age = viewHoder.edtAge.text.toString().trim()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
        var onFocusChangeListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus) {
                    if (v!!.id == viewHoder.edtName.id) {
                        viewHoder?.edtName.addTextChangedListener(textWatcherName)
                    }
                    if (v!!.id == viewHoder.edtAge.id) {
                        viewHoder?.edtAge.addTextChangedListener(textWatcherAge)
                    }

                } else {
                    if (v!!.id == viewHoder.edtName.id) {
                        viewHoder?.edtName.removeTextChangedListener(textWatcherName)
                    }
                    if (v!!.id == viewHoder.edtAge.id) {
                        viewHoder?.edtAge.removeTextChangedListener(textWatcherAge)
                    }
                }
            }

        }
        viewHoder.edtName.onFocusChangeListener = onFocusChangeListener
        viewHoder.edtAge.onFocusChangeListener = onFocusChangeListener
    }

    class ViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var edtName: TextView = itemView.findViewById(R.id.edtName)
        var edtAge: TextView = itemView.findViewById(R.id.edtAge)

    }
}