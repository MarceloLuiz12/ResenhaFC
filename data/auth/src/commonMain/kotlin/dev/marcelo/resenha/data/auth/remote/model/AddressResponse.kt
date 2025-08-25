package dev.marcelo.resenha.data.auth.remote.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    @SerialName("logradouro")
    val street: String,
    @SerialName("bairro")
    val neighborhood: String,
    @SerialName("localidade")
    val city: String,
    @SerialName("uf")
    val stateAbbreviation: String,
    @SerialName("estado")
    val state: String,
    @SerialName("regiao")
    val region: String,
    @SerialName("ddd")
    val areaCode: String,
)