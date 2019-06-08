package com.loyer.dagger.rx;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class DifferentObservable {
    private int diffType;
    private int position;

    public DifferentObservable(int type){
        diffType = type;
    }

    public DifferentObservable(int type, int position){
        diffType = type;
        position = position;
    }


    public int getDiffType() {
        return diffType;
    }

    public int getPosition() {
        return position;
    }

}
