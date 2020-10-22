package com.warkoczewski.AgroAdventureBooking.util;

public final  class Mappings {

    public static final String MARKER = "marker";
    public static final String MARKERS = "markers";
    public static final String MARKERS_REGION = "markers/{region}";
    public static final String FARM = "farm/farm/{name}";
    public static final String SEARCH_FARMS = "farm/searchFarms";
    public static final String CREATE_LOCATION = "createLocation";
    public static final String REGISTRATION_FORM = "register/registrationForm";
    public static final String LOGIN = "register/login";
    public static final String HOME = "home/homePage";
    public static final String ALL_FARMS = "farm/allFarms";
    public static final String BOOKING_PAGE = "booking/bookingPage";
    public static final String DELETE_BOOKING = "booking/delete/{booking_Id}";
    public static final String FARM_BOOKED = "booking/farmBooked";
    public static final String DELETE_FARM = "farm/delete/{farm_Id}";
    public static final String BOOKING_NOT_POSSIBLE = "booking/bookingNotPossible";

    public Mappings() {
    }
}
