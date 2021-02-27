package com.example.study.model;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data //lombok을 연결 (플러그인 설치 후 build gradle에 lombok의 대한 소스를 넣으면 사용 가능)
@AllArgsConstructor //모든 아규먼트를 가진 생성자를 추가 한다고 한다면
public class SearchParam {

    private String account;
    private String email;
    private int page;

    //{ "account" : "", "email" : "", "page" : 0}


    /*
    //해당 파라미터를 받기 위해서는 get,set메소드와 생성자가 있어야 함
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    
    //생성자 메소드 추가
    public SearchParam() {

    }

    //생성자 메소드에 필요한 매개변수를 추가
    public SearchParam(String account, String email, int page) {
        this.account = account;
        this.email = email;
        this.page = page;
    }

    //필요한 부분의 매개변수만을 넣어서 사용
    public SearchParam(String account) {
        this.account = account;
    }
    */



}
