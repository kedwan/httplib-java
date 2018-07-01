package org.xl.mvvm.httpdemo;

import android.os.Bundle;
import android.view.View;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.me.frame.http.BaseResponse;
import org.me.frame.utils.RxUtils;
import org.me.frame.utils.ToastUtils;
import org.xl.mvvm.httpdemo.entity.InfoEntity;
import org.xl.mvvm.httpdemo.utils.RetrofitClient;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHttpContent();
            }
        });
    }

    public void getHttpContent(){
        RetrofitClient.getInstance().create(ApiService.class)
                .versionGet()
                .compose(RxUtils.bindToLifecycle(this))
                .compose(RxUtils.schedulersTransformer())
                .compose(RxUtils.exceptionTransformer())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {

                    }
                })
                .subscribe(new Consumer<BaseResponse<InfoEntity>>() {
                    @Override
                    public void accept(BaseResponse<InfoEntity> response) throws Exception {
                        System.out.println("code : " + response.getCode());
                        if(response.getCode() == 1){
                            System.out.println("version info : " + response.getResult().toString());
                            ToastUtils.showShort("version info : " + response.getResult().toString());
                        }else{
                            ToastUtils.showShort("error " + response.getCode());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("error " + throwable.getMessage());
                        ToastUtils.showShort(throwable.getMessage());
                    }
                });
    }

    private void getHttp(){
        String url = "http://192.168.1.107/version";
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.107/")
//                .build();
//
//        ApiService apiService = retrofit.create(ApiService.class);
//        apiService.checkVersion(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                System.out.println("call " + call.toString() + " response : " + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                System.out.println("call " + call.toString() + " response : " + t.getMessage());
//            }
//        });

    }
}
