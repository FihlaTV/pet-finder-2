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

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by Michael on 2016-10-29.
 */

@XmlRootElement(name = "shelter")
data class Shelter(@XmlElement var id: String? = null, @XmlElement var name: String? = null, @XmlElement(required = false) var address1: String? = null, @XmlElement(required = false) var address2: String? = null, @XmlElement var city: String? = null, @XmlElement var state: String? = null, @XmlElement var country: String? = null, @XmlElement var zip: String? = null, @XmlElement var latitude: Double = 0.toDouble(), @XmlElement var longitude: Double = 0.toDouble(), @XmlElement(required = false) var phone: String? = null, @XmlElement var email: String? = null)

