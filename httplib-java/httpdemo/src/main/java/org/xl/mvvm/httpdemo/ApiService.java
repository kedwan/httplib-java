package org.xl.mvvm.httpdemo;


import org.me.frame.http.BaseResponse;
import org.xl.mvvm.httpdemo.entity.InfoEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("version")
    Observable<BaseResponse<InfoEntity>> versionGet();
}
