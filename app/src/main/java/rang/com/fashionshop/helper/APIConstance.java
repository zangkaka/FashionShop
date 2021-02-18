package rang.com.fashionshop.helper;

import rang.com.fashionshop.home.listener.IFashionAPI;
import rang.com.fashionshop.retrofit.RetrofitClient;

/**
 * Created by Rang on 18-Aug-20.
 */
public class APIConstance {
    public static final String BASE_URL = "https://tiki.vn/api/shopping/v2/";

    public static IFashionAPI getAPI() {
        return RetrofitClient.getRetrofit(BASE_URL).create(IFashionAPI.class);
    }
}
