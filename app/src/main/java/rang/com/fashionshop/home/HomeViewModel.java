package rang.com.fashionshop.home;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rang.com.fashionshop.helper.APIConstance;
import rang.com.fashionshop.home.model.BannerDto;

/**
 * Created by Rang on 18-Feb-21.
 */
public class HomeViewModel extends AndroidViewModel {
    private MutableLiveData<BannerDto> mBannerLiveData;
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public HomeViewModel(Application application) {
        super(application);
    }


    public LiveData<BannerDto> getBanner() {
        if (mBannerLiveData == null) {
            mBannerLiveData = new MutableLiveData<>();
            loadBanner();
        }
        return mBannerLiveData;
    }

    private void loadBanner() {
        mCompositeDisposable.add(
                APIConstance.getAPI().getBanner().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<BannerDto>() {
                            @Override
                            public void accept(BannerDto bannerDto) throws Exception {
                                mBannerLiveData.setValue(bannerDto);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d("TAG", "accept: " + throwable.getMessage());
                            }
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
    }
}
