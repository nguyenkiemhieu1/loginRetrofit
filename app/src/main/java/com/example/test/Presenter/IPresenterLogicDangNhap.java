package com.example.test.Presenter;

import com.example.test.Model.User;
import com.example.test.View.ViewDangNhap;

public class IPresenterLogicDangNhap implements IPresenterUser {
    ViewDangNhap viewDangNhap;

    public  IPresenterLogicDangNhap(ViewDangNhap viewDangNhap){
        this.viewDangNhap = viewDangNhap;
    }
    @Override
    public void DangNhapThanhCong() {

            viewDangNhap.dangnhapthanhcong();

    }


    @Override
    public void ThatBai() {

        viewDangNhap.dangnhapthatbai();
    }
}
