package com.gavindev.pollvault.createpoll.sharepoll

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.gavindev.pollvault.R
import com.gavindev.pollvault.createpoll.PollCreatedListener
import com.gavindev.pollvault.databinding.CreatePollShareBinding

/**
 * Created by gbrown on 9/10/16.
 */

class CreatePollShareFragment: Fragment() {

    lateinit var viewBinding: CreatePollShareBinding

    lateinit var shareEmails: MutableList<String>

    lateinit var pollCreatedListener: PollCreatedListener

    @BindView(R.id.share_recycler_view)
    lateinit var shareView: RecyclerView

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        setHasOptionsMenu(true)

        context as PollSharingEmailsProvider
        shareEmails = context.getPollSharingEmails()

        context as PollCreatedListener
        pollCreatedListener = context
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

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_share, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_create_poll -> {
                pollCreatedListener.onPollCreated()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}