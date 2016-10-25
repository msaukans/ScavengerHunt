package com.sample.maris.scavengerhunt;



public class Player {
    int _id;
    String _fName;
    String _lName;
    int _score;
    //double loc; //location of player - implement later on
    //String email;
    //

    public Player(int id, String fName, String lName, int score){
        this._score = score;
        this._fName = fName;
        this._lName = lName;
        this._score = score;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _Id) {
        this._id = _Id;
    }

    public int get_score() {
        return _score;
    }

    public void set_score(int _score) {
        this._score = _score;
    }

    public String get_fName() {
        return _fName;
    }

    public void set_fName(String _fName) {
        this._fName = _fName;
    }

    public String get_lName() {
        return _lName;
    }

    public void set_lName(String _lName) {
        this._lName = _lName;
    }
}
