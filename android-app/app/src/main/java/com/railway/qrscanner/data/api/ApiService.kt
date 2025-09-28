package com.railway.qrscanner.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    
    @GET("components/")
    suspend fun getComponents(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 100
    ): Response<List<ApiComponent>>
    
    @GET("components/{component_id}")
    suspend fun getComponentBySerialId(
        @Path("component_id") serialId: String
    ): Response<ApiComponent>
    
    @GET("vendors/")
    suspend fun getVendors(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 100
    ): Response<List<ApiVendor>>
    
    @GET("locations/")
    suspend fun getLocations(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 100
    ): Response<List<ApiLocation>>
    
    @GET("inspections/")
    suspend fun getInspections(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 100
    ): Response<List<ApiInspection>>
}
