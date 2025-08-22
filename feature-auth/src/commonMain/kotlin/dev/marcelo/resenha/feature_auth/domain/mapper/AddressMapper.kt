package dev.marcelo.resenha.feature_auth.domain.mapper

import dev.marcelo.resenha.feature_auth.data.model.AddressResponse
import dev.marcelo.resenha.feature_auth.domain.model.AddressModel

fun AddressResponse.toModel(): AddressModel {
    return AddressModel(
        street = street,
        neighborhood = neighborhood,
        city = city,
        stateAbbreviation = stateAbbreviation,
        state = state,
        region = region,
        areaCode = areaCode
    )
}