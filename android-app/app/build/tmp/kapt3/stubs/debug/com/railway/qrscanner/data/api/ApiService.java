package com.railway.qrscanner.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J.\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u00032\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\rJ.\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\u00032\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\rJ.\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u00032\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\u00032\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/railway/qrscanner/data/api/ApiService;", "", "getComponentBySerialId", "Lretrofit2/Response;", "Lcom/railway/qrscanner/data/api/ApiComponent;", "serialId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComponents", "", "skip", "", "limit", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInspections", "Lcom/railway/qrscanner/data/api/ApiInspection;", "getLocations", "Lcom/railway/qrscanner/data/api/ApiLocation;", "getVendors", "Lcom/railway/qrscanner/data/api/ApiVendor;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "components/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getComponents(@retrofit2.http.Query(value = "skip")
    int skip, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.railway.qrscanner.data.api.ApiComponent>>> $completion);
    
    @retrofit2.http.GET(value = "components/{component_id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getComponentBySerialId(@retrofit2.http.Path(value = "component_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String serialId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.railway.qrscanner.data.api.ApiComponent>> $completion);
    
    @retrofit2.http.GET(value = "vendors/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getVendors(@retrofit2.http.Query(value = "skip")
    int skip, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.railway.qrscanner.data.api.ApiVendor>>> $completion);
    
    @retrofit2.http.GET(value = "locations/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLocations(@retrofit2.http.Query(value = "skip")
    int skip, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.railway.qrscanner.data.api.ApiLocation>>> $completion);
    
    @retrofit2.http.GET(value = "inspections/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInspections(@retrofit2.http.Query(value = "skip")
    int skip, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.railway.qrscanner.data.api.ApiInspection>>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}