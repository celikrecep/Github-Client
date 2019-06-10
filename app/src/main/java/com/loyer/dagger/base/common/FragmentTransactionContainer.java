package com.loyer.dagger.base.common;

import androidx.annotation.Nullable;

/**
 * Created by celikrecep on 10.06.2019.
 */
public class FragmentTransactionContainer {

    public enum TransactionType{
        ADD,
        REPLACE
    }

    private TransactionType transactionType;
    private boolean isBackStack;
    private String backStackTag;
    private int layoutId;
    private boolean hasAnimation;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public boolean isBackStack() {
        return isBackStack;
    }

    public void setBackStack(boolean backStack) {
        isBackStack = backStack;
    }

    public String getBackStackTag() {
        return backStackTag;
    }

    public void setBackStackTag(String backStackTag) {
        this.backStackTag = backStackTag;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public boolean isHasAnimation() {
        return hasAnimation;
    }

    public void setHasAnimation(boolean hasAnimation) {
        this.hasAnimation = hasAnimation;
    }


    public static class Builder{

        TransactionType transactionType;
        boolean isBackStack;
        String backStackTag;
        int layoutId;
        boolean hasAnimation;

        public Builder(){
            transactionType = TransactionType.ADD;
            isBackStack = false;
            backStackTag = null;
            layoutId = -1;
            hasAnimation = false;
        }

        public Builder setTransactionType(TransactionType type){
            this.transactionType = type;
            return this;
        }

        public Builder setBackState(boolean isBackStack, @Nullable String backStackTag){
            this.backStackTag = backStackTag;
            this.isBackStack = isBackStack;
            return this;
        }

        public Builder setLayoutId(int layoutId){
            this.layoutId = layoutId;
            return this;
        }

        public Builder setHasAnimation(boolean hasAnimation){
            this.hasAnimation = hasAnimation;
            return this;
        }

        public FragmentTransactionContainer build(){
            FragmentTransactionContainer container = new FragmentTransactionContainer();
            container.setBackStack(isBackStack);
            container.setBackStackTag(backStackTag);
            container.setHasAnimation(hasAnimation);
            container.setLayoutId(layoutId);
            container.setTransactionType(transactionType);
            return container;
        }

    }
}
