/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * If it is not possible or desirable to put the notice in a particular
 * file, then You may include the notice in a location (such as a LICENSE
 * file in a relevant directory) where a recipient would be likely to look
 * for such a notice.
 *
 * You may add additional accurate notices of copyright ownership.
 */

package im.bernier.petfinder.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

import butterknife.BindView
import butterknife.ButterKnife
import im.bernier.petfinder.R
import im.bernier.petfinder.adapter.PetAdapter
import im.bernier.petfinder.model.Pet
import im.bernier.petfinder.mvp.presenter.PetResultPresenter
import im.bernier.petfinder.mvp.view.ResultView

class ResultActivity : BaseActivity(), ResultView {

    @BindView(R.id.result_recycler_view)
    lateinit var recyclerView: RecyclerView

    lateinit var presenter: PetResultPresenter
    lateinit var petAdapter: PetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        ButterKnife.bind(this)
        presenter = PetResultPresenter()
        presenter.setView(this)
        presenter.onAttach()

        if (isTablet) {
            recyclerView.layoutManager = GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false)
        } else {
            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
        recyclerView.setHasFixedSize(true)
        petAdapter = PetAdapter()
        recyclerView.adapter = petAdapter
        petAdapter.setPetClick(object: PetAdapter.PetClick {
            override fun onClick(pet: Pet) {
                presenter.onPetClick(pet)
            }

        })
    }


    override fun doFinish() {
        finish()
    }

    override fun showError(error: String) {
        Snackbar.make(recyclerView, error, Snackbar.LENGTH_LONG).show()
    }

    override fun openPet(pet: Pet) {
        startActivity(Intent(this, PetActivity::class.java))
    }

    override fun updateResults(pets: ArrayList<Pet>) {
        petAdapter.setPets(pets)
    }

}
