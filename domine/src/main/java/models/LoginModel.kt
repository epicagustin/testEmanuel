package models

data class LoginModel(
    var accessToken: String? = null,
    var expiresIn: Int? = null,
    val access_token: String? = null,
    val expires_in: Int? = null,
    val products: List<ProductModel> = emptyList()
)

