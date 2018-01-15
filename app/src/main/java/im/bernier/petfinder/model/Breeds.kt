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

import java.util.*
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElements
import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by Michael on 2016-08-06.
 */

@XmlRootElement(name = "petfinder")
data class Breeds(@XmlElements var breeds: ArrayList<String>? = null,
                  @XmlElement var header: ErrorHeader? = null,
                  @XmlAttribute(namespace = "http://www.w3.org/2001/XMLSchema-instance") var noNamespaceSchemaLocation: String? = null)
