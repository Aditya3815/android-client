/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.network.mappers.clients

import com.mifos.core.objects.noncore.DocumentType
import com.mifos.core.objects.noncore.IdentifierTemplate
import org.apache.fineract.client.models.GetClientsAllowedDocumentTypes
import org.apache.fineract.client.models.GetClientsClientIdIdentifiersTemplateResponse
import org.mifos.core.data.AbstractMapper

/**
 * Created by Aditya Gupta on 30/08/23.
 */

object GetIdentifiersTemplateMapper :
    AbstractMapper<GetClientsClientIdIdentifiersTemplateResponse, IdentifierTemplate>() {

    override fun mapFromEntity(entity: GetClientsClientIdIdentifiersTemplateResponse): IdentifierTemplate {
        return IdentifierTemplate().apply {
            allowedDocumentTypes = entity.allowedDocumentTypes?.map {
                DocumentType().apply {
                    id = it.id
                    name = it.name
                    position = it.position
                }
            }
        }
    }

    override fun mapToEntity(domainModel: IdentifierTemplate): GetClientsClientIdIdentifiersTemplateResponse {
        return GetClientsClientIdIdentifiersTemplateResponse().apply {
            allowedDocumentTypes = domainModel.allowedDocumentTypes?.map {
                GetClientsAllowedDocumentTypes().apply {
                    id = it.id
                    name = it.name
                    position = it.position
                }
            }
        }
    }
}
