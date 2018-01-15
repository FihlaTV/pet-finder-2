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

package im.bernier.petfinder.model

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.*
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElements
import javax.xml.bind.annotation.XmlRootElement

/**
* Created by Michael Bernier on 2016-07-09.
*/

@XmlRootElement(name = "pet")
data class Pet(@XmlElement var id: String? = null, @XmlElement var name: String? = null, @XmlElement var age: String? = null, @XmlElement var sex: String? = null, @XmlElement(required = false) var description: String? = null, @XmlElement(required = false) var media: Media? = null, @XmlElement var contact: Contact? = null, @XmlElements var breeds: ArrayList<String> = ArrayList()) {

    val breed: String
        get() {
            val stringBuilder = StringBuilder()
            breeds.indices.forEach { i ->
                stringBuilder.append(breeds[i])
                stringBuilder.append(" ")
            }
            return stringBuilder.toString()
        }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id)
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        bundle.putString("breed", breed)
        bundle.putParcelable("contact", contact?.toBundle())
        return bundle
    }
}
