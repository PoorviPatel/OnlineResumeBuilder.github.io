package com.example.poorvi.slidertablayout;

/**
 * Created by Poorvi on 12-11-2017.
 */

public class DbResponsePersonal {
    String _dob;
    String _marital_status;
    String _hobbies;
    String _gender;
    String _add_other_info_p;

    public String get_dob() {
        return _dob;
    }

    public void set_dob(String _dob) {
        this._dob = _dob;
    }

    public String get_marital_status() {
        return _marital_status;
    }

    public void set_marital_status(String _marital_status) {
        this._marital_status = _marital_status;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public String get_hobbies() {
        return _hobbies;
    }

    public void set_hobbies(String _hobbies) {
        this._hobbies = _hobbies;
    }

    public String get_add_other_info_p() {
        return _add_other_info_p;
    }

    public void set_add_other_info_p(String _add_other_info) {
        this._add_other_info_p = _add_other_info;
    }
}
