package com.room.scapez.pojos;

/**
 * Created by snyxius on 9/25/2015.
 */
public class CheckinCheckout {
    public int CheckinDate,CheckinYear,CheckoutDate,CheckoutYear;
    public String CheckinMonth,CheckinWeek,CheckoutMonth,CheckoutWeek;

    public int getCheckinDate() {
        return CheckinDate;
    }

    public void setCheckinDate(int checkinDate) {
        CheckinDate = checkinDate;
    }

    public int getCheckinYear() {
        return CheckinYear;
    }

    public void setCheckinYear(int checkinYear) {
        CheckinYear = checkinYear;
    }

    public int getCheckoutDate() {
        return CheckoutDate;
    }

    public void setCheckoutDate(int checkoutDate) {
        CheckoutDate = checkoutDate;
    }

    public int getCheckoutYear() {
        return CheckoutYear;
    }

    public void setCheckoutYear(int checkoutYear) {
        CheckoutYear = checkoutYear;
    }

    public String getCheckinMonth() {
        return CheckinMonth;
    }

    public void setCheckinMonth(String checkinMonth) {
        CheckinMonth = checkinMonth;
    }

    public String getCheckinWeek() {
        return CheckinWeek;
    }

    public void setCheckinWeek(String checkinWeek) {
        CheckinWeek = checkinWeek;
    }

    public String getCheckoutMonth() {
        return CheckoutMonth;
    }

    public void setCheckoutMonth(String checkoutMonth) {
        CheckoutMonth = checkoutMonth;
    }

    public String getCheckoutWeek() {
        return CheckoutWeek;
    }

    public void setCheckoutWeek(String checkoutWeek) {
        CheckoutWeek = checkoutWeek;
    }
}
