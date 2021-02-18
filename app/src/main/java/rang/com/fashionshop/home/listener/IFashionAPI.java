package rang.com.fashionshop.home.listener;

import io.reactivex.Observable;
import rang.com.fashionshop.home.model.BannerDto;
import retrofit2.http.GET;

/**
 * Created by Rang on 18-Aug-20.
 */
public interface IFashionAPI {
    @GET("banners?group=home_banner_main_v2")
    Observable<BannerDto> getBanner();
//
//    @GET("shopping/v2/widgets/quick_link")
//    Observable<QuickLinkDto> getQuickLink();
}
