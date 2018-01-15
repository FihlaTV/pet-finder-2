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
import android.text.TextUtils
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by Michael on 2016-07-12.
 */

@XmlRootElement(name = "contact")
data class Contact(@XmlElement(required = false) var name: String? = null, @XmlElement(required = false) var address1: String? = null, @XmlElement(required = false) var address2: String? = null, @XmlElement(required = false) var city: String? = null, @XmlElement(required = false) var state: String? = null, @XmlElement(required = false) var zip: String? = null, @XmlElement(required = false) var phone: String? = null, @XmlElement(required = false) var email: String? = null) {

    val address: String
        get() {
            var address = ""
            if (!TextUtils.isEmpty(address1)) {
                address += address1!! + ", "
            }
            if (!TextUtils.isEmpty(address2)) {
                address += address2!! + ", "
            }

            address += "$city, $state, $zip"
            return address
        }

    fun toBundle(): Bundle {
        val bundle: Bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("address", address)
        bundle.putString("email", email)
        bundle.putString("phone", phone)
        bundle.putString("city", city)
        return bundle
    }
}
