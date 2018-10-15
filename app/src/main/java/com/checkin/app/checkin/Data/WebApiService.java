package com.checkin.app.checkin.Data;

import com.checkin.app.checkin.Menu.MenuModel;
import com.checkin.app.checkin.Notifications.NotificationModel;
import com.checkin.app.checkin.Session.ActiveSessionModel;
import com.checkin.app.checkin.Shop.ShopModel;
import com.checkin.app.checkin.Shop.ShopReview;
import com.checkin.app.checkin.Social.Message;
import com.checkin.app.checkin.User.PrivateProfile.FriendshipModel;
import com.checkin.app.checkin.User.UserModel;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebApiService {
    @POST("auth/login/")
    Call<ObjectNode> postLogin(@Body ObjectNode credentials);

    @POST("auth/register/")
    Call<ObjectNode> postRegister(@Body ObjectNode credentials);

    @PUT("auth/devices/self/update/")
    Call<ObjectNode> postFCMToken(@Body ObjectNode tokenData);

    @GET("users/")
    Call<List<UserModel>> getUsers();

    @POST("qr/decrypt/")
    Call<ObjectNode> postDecryptQr(@Body ObjectNode data);

    @GET("users/{user_id}/sessions/active/")
    Call<ActiveSessionModel> getActiveSession(@Path("user_id") String userID);

    @GET("shops/{shop_id}/")
    Call<ShopModel> getShopDetails(@Path("shop_id") long shopId);

    @GET("shops/{shop_id}/menus/available/")
    Call<MenuModel> getAvailableMenu(@Path("shop_id") String shopID);

    @GET("shops/{shop_id}/reviews/")
    Call<List<ShopReview>> getShopReviews(@Path("shop_id") String shopID);

    @POST("sessions/{session_id}/orders/cancel/")
    Call<ObjectNode> postCancelOrder(@Path("session_id") String sessionID, @Body ObjectNode data);

    @POST("sessions/{session_id}/customers/add/")
    Call<ObjectNode> postSessionAddMember(@Path("session_id") String sessionID, @Body ObjectNode data);

    @GET("notification")
    Call<List<NotificationModel>> getNotif(@Query("last_notif_id") int lastNotifId);

    @PATCH("users/self/")
    Call<ObjectNode> postUserData(@Body ObjectNode objectNode);

    @PATCH("blah/blah/blah")
    Call<ObjectNode> postPhoneNumber(@Body ObjectNode objectNode);

    @GET("messages/{user_id}/")
    Call<List<Message>> getMessages(@Path("user_id") String userId);

    @GET("friends/self/")
    Call<List<FriendshipModel>> getSelfFriends();

    @GET("friends/{user_pk}")
    Call<List<FriendshipModel>> getUserFriends(@Path("user_pk") Long userPk);

    @DELETE("friends/remove/{user_pk}/")
    Call<ObjectNode> removeFriend(@Path("user_pk") Long userPk);

    @POST("friends/requests/{request_pk}/accept/")
    Call<ObjectNode> postNewFriends(@Path("request_pk") Long userPk);
}