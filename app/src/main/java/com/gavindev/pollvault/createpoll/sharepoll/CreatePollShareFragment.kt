package com.gavindev.pollvault.createpoll.sharepoll

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.gavindev.pollvault.R
import com.gavindev.pollvault.databinding.CreatePollShareBinding

/**
 * Created by gbrown on 9/10/16.
 */

class CreatePollShareFragment: Fragment() {

    lateinit var viewBinding: CreatePollShareBinding

    lateinit var shareEmails: MutableList<String>

    @BindView(R.id.share_recycler_view)
    lateinit var shareView: RecyclerView

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context as PollSharingEmailsProvider
        shareEmails = context.getPollSharingEmails()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.create_poll_share, container, false)
        val rootView = viewBinding.root
        ButterKnife.bind(this, rootView)

        shareView.layoutManager = LinearLayoutManager(context)
        shareView.adapter = PollShareAdapter(shareEmails)

        return rootView
    }

    @OnClick(R.id.add_share_field)
    fun addPollOption(view: View) {
        shareEmails.add("")
        shareView.adapter.notifyDataSetChanged()
    }
}