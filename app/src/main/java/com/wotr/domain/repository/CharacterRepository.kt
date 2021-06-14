package com.wotr.domain.repository

import com.wotr.data.remote.ApiResult
import com.wotr.data.service.factory.CharacterServiceFactory
import com.wotr.domain.dto.CharacterDto
import retrofit2.HttpException
import java.time.LocalDate

class CharacterRepository {

    private val service = CharacterServiceFactory.getService()

    suspend fun getList(): ApiResult<List<CharacterDto>> {
        return try {
            val response = service.getList()

            val characters = response.docs.map { character ->
                CharacterDto(
                    character.height,
                    character.race ,
                    character.gender ,
                    character.birth ,
                    character.spouse ,
                    character.realm ,
                    character.hair ,
                    character.name ,
                    character.wikiUrl
                )
            }

            ApiResult.Success(characters)
        } catch (error: HttpException) {
            handleError(error)
        }
    }

//    suspend fun getListTypes(): ApiResult<List<ListTypeDto>> {
//        return try {
//            val response = service.getListTypes()
//
//            val types = response.results.map { listType ->
//                ListTypeDto(
//                    listType.name,
//                    listType.type,
//                    LocalDate.parse(listType.publishedSince)
//                )
//            }
//
//            ApiResult.Success(types)
//        } catch (error: HttpException) {
//            handleError(error)
//        }
//    }
//
//    suspend fun getReviews(title: String): ApiResult<List<ReviewDto>> {
//        return try {
//            val response = service.getReviews(title)
//
//            val types = response.results.map { review ->
//                ReviewDto(
//                    LocalDate.parse(review.publicationDate),
//                    review.title,
//                    review.author,
//                    review.summary,
//                    review.url
//                )
//            }
//
//            ApiResult.Success(types)
//        } catch (error: HttpException) {
//            handleError(error)
//        }
//    }

    private fun handleError(error: HttpException): ApiResult<Nothing> {
        return if (error.code() == 404) {
            ApiResult.NoResult
        } else {
            ApiResult.ServerError
        }
    }

}